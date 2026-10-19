package com.app.model;

public class Menu {
	private  int menuid;
	private int restaurantid;
	private String itemname;
	private String description;
	private double price;
	private int isavailable;
	private String imagepath;
	public Menu() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Menu(int restaurantid, String itemname, String description, double price, int isavailable,
			String imagepath) {
		super();
		this.restaurantid = restaurantid;
		this.itemname = itemname;
		this.description = description;
		this.price = price;
		this.isavailable = isavailable;
		this.imagepath = imagepath;
	}
	public int getMenuid() {
		return menuid;
	}
	public void setMenuid(int menuid) {
		this.menuid = menuid;
	}
	public int getRestaurantid() {
		return restaurantid;
	}
	public void setRestaurantid(int restaurantid) {
		this.restaurantid = restaurantid;
	}
	public String getItemname() {
		return itemname;
	}
	public void setItemname(String itemname) {
		this.itemname = itemname;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getIsavailable() {
		return isavailable;
	}
	public void setIsavailable(int isavailable) {
		this.isavailable = isavailable;
	}
	public String getImagepath() {
		return imagepath;
	}
	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}
	@Override
	public String toString() {
		return "Menu [menuid=" + menuid + ", restaurantid=" + restaurantid + ", itemname=" + itemname + ", description="
				+ description + ", price=" + price + ", isavailable=" + isavailable + ", imagepath=" + imagepath + "]";
	}
	

}
