package com.javahouse.message.vo;

import java.util.Date;

public class MessageVO {
	private int messageID;
	private String messageContent;
	private Date sentDate;
	
	private int receiverID;
	private int senderID;
	
	public int getMessageID() {
		return messageID;
	}
	public String getMessageContent() {
		return messageContent;
	}
	public Date getSentDate() {
		return sentDate;
	}
	public int getReceiverID() {
		return receiverID;
	}
	public int getSenderID() {
		return senderID;
	}
	public void setMessageID(int messageID) {
		this.messageID = messageID;
	}
	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}
	public void setSentDate(Date sentDate) {
		this.sentDate = sentDate;
	}
	public void setReceiverID(int receiverID) {
		this.receiverID = receiverID;
	}
	public void setSenderID(int senderID) {
		this.senderID = senderID;
	}
}
