package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.DBHelper;
import entity.Question;

public class QuestionDao {
	private Connection connection = null;
	private PreparedStatement statement = null;
	private ResultSet resultSet = null;
	private DBHelper dbHelper = new DBHelper();
	
	public ArrayList<Question> getAllQuestions(){
		ArrayList<Question> list = new ArrayList<Question>();
		try {
			connection = dbHelper.getConnection();
			String sql = "SELECT * FROM exam_01;";
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Question question = new Question();
				question.setID(Integer.parseInt(resultSet.getString("ID")));
				question.setType(resultSet.getNString("QType"));
				question.setQuestionString(resultSet.getString("Question"));
				question.setChoiceA(resultSet.getString("ChoiceA"));
				question.setChoiceB(resultSet.getString("ChoiceB"));
				question.setChoiceC(resultSet.getString("ChoiceC"));
				question.setAnswer(resultSet.getString("Answer"));
				question.setKeyword0(resultSet.getString("Keyword0"));
				question.setKeyword1(resultSet.getString("Keyword1"));
				list.add(question);
			}
			return list;
		} catch (Exception e) {
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
				};
			}
		}	
	}
	
	public ArrayList<Integer> getAllQuestionsID(){
		ArrayList<Integer> iDlist = new ArrayList<Integer>();
		try {
			connection = dbHelper.getConnection();
			String sql = "SELECT ID FROM exam_01;";
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				iDlist.add(new Integer(resultSet.getString("ID")));
			}
			return iDlist;
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
				};
			}
		}
	}
	
	public ArrayList<Integer> getAllQuestionsID(ArrayList<Question> list){
		ArrayList<Integer> iDlist = new ArrayList<Integer>();
		if (list!=null&&list.size()>0) {
			for (int i = 0; i < list.size(); i++) {
				iDlist.add(new Integer(list.get(i).getID()));
			}
		}
		return iDlist;
	}
	
	public String getAnswerByID(int ID,ArrayList<Question> list)
	{
		return list.get(ID).getAnswer();
	}
	
	public String getAnswerByID(int ID)
	{
		try {
			connection = dbHelper.getConnection();
			String sql = "SELECT * FROM exam_01 WHERE ID = ?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, ID);
			resultSet = statement.executeQuery();
			if (resultSet!=null) {
				if(resultSet.next()) {
					String Answer = resultSet.getString("Answer");
					return Answer;
				}
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
					e.printStackTrace();
				};
			}
		}
		return null;
	}
	 
	public String getQuestionByID(int ID)
	{
		try {
			connection = dbHelper.getConnection();
			String sql = "SELECT * FROM exam_01 WHERE ID = ?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, ID);
			resultSet = statement.executeQuery();
			if (resultSet!=null) {
				if(resultSet.next()) {
					String Question = resultSet.getString("Question");
					return Question;
				}
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
					e.printStackTrace();
				};
			}
		}
		return null;
	}
	
	public ArrayList<Question> getQuestionsByKeyword0(String Keyword)
	{
		ArrayList<Question> list =  new  ArrayList<Question>();
		try {
			connection = dbHelper.getConnection();
			String sql = "SELECT * FROM exam_01 WHERE Keyword0 = ?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, Keyword);
			resultSet = statement.executeQuery();
			while(resultSet.next()) {
				Question question = new Question();
				question.setID(Integer.parseInt(resultSet.getString("ID")));
				question.setType(resultSet.getNString("QType"));
				question.setQuestionString(resultSet.getString("Question"));
				question.setChoiceA(resultSet.getString("ChoiceA"));
				question.setChoiceB(resultSet.getString("ChoiceB"));
				question.setChoiceC(resultSet.getString("ChoiceC"));
				question.setAnswer(resultSet.getString("Answer"));
				question.setKeyword0(resultSet.getString("Keyword0"));
				question.setKeyword1(resultSet.getString("Keyword1"));
				list.add(question);
			}
			return list;
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
					e.printStackTrace();
				};
			}
		}
	}
	
	public ArrayList<Question> getQuestionsByKeyword1(String Keyword)
	{
		ArrayList<Question> list =  new  ArrayList<Question>();
		try {
			connection = dbHelper.getConnection();
			String sql = "SELECT * FROM exam_01 WHERE Keyword1 = ?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, Keyword);
			resultSet = statement.executeQuery();
			while(resultSet.next()) {
				Question question = new Question();
				question.setID(Integer.parseInt(resultSet.getString("ID")));
				question.setType(resultSet.getNString("QType"));
				question.setQuestionString(resultSet.getString("Question"));
				question.setChoiceA(resultSet.getString("ChoiceA"));
				question.setChoiceB(resultSet.getString("ChoiceB"));
				question.setChoiceC(resultSet.getString("ChoiceC"));
				question.setAnswer(resultSet.getString("Answer"));
				question.setKeyword0(resultSet.getString("Keyword0"));
				question.setKeyword1(resultSet.getString("Keyword1"));
				list.add(question);
			}
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
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
				};
			}
		}
	}
	
	public ArrayList<Question> getQuestionsByNotKeyword0(String Keyword)
	{
		ArrayList<Question> list =  new  ArrayList<Question>();
		try {
			connection = dbHelper.getConnection();
			String sql = "SELECT * FROM exam_01 WHERE Keyword0 != ?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, Keyword);
			resultSet = statement.executeQuery();
			while(resultSet.next()) {
				Question question = new Question();
				question.setID(Integer.parseInt(resultSet.getString("ID")));
				question.setType(resultSet.getNString("QType"));
				question.setQuestionString(resultSet.getString("Question"));
				question.setChoiceA(resultSet.getString("ChoiceA"));
				question.setChoiceB(resultSet.getString("ChoiceB"));
				question.setChoiceC(resultSet.getString("ChoiceC"));
				question.setAnswer(resultSet.getString("Answer"));
				question.setKeyword0(resultSet.getString("Keyword0"));
				question.setKeyword1(resultSet.getString("Keyword1"));
				list.add(question);
			}
			return list;
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
					e.printStackTrace();
				};
			}
		}
	}
	public String getKeyword0ById(int ID){
		try {
			connection = dbHelper.getConnection();
			String sql = "SELECT * FROM exam_01 WHERE ID = ?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, ID);
			resultSet = statement.executeQuery();
			if (resultSet!=null) {
				if(resultSet.next()) {
					String Keyword0 = resultSet.getString("Keyword0");
					return Keyword0;
				}
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
					e.printStackTrace();
				};
			}
		}
		return null;
	}
	
	public boolean isConnected()
	{	
		if (connection!=null) {
			return true;
		}else{
			return false;
		}
	}
	
	public static void main(String[] args) {
		QuestionDao questionDao = new QuestionDao();
		ArrayList<Question> list = new ArrayList<Question>();
		list = questionDao.getQuestionsByNotKeyword0("应急预案");
		if (list!=null&&list.size()>0) {
			ArrayList<Integer> IDlist = new ArrayList<Integer>();
			for (int i = 0; i < list.size(); i++) {
				Question question = list.get(i);
				IDlist.add(Integer.valueOf(question.getID()));
				System.out.println("*****************START*****************");
				System.out.println(question.getID()+"."+question.getQuestionString());
				System.out.println("A."+question.getChoiceA());
				System.out.println("B."+question.getChoiceB());
				System.out.println("C."+question.getChoiceC());
				System.out.println(question.getAnswer());
				System.out.println(question.getKeyword0());
				System.out.println(question.getKeyword1());
				System.out.println("*****************END*****************");
			}
		}
		
		System.out.println(questionDao.isConnected());
		
		ArrayList<Integer> iDlist = questionDao.getAllQuestionsID();
		if (iDlist!=null&&iDlist.size()>0) {
			for (int i = 0; i < iDlist.size(); i++) {
				System.out.println(iDlist.get(i).intValue());
			}
		}
		String answer = questionDao.getAnswerByID(141);
		System.out.println(answer);
	}
}
