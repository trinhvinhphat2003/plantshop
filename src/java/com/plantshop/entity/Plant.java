package com.plantshop.entity;

public class Plant {
	private Integer PID;
	private String PName;
	private Integer price;
	private String imgPath;
	private String description;
	private Integer status;
	private Integer CateID;
	public Integer getPID() {
		return PID;
	}
	public void setPID(Integer pID) {
		PID = pID;
	}
	public String getPName() {
		return PName;
	}
	public void setPName(String pName) {
		PName = pName;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getCateID() {
		return CateID;
	}
	public void setCateID(Integer cateID) {
		CateID = cateID;
	}
	public Plant(Integer pID, String pName, Integer price, String imgPath, String description, Integer status,
			Integer cateID) {
		super();
		PID = pID;
		PName = pName;
		this.price = price;
		this.imgPath = imgPath;
		this.description = description;
		this.status = status;
		CateID = cateID;
	}
	
}
