package com.javahouse.user.dao;

import com.javahouse.dao.AbstractDAO;
import com.javahouse.dao.GenericDAO;
import com.javahouse.user.vo.UserVO;
import com.sun.org.apache.xml.internal.security.utils.Base64;

import java.nio.charset.Charset;
import java.security.MessageDigest;

public class UserDAO implements GenericDAO<UserVO, Integer> {
	
	private static final String PASSWORD_SALT = "w8olxbEFubhCi40I";
	
	@Override
	public void insert(final UserVO vo) throws Exception {
		final String SQL_QUERY = "INSERT INTO User "
				+ "(first_name, last_name, birthday, phone_no, address, address_detail, password, email, ssn, profile_photo_file_id, is_host) "
				+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
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
				stmt.setString(7, encryptPassword(vo.getPassword()));
				stmt.setString(8, vo.getEmail());
				stmt.setString(9, vo.getSsn());
				stmt.setInt(10, vo.getProfilePhotoFileID());
				stmt.setBoolean(11, vo.isHost());
				
				stmt.executeQuery();
			}
		}.execute();
	}

	@Override
	public void update(final UserVO vo) throws Exception {
		final String SQL_QUERY = "UPDATE User SET "
				+ "first_name = ?, last_name = ?, birthday = ?, phone_no = ?, address = ?, address_detail = ?, password = ?, "
				+ "ssn = ?, profile_photo_file_id = ?, is_host = ?"
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
				stmt.setBoolean(11, vo.isHost());
				
				stmt.executeQuery();
			}
		}.execute();
	}

	@Override
	public void delete(final Integer key) throws Exception {
		final String SQL_QUERY = "DELETE FROM User "
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
		final String SQL_QUERY = "SELECT * FROM User "
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
					user.setHost(rs.getBoolean(12));
					user.setAdmin(rs.getBoolean(13));
				}
			}
		}.execute();
		
		return user;
	}
	
	public UserVO selectWithEmail(final String email) throws Exception {
		final String SQL_QUERY = "SELECT * FROM User "
				+ "WHERE email = ?";
		
		final UserVO user = new UserVO();
		
		new AbstractDAO() {
			@Override
			public void query() throws Exception {
				stmt = conn.prepareStatement(SQL_QUERY);
				stmt.setString(1, email);	
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
					user.setHost(rs.getBoolean(12));
					user.setAdmin(rs.getBoolean(13));
				}
			}
		}.execute();
		
		return user;
	}
	
	public boolean isDuplicatedEmail(final String email) throws Exception {
		return selectWithEmail(email) != null;
	}
	
	public boolean isPasswordCorrect(final String email, final String password) throws Exception {
		final UserVO user = selectWithEmail(email);
		
		if(user != null) {
			return user.getPassword().equals(password); // user.getPassword() == encryptPassword(password);
		} else {
			return false;
		}
	}
	
	private String encryptPassword(final String password) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-512");
			byte[] bytes = password.concat(PASSWORD_SALT).getBytes(Charset.forName("UTF-8"));
			md.update(bytes);
			return Base64.encode(md.digest());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
