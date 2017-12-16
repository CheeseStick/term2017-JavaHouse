package com.javahouse.item.dao;

import java.util.ArrayList;

import com.javahouse.dao.AbstractDAO;
import com.javahouse.dao.GenericDAO;
import com.javahouse.item.vo.ContractTypeVO;

public class ContractTypeDAO implements GenericDAO<ContractTypeVO, Integer> {

	@Override
	public void insert(final ContractTypeVO vo) throws Exception {
		throw new Exception();
	}

	@Override
	public void update(final ContractTypeVO vo) throws Exception {
		throw new Exception();
		
	}

	@Override
	public void delete(final Integer key) throws Exception {
		throw new Exception();
	}

	@Override
	public ContractTypeVO select(final Integer key) throws Exception {
		final String SQL_QUERY = "SELECT * FROM ContractType "
				+ "WHERE item_id = ?";
		
		ContractTypeVO vo = new ContractTypeVO();
		
		new AbstractDAO() {
			@Override
			public void query() throws Exception {
				stmt = conn.prepareStatement(SQL_QUERY);
				stmt.setInt(1, key);	
				rs = stmt.executeQuery();
				
				while(rs.next()) {
					vo.setContractTypeID(rs.getInt(1));
					vo.setName(rs.getString(2));
				}	
			}
		}.execute();
		
		return vo;
	}
	
	public ContractTypeVO[] getAllRows() throws Exception {
		final String SQL_QUERY = "SELECT * FROM ContractType";
		
		ArrayList<ContractTypeVO> voArr = new ArrayList<ContractTypeVO>();
		
		new AbstractDAO() {
			@Override
			public void query() throws Exception {
				stmt = conn.prepareStatement(SQL_QUERY);	
				rs = stmt.executeQuery();
				
				while(rs.next()) {
					ContractTypeVO vo = new ContractTypeVO();
					
					vo.setContractTypeID(rs.getInt(1));
					vo.setName(rs.getString(2));
					
					voArr.add(vo);
				}
			}
		}.execute();
		
		return voArr.toArray(new ContractTypeVO[voArr.size()]);
	}
}
