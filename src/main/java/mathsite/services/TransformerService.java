package mathsite.services;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.apache.commons.math3.fraction.Fraction;
import org.springframework.stereotype.Service;

import mathproblems.generator.Operation;
import mathproblems.generator.problem.Problem;
import mathsite.beans.Setting;
import mathsite.viewmodels.ProblemModel;
import mathsite.viewmodels.SettingModel;

@Service
public class TransformerService {
	public Setting settingViewToObject(SettingModel model) {
		Setting setting = new Setting();
		setting.setMinDigit(model.getMinDigit());
		setting.setMaxDigit(model.getMaxDigit());
		setting.setMinOperands(model.getMinOperands());
		setting.setMaxOperands(model.getMaxOperands());
		setting.setProblemCount(model.getProblemCount());
		setting.setMixMode(model.isMixMode());
		int op = 0;
		for (Operation operation : Operation.getOperations()) {
			setting.getFrequency().put(operation, model.getFrequencies()[op++]);
		}
		return setting;
	}

	public SettingModel settingObjectToView(Setting setting) {
		SettingModel settingModel = new SettingModel();
		settingModel.setMinDigit(setting.getMinDigit());
		settingModel.setMaxDigit(setting.getMaxDigit());
		settingModel.setMinOperands(setting.getMinOperands());
		settingModel.setMaxOperands(setting.getMaxOperands());
		settingModel.setProblemCount(setting.getProblemCount());
		settingModel.setMixMode(setting.isMixMode());
		int frequencies[] = new int[setting.getFrequency().size()];
		Set<Operation> set = setting.getFrequency().keySet();
		int i = 0;
		for (Operation op : set) {
			frequencies[i++] = setting.getFrequency().get(op);
		}
		return settingModel;
	}

	public <T> void problemObjectToView(Problem<T> problem, ProblemModel problemModel) {
		problemModel.setStringList(generateStringList(problem));
		problemModel.setCorrectAnswer(transformProblemAnswerObjectToString(problem.getResult()));
	}

	@SuppressWarnings("unchecked")
	public <T> void problemViewToObject(Problem<T> problem, ProblemModel problemModel) {
		T answer = (T) transformProblemAnswerStringToObject(problemModel.getUserAnswer(),
				problem.getAnswer().getClass());
		problem.setAnswer(answer);
	}

	public <T> List<ProblemModel> problemObjectToViewList(List<Problem<T>> problems) {
		List<ProblemModel> problemModels = new LinkedList<>();
		for (Problem<T> problem : problems) {
			ProblemModel problemModel = new ProblemModel();
			problemModel.setStringList(generateStringList(problem));
		}
		return problemModels;
	}

	public <T> void problemResultObjectToViewList(List<Problem<T>> problems, List<ProblemModel> problemModels) {
		for (int i = 0; i < problems.size(); i++) {
			problemModels.get(i).setCorrectAnswer(transformProblemAnswerObjectToString(problems.get(i).getResult()));
		}
	}

	@SuppressWarnings("unchecked")
	public <T> void problemAnswerViewToObjectList(List<ProblemModel> problemModels, List<Problem<T>> problems) {
		for (int i = 0; i < problems.size(); i++) {
			Problem<T> p = problems.get(i);
			T answer = (T) transformProblemAnswerStringToObject(problemModels.get(i).getUserAnswer(),
					p.getAnswer().getClass());
			p.setAnswer(answer);
		}
	}

	private <T> String transformProblemAnswerObjectToString(T obj) {
		if (obj instanceof BigDecimal) {
			return ((BigDecimal) obj).toString();
		} else if (obj instanceof Fraction) {
			return ((Fraction) obj).toString();
		}
		return null;
	}

	private <T> T transformProblemAnswerStringToObject(String ans, Class<T> type) {
		if (type.equals(BigDecimal.class)) {
			return type.cast(new BigDecimal(ans));
		} else if (type.equals(Fraction.class)) {
			String str[] = ans.split("/");
			int numerator = Integer.parseInt(str[0]);
			int denominator = str.length > 1 ? Integer.parseInt(str[1]) : 1;
			return type.cast(new Fraction(numerator, denominator));
		}
		return null;
	}

	private <T> List<String> generateStringList(Problem<T> problem) {
		List<String> list = new LinkedList<>();
		list.add(problem.getOperands()[1].toString());
		for (int i = 0; i < problem.getOperands().length; i++) {
			list.add(problem.getOperations()[i].getValue());
			list.add(problem.getOperands()[i + 1].toString());
		}
		return list;
	}

}
