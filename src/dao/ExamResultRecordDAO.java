package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import entity.TestRecord;
import entity.User;
import entity.UserScoreRecord;
import util.DBHelper;

public class ExamResultRecordDAO {
	
	private Connection connection = null;
	private PreparedStatement statement = null;
	DBHelper dbHelper = new DBHelper();
	private ResultSet resultSet = null;
	
	public void insertExamResult(User user,int ID,boolean result)
	{
		try {
			connection = dbHelper.getConnection();
			String sql = "INSERT INTO test_record (Username,Name,QuestionID,Question,Result,DateTime) VALUES(?,?,?,?,?,?);";
			Date date = new Date();
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String dateString = format.format(date);
			String Username = user.getUsername();
			String Name = user.getName();
			QuestionDao questionDao = new QuestionDao();
			String Question = questionDao.getQuestionByID(ID);
			statement = connection.prepareStatement(sql);
			statement.setString(1, Username);
			statement.setString(2, Name);
			statement.setInt(3,ID);
			statement.setString(4, Question);
			statement.setBoolean(5, result);
			statement.setString(6, dateString);
			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				dbHelper.close(null, statement, null, null, connection);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public ArrayList<UserScoreRecord> getALLScoreRecordByUsername(String username){
		ArrayList<UserScoreRecord> scoreRecords = new ArrayList<UserScoreRecord>();
		try {
			connection = dbHelper.getConnection();
			String sql = "SELECT * FROM score WHERE Username = ?;";
			statement = connection.prepareStatement(sql);
			statement.setString(1, username);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				UserScoreRecord userScoreRecord = new UserScoreRecord();
				userScoreRecord.setID(resultSet.getInt("ID"));
				userScoreRecord.setUsername(username);
				userScoreRecord.setName(resultSet.getString("Name"));
				userScoreRecord.setScore(resultSet.getShort("Score"));
				userScoreRecord.setDate(resultSet.getString("Date"));
				scoreRecords.add(userScoreRecord);
			}
			return scoreRecords;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		finally{
			if (resultSet!=null) {
				try {
					resultSet.close();
					resultSet=null;
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (statement!=null) {
				try {
					statement.close();
					statement = null;
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			if (connection!=null) {
				dbHelper.close();
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public ArrayList<TestRecord> getAllTestRecordByUsername(String username,boolean result)
	{
		ArrayList<TestRecord> testRecords = new ArrayList<TestRecord>();
		try {
			connection = dbHelper.getConnection();
			String sql = "SELECT * FROM test_record WHERE Username = ? AND Result = ?;";
			statement = connection.prepareStatement(sql);
			statement.setString(1, username);
			statement.setBoolean(2, result);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				TestRecord testRecord = new TestRecord();
				testRecord.setID(resultSet.getInt("ID"));
				testRecord.setUsername(username);
				testRecord.setName(resultSet.getString("Name"));
				testRecord.setQuestionID(resultSet.getInt("QuestionID"));
				testRecord.setQuestion(resultSet.getString("Question"));
				testRecord.setResult(resultSet.getBoolean("Result"));
				testRecord.setDateTime(resultSet.getDate("DateTime"));
				testRecords.add(testRecord);
			}
			return testRecords;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		finally{
			if (resultSet!=null) {
				try {
					resultSet.close();
					resultSet=null;
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (statement!=null) {
				try {
					statement.close();
					statement = null;
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			if (connection!=null) {
				dbHelper.close();
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		ExamResultRecordDAO eRecordDAO = new ExamResultRecordDAO();
		ArrayList<UserScoreRecord> userScoreRecords = eRecordDAO.getALLScoreRecordByUsername("wujiaye");
		ArrayList<TestRecord> userTestRecord = eRecordDAO.getAllTestRecordByUsername("wujiaye",false);
		for (int i = 0; i < userScoreRecords.size(); i++) {
			System.out.println(userScoreRecords.get(i).getUsername()+","+userScoreRecords.get(i).getDate()+","+userScoreRecords.get(i).getScore());
		}
		
		for (int i = 0; i < userTestRecord.size(); i++) {
			System.out.println(userTestRecord.get(i).getUsername()+","+userTestRecord.get(i).getQuestion()+","+userTestRecord.get(i).isResult());
		}
	}

}
