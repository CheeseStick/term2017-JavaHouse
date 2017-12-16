package com.javahouse.item.dao;

import java.util.ArrayList;

import com.javahouse.dao.AbstractDAO;
import com.javahouse.dao.GenericDAO;
import com.javahouse.item.vo.ResidenceTypeVO;

public class ResidenceTypeDAO implements GenericDAO<ResidenceTypeVO, Integer> {

	@Override
	public void insert(final ResidenceTypeVO vo) throws Exception {
		throw new Exception();
	}

	@Override
	public void update(final ResidenceTypeVO vo) throws Exception {
		throw new Exception();
		
	}

	@Override
	public void delete(final Integer key) throws Exception {
		throw new Exception();
	}

	@Override
	public ResidenceTypeVO select(final Integer key) throws Exception {
		final String SQL_QUERY = "SELECT * FROM ResidenceType "
				+ "WHERE item_id = ?";
		
		ResidenceTypeVO vo = new ResidenceTypeVO();
		
		new AbstractDAO() {
			@Override
			public void query() throws Exception {
				stmt = conn.prepareStatement(SQL_QUERY);
				stmt.setInt(1, key);	
				rs = stmt.executeQuery();
				
				while(rs.next()) {
					vo.setResidenceTypeID(rs.getInt(1));
					vo.setName(rs.getString(2));
				}	
			}
		}.execute();
		
		return vo;
	}
	
	public ResidenceTypeVO[] getAllRows() throws Exception {
		final String SQL_QUERY = "SELECT * FROM ResidenceType";
		
		ArrayList<ResidenceTypeVO> voArr = new ArrayList<ResidenceTypeVO>();
		
		new AbstractDAO() {
			@Override
			public void query() throws Exception {
				stmt = conn.prepareStatement(SQL_QUERY);	
				rs = stmt.executeQuery();
				
				while(rs.next()) {
					ResidenceTypeVO vo = new ResidenceTypeVO();
					
					vo.setResidenceTypeID(rs.getInt(1));
					vo.setName(rs.getString(2));
					
					voArr.add(vo);
				}
			}
		}.execute();
		
		return voArr.toArray(new ResidenceTypeVO[voArr.size()]);
	}
}
