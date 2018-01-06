package mathsite.services;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.math3.fraction.Fraction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mathproblems.generator.builders.CommonProblemBuilder;
import mathproblems.generator.builders.FractionProblemBuilder;
import mathproblems.generator.builders.SimpleProblemBuilder;
import mathproblems.generator.calculator.FractionCalculator;
import mathproblems.generator.calculator.SimpleCalculator;
import mathproblems.generator.problem.Problem;
import mathsite.beans.Setting;
import mathsite.viewmodels.ProblemModel;

@Service
public class GeneratorService {
	@Autowired
	private SimpleProblemBuilder simpleProblemBuilder;

	@Autowired
	private FractionProblemBuilder fractionProblemBuilder;

	@Autowired
	private SimpleCalculator simpleCalculator;

	@Autowired
	private FractionCalculator fractionCalculator;

	@PostConstruct
	private void init() {

	}

	public List<Problem<BigDecimal>> getSimpleProblemSet(Setting setting) {
		commonConfig(simpleProblemBuilder, setting);
		return simpleProblemBuilder.setNumberOfDigits(setting.getMinDigit(), setting.getMaxDigit()).buildProblemSet();
	}

	public List<Problem<Fraction>> getFractionProblemSet(Setting setting) {
		commonConfig(fractionProblemBuilder, setting);
		return fractionProblemBuilder.buildProblemSet();
	}

	public void solveSimpleProblems(List<Problem<BigDecimal>> problems, Setting setting) {
		simpleCalculator.calculate(problems);
	}

	public void solveFractionProblems(List<Problem<Fraction>> problems, Setting setting) {
		fractionCalculator.calculate(problems);
	}

	private void commonConfig(CommonProblemBuilder<?, ?> commonProblemBuilder, Setting setting) {
		commonProblemBuilder.setNumberOfOperands(setting.getMinOperands(), setting.getMaxOperands())
				.setNumberOfProblems(setting.getProblemCount()).setMixedMode(setting.isMixMode())
				.setSolveProblems(false).setFrequencies(setting.getFrequency());
	}

	public <T> void compareAndSolve(List<ProblemModel> problemModels, List<Problem<T>> problems, Setting setting) {
		if (problemModels.size() != problems.size())
			throw new RuntimeException("Cannot solve problems.");
		for (int i = 0; i < problems.size(); i++) {
			ProblemModel model = problemModels.get(i);
			Problem<T> problem = problems.get(i);
			
		}
	}
	
	

}
