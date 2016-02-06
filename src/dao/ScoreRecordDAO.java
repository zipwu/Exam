package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import entity.User;
import entity.UserScoreRecord;
import util.DBHelper;

public class ScoreRecordDAO {
	
	private Connection connection = null;
	private PreparedStatement statement = null;
	private ResultSet resultSet = null;
	DBHelper dbHelper = new DBHelper();
	
	public ArrayList<UserScoreRecord> getAllScoreRecords()
	{
		ArrayList<UserScoreRecord> list = new ArrayList<UserScoreRecord>();
		try {
			connection = dbHelper.getConnection();
			String sql = "SELECT * FROM score;";
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				UserScoreRecord scoreRecord = new UserScoreRecord();
				scoreRecord.setID(resultSet.getInt(1));
				scoreRecord.setUsername(resultSet.getString(2));
				scoreRecord.setName(resultSet.getString(3));
				scoreRecord.setScore(resultSet.getInt(4));
				scoreRecord.setDate(resultSet.getString(5));
				list.add(scoreRecord);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			if (resultSet!=null) {
				try {
					resultSet.close();
					resultSet=null;
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}if (statement!=null) {
				try {
					statement.close();
					statement=null;
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}if (connection!=null) {
				try {
					connection.close();
					dbHelper.close();
					connection=null;
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return list;
	}
	public void insertScoreRecord(User user,double count)
	{
		try {
			connection = dbHelper.getConnection();
			String sql = "INSERT INTO score (Username,Name,Score,Date) VALUES(?,?,?,?);";
			Date date = new Date();
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String dateString = format.format(date);
			statement = connection.prepareStatement(sql);
			statement.setString(1, user.getUsername());
			statement.setString(2, user.getName());
			statement.setDouble(3, count);
			statement.setString(4, dateString);
			statement.executeUpdate();
			System.out.println("插入数据成功");
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if (statement!=null) {
				try {
					statement.close();
					statement=null;
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (connection!=null) {
				try {
					connection.close();
					dbHelper.close();
					connection=null;
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		User user = new User();
		user.setId(2);
		user.setName("吴家烨");
		user.setUsername("wujiaye");
		user.setPassword("wjy901226");
		
		ScoreRecordDAO scoreRecordDAO = new ScoreRecordDAO();
		
		ArrayList<UserScoreRecord> list = scoreRecordDAO.getAllScoreRecords();
		if (list!=null&&list.size()>0) {
			for (int i = 0; i < list.size(); i++) {
				UserScoreRecord scoreRecord = list.get(i);
				System.out.println(scoreRecord.getID()+" "+scoreRecord.getUsername()+" "+scoreRecord.getName()+" "+scoreRecord.getScore()+"  "+scoreRecord.getDate());
			}
		}
	}

}
