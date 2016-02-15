package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import entity.User;
import util.DBHelper;

public class ExamResultRecordDAO {
	
	private Connection connection = null;
	private PreparedStatement statement = null;
	DBHelper dbHelper = new DBHelper();
	
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

	public static void main(String[] args) {

	}

}
