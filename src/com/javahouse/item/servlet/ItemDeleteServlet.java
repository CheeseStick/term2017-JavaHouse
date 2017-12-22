package com.javahouse.item.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javahouse.item.dao.HousingOptionDAO;
import com.javahouse.item.dao.ItemDAO;
import com.javahouse.item.vo.ItemVO;
import com.javahouse.user.vo.UserVO;

@WebServlet("/ItemDeleteServlet")
public class ItemDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ItemDeleteServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		UserVO user = (UserVO) session.getAttribute("user");
		
		if(user == null) {
			response.sendRedirect(request.getContextPath() + "/user/login");
		} else {
			try {
				ItemVO vo =  new ItemDAO().select(Integer.parseInt((String)request.getParameter("id")));
				if(vo != null) {
					if(vo.getHostID() == user.getUserID()) {
						new HousingOptionDAO().delete(vo.getItemID());
						new ItemDAO().delete(vo.getItemID());
						response.sendRedirect(request.getContextPath() + "/item/all");
					} else {
						response.sendRedirect(request.getContextPath() + "/item/detail?id=" + vo.getItemID());
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
