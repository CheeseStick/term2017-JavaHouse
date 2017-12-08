package com.javahouse.user.dao;

import com.javahouse.dao.AbstractDAO;
import com.javahouse.dao.GenericDAO;
import com.javahouse.user.vo.UserVO;

public class UserDAO implements GenericDAO<UserVO, Integer> {

	@Override
	public void insert(final UserVO vo) throws Exception {
		final String SQL_QUERY = "INSERT INTO User"
				+ "(first_name, last_name, birthday, phone_no, address, address_detail, password, email, ssn, profile_photo_file_id)"
				+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		new AbstractDAO() {
			@Override
			public void query() throws Exception {
				stmt = conn.prepareStatement(SQL_QUERY);
				
				stmt.setString(1, vo.getFirstName());
				stmt.setString(2, vo.getLastName());
				stmt.setDate(3, new java.sql.Date(vo.getBirthday().getTime()));
				stmt.setString(4, vo.getPhoneNo());
				stmt.setString(5, vo.getAddress());
				stmt.setString(6, vo.getAddressDetail());
				stmt.setString(7, vo.getPassword());
				stmt.setString(8, vo.getEmail());
				stmt.setString(9, vo.getSsn());
				stmt.setInt(10, vo.getProfilePhotoFileID());
				
				stmt.executeQuery();
			}
		}.execute();
	}

	@Override
	public void update(final UserVO vo) throws Exception {
		final String SQL_QUERY = "UPDATE User SET"
				+ "first_name = ?, last_name = ?, birthday = ?, phone_no = ?, address = ?, address_detail = ?, password = ?,"
				+ "ssn = ?, profile_photo_file_id = ?"
				+ "WHERE user_id = ?";
		
		new AbstractDAO() {
			@Override
			public void query() throws Exception {
				stmt = conn.prepareStatement(SQL_QUERY);
				
				stmt.setString(1, vo.getFirstName());
				stmt.setString(2, vo.getLastName());
				stmt.setDate(3, new java.sql.Date(vo.getBirthday().getTime()));
				stmt.setString(4, vo.getPhoneNo());
				stmt.setString(5, vo.getAddress());
				stmt.setString(6, vo.getAddressDetail());
				stmt.setString(7, vo.getPassword());
				stmt.setString(8, vo.getSsn());
				stmt.setInt(9, vo.getProfilePhotoFileID());
				stmt.setInt(10, vo.getUserID());
				
				stmt.executeQuery();
			}
		}.execute();
	}

	@Override
	public void delete(final Integer key) throws Exception {
		final String SQL_QUERY = "DELETE FROM User"
				+ "WHERE user_id = ?";
		
		new AbstractDAO() {
			@Override
			public void query() throws Exception {
				stmt = conn.prepareStatement(SQL_QUERY);
				stmt.setInt(1, key);	
				stmt.executeQuery();
			}
		}.execute();
	}

	@Override
	public UserVO select(final Integer key) throws Exception {
		final String SQL_QUERY = "SELECT FROM User"
				+ "WHERE user_id = ?";
		
		final UserVO user = new UserVO();
		
		new AbstractDAO() {
			@Override
			public void query() throws Exception {
				stmt = conn.prepareStatement(SQL_QUERY);
				stmt.setInt(1, key);	
				rs = stmt.executeQuery();
				
				while(rs.next()) {
					user.setUserID(rs.getInt(1));
					user.setFirstName(rs.getString(2));
					user.setLastName(rs.getString(3));
					user.setBirthday(new java.util.Date(rs.getDate(4).getTime()));
					user.setPhoneNo(rs.getString(5));
					user.setAddress(rs.getString(6));
					user.setAddressDetail(rs.getString(7));
					user.setPassword(rs.getString(8));
					user.setEmail(rs.getString(9));
					user.setSsn(rs.getString(10));
					user.setProfilePhotoFileID(rs.getInt(11));
				}
			}
		}.execute();
		
		return user;
	}
	
}
