package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.servlet.ServletUtilities;

import util.IsRight;
import dao.ExamResultRecordDAO;
import dao.JFreeChartDao;
import dao.QuestionDao;
import dao.ScoreRecordDAO;
import entity.PieChartData;
import entity.Question;
import entity.User;


public class SubmitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		double count = 0;
		HashMap<String, Integer> AllKeywordMap = new HashMap<String, Integer>();
		HashMap<String, Integer> RightKeywordMap = new HashMap<String, Integer>();
		User user = (User) request.getSession().getAttribute("user");
		Enumeration<String> e =request.getParameterNames();
		String parameterName = null;
		while(e.hasMoreElements()){
		parameterName = (String) e.nextElement();
		if (request.getParameterValues(parameterName)!=null) {
			System.out.println(parameterName);
			QuestionDao questionDao = new QuestionDao();
			String answerString = questionDao.getAnswerByID(Integer.parseInt(parameterName));
			String[] options	=	(String[])request.getParameterValues(parameterName);
			ExamResultRecordDAO examResultRecordDAO = new ExamResultRecordDAO();
			if (IsRight.isTrue(options, answerString)) {
				count += 1;
				if (!RightKeywordMap.containsKey(questionDao.getKeyword0ById(Integer.parseInt(parameterName)))) {
					RightKeywordMap.put(questionDao.getKeyword0ById(Integer.parseInt(parameterName)), 1);
				}
				else {
					RightKeywordMap.put(questionDao.getKeyword0ById(Integer.parseInt(parameterName)), RightKeywordMap.get(questionDao.getKeyword0ById(Integer.parseInt(parameterName)))+1);
				}
				examResultRecordDAO.insertExamResult(user, Integer.parseInt(parameterName), true);
			}else {
				count += 0;
				examResultRecordDAO.insertExamResult(user, Integer.parseInt(parameterName), false);
				}
		}
		System.out.println(count);
		}
		Double score = count * 2.5;
		request.getSession().setAttribute("score", score);
		request.getSession().setAttribute("count", count);
		
		@SuppressWarnings("unchecked")
		ArrayList<Question> QuestionList = (ArrayList<Question>) request.getSession().getAttribute("QuestionList");
		for (int i = 0; i < QuestionList.size(); i++) {
			if (!AllKeywordMap.containsKey(QuestionList.get(i).getKeyword0())) {
				AllKeywordMap.put(QuestionList.get(i).getKeyword0(), 1);
			}
			else {
				AllKeywordMap.put(QuestionList.get(i).getKeyword0(), AllKeywordMap.get(QuestionList.get(i).getKeyword0())+1);
			}
		}
		
		
		ArrayList<PieChartData> pieChartDatas = new ArrayList<PieChartData>();
		for(Entry<String, Integer> entry:AllKeywordMap.entrySet()){
			PieChartData pData = new PieChartData();
			pData.setKeyString(entry.getKey());
			pData.setValueDouble(Double.valueOf(String.valueOf(entry.getValue())));
			pieChartDatas.add(pData);
		}
		
		if (count>0) {
			ArrayList<PieChartData> RightPieChartDatas = new ArrayList<PieChartData>();
			for(Entry<String, Integer> entry:RightKeywordMap.entrySet()){
				PieChartData pData = new PieChartData();
				pData.setKeyString(entry.getKey());
				pData.setValueDouble(Double.valueOf(String.valueOf(entry.getValue())));
				RightPieChartDatas.add(pData);
			}
			JFreeChartDao jFreeChartDao = new JFreeChartDao();
			JFreeChart RightChart = jFreeChartDao.PieChart(RightPieChartDatas, "答对题目关键词分布");
			String RightfilenamePie = ServletUtilities.saveChartAsPNG(RightChart, 700, 500, null, request.getSession());
			String RightgraphURLPie = request.getContextPath() + "/DisplayChart?filename=" + RightfilenamePie;
			System.out.println(RightgraphURLPie);
			request.getSession().setAttribute("RightgraphURLPie", RightgraphURLPie);
		}
		
		
		JFreeChartDao jFreeChartDao = new JFreeChartDao();
		JFreeChart pieChart = jFreeChartDao.PieChart(pieChartDatas, "抽取题目关键词分布");
		String filenamePie = ServletUtilities.saveChartAsPNG(pieChart, 700, 500, null, request.getSession());
		String graphURLPie = request.getContextPath() + "/DisplayChart?filename=" + filenamePie;
		System.out.println(graphURLPie);
		request.getSession().setAttribute("graphURLPie", graphURLPie);
		
		
		
		
		ScoreRecordDAO scoreRecordDAO = new ScoreRecordDAO();
		scoreRecordDAO.insertScoreRecord(user, score);
		response.sendRedirect("result.jsp");
	}

}
