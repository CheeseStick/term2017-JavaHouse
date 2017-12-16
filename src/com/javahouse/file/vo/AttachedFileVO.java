package com.javahouse.file.vo;

public class AttachedFileVO {
	private int fileID;
	private String filename;
	private String fileLocation;
	private String fileType;
	
	public int getFileID() {
		return fileID;
	}
	public String getFilename() {
		return filename;
	}
	public String getFileLocation() {
		return fileLocation;
	}
	public String getFileType() {
		return fileType;
	}
	
	public void setFileID(int fileID) {
		this.fileID = fileID;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public void setFileLocation(String fileLocation) {
		this.fileLocation = fileLocation;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
}
