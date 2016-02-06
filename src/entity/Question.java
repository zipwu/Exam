package entity;

public class Question implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	private int ID;
	private String Type;
	private String QuestionString;
	private String ChoiceA;
	private String ChoiceB;
	private String ChoiceC;
	private String Answer;
	private String Keyword0;
	private String Keyword1;
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public String getQuestionString() {
		return QuestionString;
	}
	public void setQuestionString(String questionString) {
		QuestionString = questionString;
	}
	public String getChoiceA() {
		return ChoiceA;
	}
	public void setChoiceA(String choiceA) {
		ChoiceA = choiceA;
	}
	public String getChoiceB() {
		return ChoiceB;
	}
	public void setChoiceB(String choiceB) {
		ChoiceB = choiceB;
	}
	public String getChoiceC() {
		return ChoiceC;
	}
	public void setChoiceC(String choiceC) {
		ChoiceC = choiceC;
	}
	public String getAnswer() {
		return Answer;
	}
	public void setAnswer(String answer) {
		Answer = answer;
	}
	public String getKeyword0() {
		return Keyword0;
	}
	public void setKeyword0(String keyword0) {
		Keyword0 = keyword0;
	}
	public String getKeyword1() {
		return Keyword1;
	}
	public void setKeyword1(String keyword1) {
		Keyword1 = keyword1;
	}

	
	
}
