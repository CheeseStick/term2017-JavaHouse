package com.javahouse.item.dao;

import java.util.ArrayList;

import com.javahouse.dao.AbstractDAO;
import com.javahouse.dao.GenericDAO;
import com.javahouse.item.vo.HousingTypeVO;

public class HousingTypeDAO implements GenericDAO<HousingTypeVO, Integer> {

	@Override
	public void insert(final HousingTypeVO vo) throws Exception {
		throw new Exception();
	}

	@Override
	public void update(final HousingTypeVO vo) throws Exception {
		throw new Exception();
		
	}

	@Override
	public void delete(final Integer key) throws Exception {
		throw new Exception();
	}

	@Override
	public HousingTypeVO select(final Integer key) throws Exception {
		final String SQL_QUERY = "SELECT * FROM HousingType "
				+ "WHERE item_id = ?";
		
		HousingTypeVO vo = new HousingTypeVO();
		
		new AbstractDAO() {
			@Override
			public void query() throws Exception {
				stmt = conn.prepareStatement(SQL_QUERY);
				stmt.setInt(1, key);	
				rs = stmt.executeQuery();
				
				while(rs.next()) {
					vo.setHousingTypeID(rs.getInt(1));
					vo.setName(rs.getString(2));
				}	
			}
		}.execute();
		
		return vo;
	}
	
	public HousingTypeVO[] getAllRows() throws Exception {
		final String SQL_QUERY = "SELECT * FROM HousingType";
		
		ArrayList<HousingTypeVO> voArr = new ArrayList<HousingTypeVO>();
		
		new AbstractDAO() {
			@Override
			public void query() throws Exception {
				stmt = conn.prepareStatement(SQL_QUERY);	
				rs = stmt.executeQuery();
				
				while(rs.next()) {
					HousingTypeVO vo = new HousingTypeVO();
					
					vo.setHousingTypeID(rs.getInt(1));
					vo.setName(rs.getString(2));
					
					voArr.add(vo);
				}
			}
		}.execute();
		
		return voArr.toArray(new HousingTypeVO[voArr.size()]);
	}
}
