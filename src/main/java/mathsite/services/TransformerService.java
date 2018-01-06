package mathsite.services;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.apache.commons.math3.fraction.Fraction;
import org.springframework.stereotype.Service;

import mathproblems.generator.Operation;
import mathproblems.generator.problem.Problem;
import mathsite.beans.ProblemType;
import mathsite.beans.Setting;
import mathsite.viewmodels.ProblemModel;
import mathsite.viewmodels.SettingModel;

@Service
public class TransformerService {
	/**
	 * Transforms user settings into a {@link Setting}
	 * @param model
	 * @return
	 */
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
		switch (model.getProblemType()) {
		case "Number":
			setting.setProblemType(ProblemType.NUMBER);
			break;
		case "Fraction":
			setting.setProblemType(ProblemType.FRACTION);
			break;
		default:
			throw new IllegalArgumentException(String.format("%s is not a valid problem type", model.getProblemType()));
		}
		return setting;
	}

	/**
	 * Transforms a {@link Setting} into a view object
	 * @param setting
	 * @return
	 */
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
		settingModel.setFrequencies(frequencies);
		switch (setting.getProblemType()) {
		case NUMBER:
			settingModel.setProblemType("Number");
			break;
		case FRACTION:
			settingModel.setProblemType("Fraction");
			break;
		default:
			throw new IllegalArgumentException();
		}
		return settingModel;
	}

	/**
	 * Creates a new list of view models from a list of problems
	 * 
	 * @param problems
	 * @return
	 */
	public <T> List<ProblemModel> problemObjectToViewList(List<Problem<T>> problems) {
		List<ProblemModel> problemModels = new LinkedList<>();
		for (Problem<T> problem : problems) {
			ProblemModel problemModel = new ProblemModel();
			problemModel.setStringList(generateStringList(problem));
			problemModel.setCorrectAnswer(problem.getResult() != null ? problem.getResult().toString() : "");
			problemModel.setUserAnswer(problem.getAnswer() != null ? problem.getAnswer().toString() : "");
			problemModels.add(problemModel);
		}
		return problemModels;
	}

	/**
	 * Store correct answer into a view
	 * @param problem
	 * @param problemModel
	 */
	public <T> void problemObjectToViewResult(Problem<T> problem, ProblemModel problemModel) {
		problemModel.setCorrectAnswer(transformProblemAnswerObjectToString(problem.getResult()));
	}
	
	/**
	 * Transform user's answer to a {@link BigDecimal} answer
	 * @param problem
	 * @param problemModel
	 */
	public void problemViewToObjectAnswerForNumber(Problem<BigDecimal> problem, ProblemModel problemModel) {
		problem.setAnswer(new BigDecimal(problemModel.getUserAnswer()));
	}
	
	/**
	 * Transform user's answer to a {@link Fraction} answer
	 * @param problem
	 * @param problemModel
	 */
	public void problemViewToObjectAnswerForFraction(Problem<Fraction> problem, ProblemModel problemModel) {
		String str[] = problemModel.getUserAnswer().split("/");
		int numerator = Integer.parseInt(str[0]);
		int denominator = str.length > 1 ? Integer.parseInt(str[1]) : 1;
		problem.setAnswer(new Fraction(numerator, denominator));
	}

	private <T> String transformProblemAnswerObjectToString(T obj) {
		if (obj instanceof BigDecimal) {
			return ((BigDecimal) obj).toString();
		} else if (obj instanceof Fraction) {
			return ((Fraction) obj).toString().replaceAll(" ", "");
		}
		return null;
	}

	private <T> List<String> generateStringList(Problem<T> problem) {
		List<String> list = new LinkedList<>();
		list.add(problem.getOperands()[0].toString());
		for (int i = 0; i < problem.getOperations().length; i++) {
			list.add(problem.getOperations()[i].getValue());
			list.add(problem.getOperands()[i + 1].toString());
		}
		return list;
	}

}
