package util;

import java.util.ArrayList;
import java.util.Collections;

import dao.QuestionDao;
import entity.Question;

public class RandQuestionArray {
	
	public ArrayList<Question> getRandQuestionByKeyword(String keyword,int num)
	{
		ArrayList<Question> list =  new ArrayList<Question>();
		ArrayList<Question> tempList = new ArrayList<Question>();
		QuestionDao questionDao = new QuestionDao();
		tempList = questionDao.getQuestionsByKeyword0(keyword);
		Collections.shuffle(tempList);
		if (tempList!=null) {
			for (int i = 0; i <num; i++) {
				Question question = new Question();
				question = tempList.get(i);
				list.add(question);		
			}
			return list;
		}
		return null;
	}
	public ArrayList<Question> getRandQuestionByNotKeyword(String notkeyword,int num)
	{
		ArrayList<Question> list =  new ArrayList<Question>();
		ArrayList<Question> tempList = new ArrayList<Question>();
		QuestionDao questionDao = new QuestionDao();
		tempList = questionDao.getQuestionsByNotKeyword0(notkeyword);
		Collections.shuffle(tempList);//乱序
		if (tempList!=null) {
			for (int i = 0; i <num; i++) {
				Question question = new Question();
				question = tempList.get(i);
				list.add(question);		
			}
			return list;
		}
		return null;
	}

	public static void main(String[] args) {
		RandQuestionArray rArray = new RandQuestionArray();
		ArrayList<Question> list = rArray.getRandQuestionByKeyword("情景", 4);
		list.addAll(rArray.getRandQuestionByNotKeyword("情景", 36));
		Collections.shuffle(list);//乱序
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
				
	}

}
