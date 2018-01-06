package mathsite.viewmodels;

public class SettingModel {
	int minDigit;
	int maxDigit;
	int minOperands;
	int maxOperands;
	boolean mixMode;
	int problemCount;
	int frequencies[] = new int[4];
	String problemType;

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

	public final int[] getFrequencies() {
		return frequencies;
	}

	public final void setFrequencies(int[] frequencies) {
		this.frequencies = frequencies;
	}

	public final String getProblemType() {
		return problemType;
	}

	public final void setProblemType(String problemType) {
		this.problemType = problemType;
	}

}
