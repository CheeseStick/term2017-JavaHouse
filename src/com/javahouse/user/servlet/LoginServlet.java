package com.javahouse.user.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javahouse.user.dao.UserDAO;
import com.javahouse.user.vo.UserVO;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String JSP_TEMPLATE_FILENAME = "signin.jsp";

    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher(JSP_TEMPLATE_FILENAME).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		boolean hasError = false;
		ArrayList<String> errorMsgs = new ArrayList<String>();
		UserVO vo = new UserVO();
		
		if(email == null || !email.contains("@")) {
			hasError = true;
			errorMsgs.add("이메일이 올바르지 않습니다.");
		} else {
			vo.setEmail(email);
		}
		
		if(password == null) {
			hasError = true;
			errorMsgs.add("비밀번호가 입력되지 않았습니다.");
		} else {
			vo.setPassword(password);
		}
		
		if(hasError) {
			request.setAttribute("errors", errorMsgs);
			request.getRequestDispatcher(JSP_TEMPLATE_FILENAME).forward(request, response);
		} else {
			UserDAO dao = new UserDAO();
			
			try {
				if(dao.isPasswordCorrect(vo.getEmail(), vo.getPassword())) {
					vo = dao.selectWithEmail(vo.getEmail());
					vo.setPassword("");
					
					HttpSession session = request.getSession();
					session.setAttribute("user", vo);
					session.setMaxInactiveInterval(2*60*60); // 세션은 2시간 유지
					
					request.getRequestDispatcher(JSP_TEMPLATE_FILENAME).forward(request, response);
				} else {
					errorMsgs.add("이메일 또는 비밀번호를 확인해주세요.");
					request.setAttribute("errors", errorMsgs);
					request.getRequestDispatcher(JSP_TEMPLATE_FILENAME).forward(request, response);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
