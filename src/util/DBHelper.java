package util;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBHelper {
	private static final String DBDRIVER = "com.mysql.jdbc.Driver";
	private static final String DBURL = "jdbc:mysql://222.73.209.52:8899/test";
	private static final String DBUSER = "wujiaye";
	private static final String DBPASSWORD = "123456";
	private static Connection connection = null;
	
	public Connection getConnection() throws Exception
	{
		try {
			Class.forName(DBDRIVER);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (connection==null) {
			connection = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);
		}
		return connection;
	}
	public void close(ResultSet resultSet,
			PreparedStatement prepraredStatement,
			CallableStatement callableStatement, Statement statement,
			Connection connection) throws SQLException {
			if (resultSet != null){
				resultSet.close();
			}
			if (prepraredStatement!= null){
				prepraredStatement.close();
			}
			if (callableStatement!= null){
				callableStatement.close();
			}
			if (statement != null){
				statement.close();
			}
			if (connection != null){
				connection.close();
			}
	} 
	public void close()
	{
		if (connection!=null) {
			try {
				connection.close();
				connection=null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) throws SQLException {
		Connection connection = null;
		DBHelper dbHelper = new DBHelper();
		try {
		    connection = dbHelper.getConnection();
			if (connection!=null) {
				System.out.println("连接成功");
			}else {
				System.out.println("连接失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		dbHelper.close(null,null,null,null,connection);

		try {
		    connection = dbHelper.getConnection();
			if (connection!=null) {
				System.out.println(connection.toString());
				System.out.println("连接成功");
			}else {
				System.out.println("连接失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
