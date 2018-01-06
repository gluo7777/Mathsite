package mathsite.beans;

import java.util.LinkedHashMap;
import java.util.Map;

import mathproblems.generator.Operation;

public class Setting {

	// foreign / primary key
	String cookieId;
	int minDigit;
	int maxDigit;
	int minOperands;
	int maxOperands;
	boolean mixMode;
	int problemCount;
	ProblemType problemType;
	// will be a three column table in database
	Map<Operation, Integer> frequency = new LinkedHashMap<>();

	public final String getCookieId() {
		return cookieId;
	}

	public final void setCookieId(String cookieId) {
		this.cookieId = cookieId;
	}

	public final int getMinDigit() {
		return minDigit;
	}

	public final void setMinDigit(int minDigit) {
		this.minDigit = minDigit;
	}

	public final int getMaxDigit() {
		return maxDigit;
	}

	public final void setMaxDigit(int maxDigit) {
		this.maxDigit = maxDigit;
	}

	public final int getMinOperands() {
		return minOperands;
	}

	public final void setMinOperands(int minOperands) {
		this.minOperands = minOperands;
	}

	public final int getMaxOperands() {
		return maxOperands;
	}

	public final void setMaxOperands(int maxOperands) {
		this.maxOperands = maxOperands;
	}

	public final boolean isMixMode() {
		return mixMode;
	}

	public final void setMixMode(boolean mixMode) {
		this.mixMode = mixMode;
	}

	public final int getProblemCount() {
		return problemCount;
	}

	public final void setProblemCount(int problemCount) {
		this.problemCount = problemCount;
	}

	public final Map<Operation, Integer> getFrequency() {
		return frequency;
	}

	public final void setFrequency(Map<Operation, Integer> frequency) {
		this.frequency = frequency;
	}

	public final ProblemType getProblemType() {
		return problemType;
	}

	public final void setProblemType(ProblemType type) {
		this.problemType = type;
	}

}
