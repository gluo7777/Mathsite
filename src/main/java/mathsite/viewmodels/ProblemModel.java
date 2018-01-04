package mathsite.viewmodels;

import java.util.List;

public class ProblemModel {
	List<String> stringList;
	String textString;
	String userAnswer;
	String correctAnswer;

	public ProblemModel() {
	}

	public final List<String> getStringList() {
		return stringList;
	}

	public final void setStringList(List<String> stringList) {
		this.stringList = stringList;
	}

	public final String getTextString() {
		return textString;
	}

	public final void setTextString(String textString) {
		this.textString = textString;
	}

	public final String getUserAnswer() {
		return userAnswer;
	}

	public final void setUserAnswer(String userAnswer) {
		this.userAnswer = userAnswer;
	}

	public final String getCorrectAnswer() {
		return correctAnswer;
	}

	public final void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

}
