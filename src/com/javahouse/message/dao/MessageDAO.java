package com.javahouse.message.dao;

import com.javahouse.dao.AbstractDAO;
import com.javahouse.dao.GenericDAO;
import com.javahouse.message.vo.MessageVO;

public class MessageDAO implements GenericDAO<MessageVO, Integer> {

	@Override
	public void insert(MessageVO vo) throws Exception {
		final String SQL_QUERY = "INSERT INTO Message"
				+ "(msg_content, sent_date, receiver_id, sender_id)"
				+ "VALUES(?, ?, ?, ?)";
		
		new AbstractDAO() {
			@Override
			public void query() throws Exception {
				stmt = conn.prepareStatement(SQL_QUERY);
				
				stmt.setString(1, vo.getMessageContent());
				stmt.setDate(2, new java.sql.Date(vo.getSentDate().getTime()));
				stmt.setInt(3, vo.getReceiverID());
				stmt.setInt(4, vo.getSenderID());
				
				stmt.executeQuery();
			}
		}.execute();
	}

	@Override
	public void update(MessageVO vo) throws Exception {
		final String SQL_QUERY = "UPDATE User SET "
				+ "msg_content = ?, sent_date = ?, receiver_id = ? sender_id = ? "
				+ "WHERE message_id = ?";
		
		new AbstractDAO() {
			@Override
			public void query() throws Exception {
				stmt = conn.prepareStatement(SQL_QUERY);
				
				stmt.setString(1, vo.getMessageContent());
				stmt.setDate(2, new java.sql.Date(vo.getSentDate().getTime()));
				stmt.setInt(3, vo.getReceiverID());
				stmt.setInt(4, vo.getSenderID());
				
				stmt.setInt(4, vo.getMessageID());
				
				stmt.executeQuery();
			}
		}.execute();	
	}

	@Override
	public void delete(Integer key) throws Exception {
		final String SQL_QUERY = "DELETE FROM Message "
				+ "WHERE message_id = ?";
		
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
	public MessageVO select(Integer key) throws Exception {
		final String SQL_QUERY = "SELECT * FROM Message "
				+ "WHERE message_id = ?";
		
		final MessageVO msg = new MessageVO();
		
		new AbstractDAO() {
			@Override
			public void query() throws Exception {
				stmt = conn.prepareStatement(SQL_QUERY);
				stmt.setInt(1, key);	
				rs = stmt.executeQuery();
				
				while(rs.next()) {
					msg.setMessageID(rs.getInt(1));
					msg.setMessageContent(rs.getString(2));
					msg.setSentDate(new java.util.Date(rs.getDate(3).getTime()));
					msg.setReceiverID(rs.getInt(4));
					msg.setSenderID(rs.getInt(5));
				}
			}
		}.execute();
		
		return msg;
	}
}
