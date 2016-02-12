package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.RandQuestionArray;
import dao.UserDao;
import entity.Question;
import entity.User;

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			System.out.println(username+"  "+password.hashCode());
			String path = null;//初始化跳转页面的path
			UserDao userDao = new UserDao();//初始化用户数据访问对象实例
			User user = new User();//初始化用户实例
				if (userDao.isAllowed(username, password)) {
					path ="choose.jsp";
					user = userDao.getUserbyUsername(username);//通过用户数据访问对象实例，获取用户实例
					request.getSession().setAttribute("user", user);
					System.out.println(user.getName());//获得用户姓名，并输出。
					request.getSession().setAttribute("name", user.getName());//将用户姓名放入session中，以供其他页面调用
					request.getSession().setAttribute("role", user.getRole());//将用户的角色放入session中，以供其他页面调用
				}else {
					path = "index.jsp";
				}
				response.sendRedirect(path);
		} catch (Exception e) {
			System.out.println("登陆失败");
			String path = "index.jsp";
			response.sendRedirect(path);
		}
		RandQuestionArray rArray = new RandQuestionArray();
		ArrayList<Question> questionslist = new ArrayList<Question>();
		questionslist = rArray.getRandQuestionByKeyword("情景", 4);//抽取4道‘情景’题
		questionslist.addAll(rArray.getRandQuestionByNotKeyword("情景", 36));//抽取36道非‘情景’题
		Collections.shuffle(questionslist);//乱序
		request.getSession().setAttribute("QuestionList", questionslist);//将题目数组放入session，以供其他页面调用
				
	}
}
