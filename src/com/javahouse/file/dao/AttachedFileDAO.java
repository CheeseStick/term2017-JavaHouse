package com.javahouse.file.dao;

import com.javahouse.dao.AbstractDAO;
import com.javahouse.dao.GenericDAO;
import com.javahouse.file.vo.AttachedFileVO;

public class AttachedFileDAO implements GenericDAO<AttachedFileVO, Integer> {

	@Override
	public void insert(final AttachedFileVO vo) throws Exception {
		final String SQL_QUERY = "INSERT INTO AttachedFiles "
				+ "(filename, file_location, file_type) "
				+ "VALUES(?, ?, ?)";
		
		new AbstractDAO() {
			@Override
			public void query() throws Exception {
				stmt = conn.prepareStatement(SQL_QUERY);
				
				stmt.setString(1, vo.getFilename());
				stmt.setString(2, vo.getFileLocation());
				stmt.setString(3, vo.getFileType());
				
				stmt.executeUpdate();
			}
		}.execute();
	}

	@Override
	public void update(final AttachedFileVO vo) throws Exception {
		final String SQL_QUERY = "UPDATE AttachedFiles SET "
				+ "filename = ?, file_location = ?, file_type = ? "
				+ "WHERE file_id = ?";
		
		new AbstractDAO() {
			@Override
			public void query() throws Exception {
				stmt = conn.prepareStatement(SQL_QUERY);
				
				stmt.setString(1, vo.getFilename());
				stmt.setString(2, vo.getFileLocation());
				stmt.setString(3, vo.getFileType());
				stmt.setInt(4, vo.getFileID());
				
				stmt.executeUpdate();
			}
		}.execute();
	}

	@Override
	public void delete(final Integer key) throws Exception {
		final String SQL_QUERY = "DELETE FROM AttachedFiles "
				+ "WHERE file_id = ?";
		
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
	public AttachedFileVO select(final Integer key) throws Exception {
		final String SQL_QUERY = "SELECT * FROM AttachedFiles "
				+ "WHERE file_id = ?";
		
		final AttachedFileVO vo = new AttachedFileVO();
		
		new AbstractDAO() {
			@Override
			public void query() throws Exception {
				stmt = conn.prepareStatement(SQL_QUERY);
				stmt.setInt(1, key);
				rs = stmt.executeQuery();
				
				while(rs.next()) {
					vo.setFileID(rs.getInt(1));
					vo.setFilename(rs.getString(2));
					vo.setFileLocation(rs.getString(3));
					vo.setFileType(rs.getString(4));
				}
			}
		}.execute();
		
		return vo;
	}
}
