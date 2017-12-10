package com.javahouse.user.servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javahouse.user.dao.UserDAO;
import com.javahouse.user.vo.UserVO;

/**
 * Servlet implementation class JoinServlet
 */
@WebServlet("/JoinServlet")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String JSP_TEMPLATE_FILENAME = "signup.jsp";
	
    public JoinServlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher(JSP_TEMPLATE_FILENAME).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String birthday = request.getParameter("birthday");
		String phoneNo = request.getParameter("phone_no");
		String address = request.getParameter("address");
		String addressDetail = request.getParameter("address_detail");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String ssn = request.getParameter("ssn");
		// String profilePhoto = request.getParameter("photo");
		String isHost = request.getParameter("is_host");
		
		boolean hasError = false;
		ArrayList<String> errorMsgs = new ArrayList<String>();
		UserVO vo = new UserVO();
		
		vo.setHost(Boolean.getBoolean(isHost));
		
		if(firstname == null || lastname == null) {
			hasError = true;
			errorMsgs.add("이름을 입력해주세요.");
		} else {
			vo.setFirstName(firstname);
			vo.setLastName(lastname);
		}
		
		if(birthday == null) {
			hasError = true;
			errorMsgs.add("생일을 입력해주세요.");
		} else {
			DateFormat dateformat = new SimpleDateFormat("yyyy-mm-dd");
			try {
				vo.setBirthday(dateformat.parse(birthday));
			} catch (ParseException e) {
				hasError = true;
				errorMsgs.add("생일을 올바르게 입력해주세요.");
			}
		}
		
		if(phoneNo == null) {
			hasError = true;
			errorMsgs.add("전화번호를 입력해주세요.");
		} else {
			vo.setPhoneNo(phoneNo);
		}
		
		if(address == null || addressDetail == null) {
			hasError = true;
			errorMsgs.add("주소를 입력해주세요.");
		} else {
			vo.setAddress(address);
			vo.setAddressDetail(addressDetail);
		}
		
		if(password == null || password.length() < 8) {
			hasError = true;
			errorMsgs.add("비밀번호를 입력해주세요. (최소 8자 이상)");
		} else {
			vo.setPassword(password);
		}
		
		if(email == null || !email.contains("@")) {
			hasError = true;
			errorMsgs.add("이메일을 입력해주세요.");
		} else {
			vo.setEmail(email);
		}
		
		if(ssn == null) {
			hasError = true;
			errorMsgs.add("주민번호를 입력해주세요.");
		} else {
			vo.setSsn(ssn);
		}
		
		//TODO: 파일 업로드 구현
		// vo.setProfilePhotoFileID(0);
		
		if(hasError) {
			vo.setPassword("");
			
			request.setAttribute("errors", errorMsgs);
			request.setAttribute("vo", vo);
			
			request.getRequestDispatcher(JSP_TEMPLATE_FILENAME).forward(request, response);
		} else {
			UserDAO dao = new UserDAO();
			
			try {
				if(!dao.isDuplicatedEmail(email)) {
					dao.insert(vo);
					response.sendRedirect(request.getContextPath());
				} else {
					errorMsgs.add("중복된 이메일 입니다.");
					
					vo.setPassword("");
					
					request.setAttribute("errors", errorMsgs);
					request.setAttribute("vo", vo);
					
					request.getRequestDispatcher(JSP_TEMPLATE_FILENAME).forward(request, response);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
