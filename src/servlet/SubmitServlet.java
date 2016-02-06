package servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.IsRight;
import dao.QuestionDao;
import dao.ScoreRecordDAO;
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
			if (IsRight.isTrue(options, answerString)) {
				count += 2.5;
			}else {
				count += 0;
				}
		}
		System.out.println(count);
		request.getSession().setAttribute("score", count);
		}
		ScoreRecordDAO scoreRecordDAO = new ScoreRecordDAO();
		scoreRecordDAO.insertScoreRecord(user, count);
		response.sendRedirect("result.jsp");
	}

}
