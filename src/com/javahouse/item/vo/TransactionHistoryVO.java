package com.javahouse.item.vo;

import java.util.Date;

public class TransactionHistoryVO {
	private int transactionHistoryID;
	
	private int hostUserID;
	private int guestUserID;
	
	private int itemID;
	
	private Date contractDate;
	
	private String transactionDesc;

	public int getTransactionHistoryID() {
		return transactionHistoryID;
	}

	public int getHostUserID() {
		return hostUserID;
	}

	public int getGuestUserID() {
		return guestUserID;
	}

	public int getItemID() {
		return itemID;
	}

	public Date getContractDate() {
		return contractDate;
	}

	public String getTransactionDesc() {
		return transactionDesc;
	}

	public void setTransactionHistoryID(int transactionHistoryID) {
		this.transactionHistoryID = transactionHistoryID;
	}

	public void setHostUserID(int hostUserID) {
		this.hostUserID = hostUserID;
	}

	public void setGuestUserID(int guestUserID) {
		this.guestUserID = guestUserID;
	}

	public void setItemID(int itemID) {
		this.itemID = itemID;
	}

	public void setContractDate(Date contractDate) {
		this.contractDate = contractDate;
	}

	public void setTransactionDesc(String transactionDesc) {
		this.transactionDesc = transactionDesc;
	}
}
