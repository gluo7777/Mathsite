package mathsite.beans;

import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.math3.fraction.Fraction;

import mathproblems.generator.problem.Problem;

public class Session {
	List<Problem<Fraction>> fractionProblems;
	List<Problem<BigDecimal>> numberProblems;
	Setting setting;

	public final List<Problem<Fraction>> getFractionProblems() {
		return fractionProblems;
	}

	public final void setFractionProblems(List<Problem<Fraction>> fractionProblems) {
		this.fractionProblems = fractionProblems;
	}

	public final List<Problem<BigDecimal>> getNumberProblems() {
		return numberProblems;
	}

	public final void setNumberProblems(List<Problem<BigDecimal>> numberProblems) {
		this.numberProblems = numberProblems;
	}

	public final Setting getSetting() {
		return setting;
	}

	public final void setSetting(Setting setting) {
		this.setting = setting;
	}

}
