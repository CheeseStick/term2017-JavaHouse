package com.javahouse.item.servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javahouse.item.dao.ContractTypeDAO;
import com.javahouse.item.dao.HousingOptionDAO;
import com.javahouse.item.dao.HousingTypeDAO;
import com.javahouse.item.dao.ItemDAO;
import com.javahouse.item.dao.PaymentTypeDAO;
import com.javahouse.item.dao.ResidenceTypeDAO;
import com.javahouse.item.vo.ContractTypeVO;
import com.javahouse.item.vo.HousingOptionVO;
import com.javahouse.item.vo.HousingTypeVO;
import com.javahouse.item.vo.ItemVO;
import com.javahouse.item.vo.PaymentTypeVO;
import com.javahouse.item.vo.ResidenceTypeVO;

@WebServlet("/ItemAddServlet")
public class ItemAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String JSP_TEMPLATE_FILENAME = "new_item.jsp";
       
    public ItemAddServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			ContractTypeVO[] contractTypes = new ContractTypeDAO().getAllRows();
			HousingTypeVO[] housingTypes = new HousingTypeDAO().getAllRows();
			PaymentTypeVO[] paymentTypes = new PaymentTypeDAO().getAllRows();
			ResidenceTypeVO[] residenceTypes = new ResidenceTypeDAO().getAllRows();
			
			request.setAttribute("contractTypes", contractTypes);
			request.setAttribute("housingTypes", housingTypes);
			request.setAttribute("paymentTypes", paymentTypes);
			request.setAttribute("residenceTypes", residenceTypes);			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		request.getRequestDispatcher(JSP_TEMPLATE_FILENAME).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		ItemVO item = new ItemVO();
		HousingOptionVO option = new HousingOptionVO();
		
		HttpSession session = request.getSession();
		
		item.setHostID(Integer.parseInt((String)session.getAttribute("user_id")));
		
		item.setItemTitle(request.getParameter("name"));
		item.setItemDesc(request.getParameter("desc"));
		
		DateFormat dateformat = new SimpleDateFormat("yyyy-mm-dd");
		try {
			item.setContractStartDate(dateformat.parse(request.getParameter("contract_start_date")));
			item.setContractEndDate(dateformat.parse(request.getParameter("contract_end_date")));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		item.setAvailable(Boolean.parseBoolean(request.getParameter("is_available")));
		item.setAddress(request.getParameter("address"));
		item.setAddressDetail(request.getParameter("address_detail"));
		
		item.setHousingTypeID(Integer.parseInt(request.getParameter("housing_type")));
		item.setResidenceTypeID(Integer.parseInt(request.getParameter("residence_type")));
		item.setDeposit(Integer.parseInt(request.getParameter("deposit")));
		item.setPrice(Integer.parseInt(request.getParameter("price")));
		
		item.setContractTypeID(Integer.parseInt(request.getParameter("contract_type")));
		item.setPaymentTypeID(Integer.parseInt(request.getParameter("payment_type")));
		
		option.setHasTV(Boolean.parseBoolean(request.getParameter("has_tv")));
		option.setHasAC(Boolean.parseBoolean(request.getParameter("has_ac")));
		option.setHasWashingMachine(Boolean.parseBoolean(request.getParameter("has_washing_machine")));
		
		option.setHasBed(Boolean.parseBoolean(request.getParameter("has_bed")));
		option.setBedCnt(Integer.parseInt(request.getParameter("bed_cnt")));
		
		option.setHasKitchen(Boolean.parseBoolean(request.getParameter("has_kitchen")));
		option.setHasRefrigerator(Boolean.parseBoolean(request.getParameter("has_refrigerator")));
		option.setHasMicrowave(Boolean.parseBoolean(request.getParameter("has_microwave")));
		
		option.setHasBathroom(Boolean.parseBoolean(request.getParameter("has_bathroom")));
		option.setPublicBathroom(Boolean.parseBoolean(request.getParameter("is_public_bathroom")));

		ItemDAO itemDAO = new ItemDAO();
		HousingOptionDAO optionDAO = new HousingOptionDAO();
		
		try {
			itemDAO.insert(item);
			option.setItemID(item.getItemID());
			optionDAO.insert(option);
			
			response.sendRedirect(request.getContextPath() + "/item/detail?id=" + item.getItemID());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
