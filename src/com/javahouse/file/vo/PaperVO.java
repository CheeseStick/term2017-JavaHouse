package com.javahouse.file.vo;

public class PaperVO {
	private int paperID;
	
	private int userID;
	private int itemID;
	
	private String paperName;
	private String paperDesc;
	
	public int getPaperID() {
		return paperID;
	}
	public int getUserID() {
		return userID;
	}
	public int getItemID() {
		return itemID;
	}
	public String getPaperName() {
		return paperName;
	}
	public String getPaperDesc() {
		return paperDesc;
	}
	public void setPaperID(int paperID) {
		this.paperID = paperID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public void setItemID(int itemID) {
		this.itemID = itemID;
	}
	public void setPaperName(String paperName) {
		this.paperName = paperName;
	}
	public void setPaperDesc(String paperDesc) {
		this.paperDesc = paperDesc;
	}
}
