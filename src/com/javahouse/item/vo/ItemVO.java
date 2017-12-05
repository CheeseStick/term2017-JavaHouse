package com.javahouse.item.vo;

import java.util.Date;

public class ItemVO {
	private int itemID;
	private boolean isAvailable;
	
	private String itemTitle;
	private String itemDesc;
	
	private int housingTypeID;
	private int residenceTypeID;
	private int contractTypeID;
	private int paymentTypeID;
	
	private int deposit;
	private int price;
	
	private Date contractStartDate;
	private Date contractEndDate;
	
	private String address;
	private String addressDetail;
	
	private double posLat;
	private double posLon;
	
	public int getItemID() {
		return itemID;
	}
	public boolean isAvailable() {
		return isAvailable;
	}
	public String getItemTitle() {
		return itemTitle;
	}
	public String getItemDesc() {
		return itemDesc;
	}
	public int getHousingTypeID() {
		return housingTypeID;
	}
	public int getResidenceTypeID() {
		return residenceTypeID;
	}
	public int getContractTypeID() {
		return contractTypeID;
	}
	public int getPaymentTypeID() {
		return paymentTypeID;
	}
	public int getDeposit() {
		return deposit;
	}
	public int getPrice() {
		return price;
	}
	public Date getContractStartDate() {
		return contractStartDate;
	}
	public Date getContractEndDate() {
		return contractEndDate;
	}
	public String getAddress() {
		return address;
	}
	public String getAddressDetail() {
		return addressDetail;
	}
	public double getPosLat() {
		return posLat;
	}
	public double getPosLon() {
		return posLon;
	}
	public void setItemID(int itemID) {
		this.itemID = itemID;
	}
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	public void setItemTitle(String itemTitle) {
		this.itemTitle = itemTitle;
	}
	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}
	public void setHousingTypeID(int housingTypeID) {
		this.housingTypeID = housingTypeID;
	}
	public void setResidenceTypeID(int residenceTypeID) {
		this.residenceTypeID = residenceTypeID;
	}
	public void setContractTypeID(int contractTypeID) {
		this.contractTypeID = contractTypeID;
	}
	public void setPaymentTypeID(int paymentTypeID) {
		this.paymentTypeID = paymentTypeID;
	}
	public void setDeposit(int deposit) {
		this.deposit = deposit;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setContractStartDate(Date contractStartDate) {
		this.contractStartDate = contractStartDate;
	}
	public void setContractEndDate(Date contractEndDate) {
		this.contractEndDate = contractEndDate;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setAddressDetail(String addressDetail) {
		this.addressDetail = addressDetail;
	}
	public void setPosLat(double posLat) {
		this.posLat = posLat;
	}
	public void setPosLon(double posLon) {
		this.posLon = posLon;
	}
}
