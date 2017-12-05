package com.javahouse.item.vo;

public class HousingOptionVO {
	private int itemID;
	
	private boolean hasTV;
	private boolean hasRefrigerator;
	private boolean hasMicrowave;
	
	private boolean hasBed;
	private int bedCnt;

	private boolean hasBathroom;
	private boolean isPublicBathroom;
	
	private boolean hasAC;
	private boolean hasWashingMachine;
	private boolean hasKitchen;
	
	public int getItemID() {
		return itemID;
	}
	public boolean isHasTV() {
		return hasTV;
	}
	public boolean isHasRefrigerator() {
		return hasRefrigerator;
	}
	public boolean isHasMicrowave() {
		return hasMicrowave;
	}
	public boolean isHasBed() {
		return hasBed;
	}
	public int getBedCnt() {
		return bedCnt;
	}
	public boolean isHasBathroom() {
		return hasBathroom;
	}
	public boolean isPublicBathroom() {
		return isPublicBathroom;
	}
	public boolean isHasAC() {
		return hasAC;
	}
	public boolean isHasWashingMachine() {
		return hasWashingMachine;
	}
	public boolean isHasKitchen() {
		return hasKitchen;
	}
	public void setItemID(int itemID) {
		this.itemID = itemID;
	}
	public void setHasTV(boolean hasTV) {
		this.hasTV = hasTV;
	}
	public void setHasRefrigerator(boolean hasRefrigerator) {
		this.hasRefrigerator = hasRefrigerator;
	}
	public void setHasMicrowave(boolean hasMicrowave) {
		this.hasMicrowave = hasMicrowave;
	}
	public void setHasBed(boolean hasBed) {
		this.hasBed = hasBed;
	}
	public void setBedCnt(int bedCnt) {
		this.bedCnt = bedCnt;
	}
	public void setHasBathroom(boolean hasBathroom) {
		this.hasBathroom = hasBathroom;
	}
	public void setPublicBathroom(boolean isPublicBathroom) {
		this.isPublicBathroom = isPublicBathroom;
	}
	public void setHasAC(boolean hasAC) {
		this.hasAC = hasAC;
	}
	public void setHasWashingMachine(boolean hasWashingMachine) {
		this.hasWashingMachine = hasWashingMachine;
	}
	public void setHasKitchen(boolean hasKitchen) {
		this.hasKitchen = hasKitchen;
	}
	
}
