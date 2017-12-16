package com.javahouse.item.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javahouse.item.dao.ContractTypeDAO;
import com.javahouse.item.dao.HousingTypeDAO;
import com.javahouse.item.dao.ItemDAO;
import com.javahouse.item.dao.PaymentTypeDAO;
import com.javahouse.item.dao.ResidenceTypeDAO;
import com.javahouse.item.vo.ContractTypeVO;
import com.javahouse.item.vo.HousingTypeVO;
import com.javahouse.item.vo.ItemVO;
import com.javahouse.item.vo.PaymentTypeVO;
import com.javahouse.item.vo.ResidenceTypeVO;

/**
 * Servlet implementation class ItemDetailServlet
 */
@WebServlet("/ItemDetailServlet")
public class ItemDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String JSP_TEMPLATE_FILENAME = "item_detail.jsp";

    public ItemDetailServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ItemDAO dao = new ItemDAO();
		try {
			ItemVO vo = dao.select(Integer.parseInt((String)request.getParameter("id")));
			if(vo.getItemTitle() == null) {
				response.sendRedirect(request.getContextPath());
			} else {
				ContractTypeVO[] contractTypes = new ContractTypeDAO().getAllRows();
				HousingTypeVO[] housingTypes = new HousingTypeDAO().getAllRows();
				PaymentTypeVO[] paymentTypes = new PaymentTypeDAO().getAllRows();
				ResidenceTypeVO[] residenceTypes = new ResidenceTypeDAO().getAllRows();
				
				request.setAttribute("contractTypes", contractTypes);
				request.setAttribute("housingTypes", housingTypes);
				request.setAttribute("paymentTypes", paymentTypes);
				request.setAttribute("residenceTypes", residenceTypes);	
				
				request.setAttribute("item", vo);
				request.getRequestDispatcher(JSP_TEMPLATE_FILENAME).forward(request, response);				
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
