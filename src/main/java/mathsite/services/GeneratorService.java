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
import mathsite.beans.Session;
import mathsite.beans.Setting;

@Service
public class GeneratorService {
	@Autowired
	private Session session;

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

	public List<Problem<BigDecimal>> getSimpleProblemSet() {
		Setting setting = session.getSetting();
		commonConfig(simpleProblemBuilder, setting);
		return simpleProblemBuilder.setNumberOfDigits(setting.getMinDigit(), setting.getMaxDigit())
				.buildProblemSet();
	}

	public List<Problem<Fraction>> getFractionProblemSet() {
		Setting setting = session.getSetting();
		commonConfig(fractionProblemBuilder, setting);
		return fractionProblemBuilder.buildProblemSet();
	}
	
	public void solveSimpleProblems(List<Problem<BigDecimal>> problems) {
		simpleCalculator.calculate(problems);
	}
	
	public void solveFractionProblems(List<Problem<Fraction>> problems) {
		fractionCalculator.calculate(problems);
	}

	private void commonConfig(CommonProblemBuilder<?, ?> commonProblemBuilder, Setting setting) {
		commonProblemBuilder.setNumberOfOperands(setting.getMinOperands(), setting.getMaxOperands())
				.setNumberOfProblems(setting.getProblemCount()).setMixedMode(setting.isMixMode())
				.setSolveProblems(false).setFrequencies(setting.getFrequency());
	}

}
