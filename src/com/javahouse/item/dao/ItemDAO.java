package com.javahouse.item.dao;

import java.util.ArrayList;

import com.javahouse.dao.AbstractDAO;
import com.javahouse.dao.GenericDAO;
import com.javahouse.item.vo.ItemVO;
import com.mysql.jdbc.Statement;

public class ItemDAO implements GenericDAO<ItemVO, Integer> {

	@Override
	public void insert(final ItemVO vo) throws Exception {
		final String SQL_QUERY = "INSERT INTO Item "
				+ "(host_id, is_available, item_title, item_desc, housing_type_id, contract_type_id, payment_type_id, "
				+ "residence_type_id, deposit, price, contract_start_date, contract_end_date, address, address_detail, pos_lat, pos_lon) "
				+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		new AbstractDAO() {
			@Override
			public void query() throws Exception {
				stmt = conn.prepareStatement(SQL_QUERY, Statement.RETURN_GENERATED_KEYS);
				
				stmt.setInt(1, vo.getHostID());
				
				stmt.setBoolean(2, vo.isAvailable());
				stmt.setString(3, vo.getItemTitle());
				stmt.setString(4, vo.getItemDesc());
				
				stmt.setInt(5, vo.getHousingTypeID());
				stmt.setInt(6, vo.getContractTypeID());
				stmt.setInt(7, vo.getPaymentTypeID());
				stmt.setInt(8, vo.getResidenceTypeID());
				
				stmt.setInt(9, vo.getDeposit());
				stmt.setInt(10, vo.getPrice());
				
				stmt.setDate(11, new java.sql.Date(vo.getContractStartDate().getTime()));
				stmt.setDate(12, new java.sql.Date(vo.getContractEndDate().getTime()));
				
				stmt.setString(13, vo.getAddress());
				stmt.setString(14, vo.getAddressDetail());
				
				stmt.setDouble(15, 0.0);
				stmt.setDouble(16, 0.0);
				
				stmt.executeUpdate();
				rs = stmt.getGeneratedKeys();
				
				while(rs.next()) {
					vo.setItemID(rs.getInt(1));
				}
			}
		}.execute();
	}

	@Override
	public void update(final ItemVO vo) throws Exception {
		final String SQL_QUERY = "UPDATE Item SET "
				+ "is_available = ?, item_title = ?, item_desc = ?, housing_type_id = ?, contract_type_id = ?, payment_type_id = ?, "
				+ "residence_type_id = ?, deposit = ?, price = ?, contract_start_date = ?, contract_end_date = ?, "
				+ "address = ?, address_detail = ?, pos_lat = ?, pos_lon = ? "
				+ "WHERE item_id = ? AND host_id = ?";
		
		new AbstractDAO() {
			@Override
			public void query() throws Exception {
				stmt = conn.prepareStatement(SQL_QUERY);
				
				stmt.setBoolean(1, vo.isAvailable());
				stmt.setString(2, vo.getItemTitle());
				stmt.setString(3, vo.getItemDesc());
				
				stmt.setInt(4, vo.getHousingTypeID());
				stmt.setInt(5, vo.getContractTypeID());
				stmt.setInt(6, vo.getPaymentTypeID());
				stmt.setInt(7, vo.getResidenceTypeID());
				
				stmt.setInt(8, vo.getDeposit());
				stmt.setInt(9, vo.getPrice());
				
				stmt.setDate(10,new java.sql.Date(vo.getContractStartDate().getTime()));
				stmt.setDate(11,new java.sql.Date(vo.getContractEndDate().getTime()));
				
				stmt.setString(12, vo.getAddress());
				stmt.setString(13, vo.getAddressDetail());
				
				stmt.setDouble(14, 0.0);
				stmt.setDouble(15, 0.0);
				
				stmt.setInt(16, vo.getItemID());
				stmt.setInt(17, vo.getHostID());
				
				stmt.executeUpdate();
			}
		}.execute();
	}

	@Override
	public void delete(final Integer key) throws Exception {
		final String SQL_QUERY = "DELETE FROM Item "
				+ "WHERE item_id = ?";
		
		new AbstractDAO() {
			@Override
			public void query() throws Exception {
				stmt = conn.prepareStatement(SQL_QUERY);
				stmt.setInt(1, key);	
				stmt.executeUpdate();
			}
		}.execute();
	}

	@Override
	public ItemVO select(final Integer key) throws Exception {
		final String SQL_QUERY = "SELECT * FROM Item "
				+ "WHERE item_id = ?";
		
		ItemVO vo = new ItemVO();
		
		new AbstractDAO() {
			@Override
			public void query() throws Exception {
				stmt = conn.prepareStatement(SQL_QUERY);
				stmt.setInt(1, key);	
				rs = stmt.executeQuery();
				
				while(rs.next()) {
					vo.setItemID(rs.getInt(1));
					vo.setHostID(rs.getInt(2));
					
					vo.setAvailable(rs.getBoolean(3));
					vo.setItemTitle(rs.getString(4));
					vo.setItemDesc(rs.getString(5));
					
					vo.setHousingTypeID(rs.getInt(6));
					vo.setResidenceTypeID(rs.getInt(7));
					vo.setContractTypeID(rs.getInt(8));
					vo.setPaymentTypeID(rs.getInt(9));
					
					vo.setDeposit(rs.getInt(10));
					vo.setPrice(rs.getInt(11));
					
					vo.setContractStartDate(new java.util.Date(rs.getDate(12).getTime()));
					vo.setContractEndDate(new java.util.Date(rs.getDate(13).getTime()));
					
					vo.setAddress(rs.getString(14));
					vo.setAddressDetail(rs.getString(15));
					
					vo.setPosLat(rs.getDouble(16));
					vo.setPosLon(rs.getLong(17));
				}	
			}
		}.execute();
		
		return vo;
	}
	
	public ItemVO[] getAllRows() throws Exception {
		final String SQL_QUERY = "SELECT * FROM Item";
		ArrayList<ItemVO> voArr = new ArrayList<ItemVO>();
		
		new AbstractDAO() {
			@Override
			public void query() throws Exception {
				stmt = conn.prepareStatement(SQL_QUERY);	
				rs = stmt.executeQuery();
				
				while(rs.next()) {
					ItemVO vo = new ItemVO();
					
					vo.setItemID(rs.getInt(1));
					vo.setHostID(rs.getInt(2));
					
					vo.setAvailable(rs.getBoolean(3));
					vo.setItemTitle(rs.getString(4));
					vo.setItemDesc(rs.getString(5));
					
					vo.setHousingTypeID(rs.getInt(6));
					vo.setResidenceTypeID(rs.getInt(7));
					vo.setContractTypeID(rs.getInt(8));
					vo.setPaymentTypeID(rs.getInt(9));
					
					vo.setDeposit(rs.getInt(10));
					vo.setPrice(rs.getInt(11));
					
					vo.setContractStartDate(new java.util.Date(rs.getDate(12).getTime()));
					vo.setContractEndDate(new java.util.Date(rs.getDate(13).getTime()));
					
					vo.setAddress(rs.getString(14));
					vo.setAddressDetail(rs.getString(15));
					
					vo.setPosLat(rs.getDouble(16));
					vo.setPosLon(rs.getLong(17));
					
					voArr.add(vo);
				}
			}
		}.execute();
		
		return voArr.toArray(new ItemVO[voArr.size()]);
	}

}
