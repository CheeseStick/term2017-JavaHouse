package com.javahouse.item.dao;

import java.util.ArrayList;

import com.javahouse.dao.AbstractDAO;
import com.javahouse.dao.GenericDAO;
import com.javahouse.item.vo.PaymentTypeVO;

public class PaymentTypeDAO implements GenericDAO<PaymentTypeVO, Integer> {

	@Override
	public void insert(final PaymentTypeVO vo) throws Exception {
		throw new Exception();
	}

	@Override
	public void update(final PaymentTypeVO vo) throws Exception {
		throw new Exception();
		
	}

	@Override
	public void delete(final Integer key) throws Exception {
		throw new Exception();
	}

	@Override
	public PaymentTypeVO select(final Integer key) throws Exception {
		final String SQL_QUERY = "SELECT * FROM PaymentType "
				+ "WHERE item_id = ?";
		
		PaymentTypeVO vo = new PaymentTypeVO();
		
		new AbstractDAO() {
			@Override
			public void query() throws Exception {
				stmt = conn.prepareStatement(SQL_QUERY);
				stmt.setInt(1, key);	
				rs = stmt.executeQuery();
				
				while(rs.next()) {
					vo.setPaymentTypeID(rs.getInt(1));
					vo.setName(rs.getString(2));
				}	
			}
		}.execute();
		
		return vo;
	}
	
	public PaymentTypeVO[] getAllRows() throws Exception {
		final String SQL_QUERY = "SELECT * FROM PaymentType";
		
		ArrayList<PaymentTypeVO> voArr = new ArrayList<PaymentTypeVO>();
		
		new AbstractDAO() {
			@Override
			public void query() throws Exception {
				stmt = conn.prepareStatement(SQL_QUERY);	
				rs = stmt.executeQuery();
				
				while(rs.next()) {
					PaymentTypeVO vo = new PaymentTypeVO();
					
					vo.setPaymentTypeID(rs.getInt(1));
					vo.setName(rs.getString(2));
					
					voArr.add(vo);
				}
			}
		}.execute();
		
		return voArr.toArray(new PaymentTypeVO[voArr.size()]);
	}
}