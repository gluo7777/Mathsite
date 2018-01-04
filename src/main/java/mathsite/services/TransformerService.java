package mathsite.services;

import java.util.LinkedList;
import java.util.List;

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

	public <T> List<ProblemModel> problemObjectToViewList(List<Problem<T>> problems) {
		List<ProblemModel> problemModels = new LinkedList<>();
		for (Problem<T> problem : problems) {
			ProblemModel problemModel = new ProblemModel();
			problemModel.setStringList(generateStringList(problem));
		}
		return problemModels;
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
