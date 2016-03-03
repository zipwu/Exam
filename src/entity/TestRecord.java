package entity;

import java.util.Date;

public class TestRecord {
	private int ID;
	private String Username;
	private String Name;
	private int QuestionID;
	private String Question;
	private boolean Result;
	private Date DateTime;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getQuestionID() {
		return QuestionID;
	}
	public void setQuestionID(int questionID) {
		QuestionID = questionID;
	}
	public String getQuestion() {
		return Question;
	}
	public void setQuestion(String question) {
		Question = question;
	}
	public boolean isResult() {
		return Result;
	}
	public void setResult(boolean result) {
		Result = result;
	}
	public Date getDateTime() {
		return DateTime;
	}
	public void setDateTime(Date dateTime) {
		DateTime = dateTime;
	}
	

}
