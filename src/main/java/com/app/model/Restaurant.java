package com.app.model;

public class Restaurant {
	
	private int  restaurantid;
	private String name;
	private String cuisinetype;
	private int deliverytime;
	private String address;
	private double rating;
	private int isactive;
	private String imagepath;
	
	

	public Restaurant() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Restaurant(String name, String cuisinetype, int  deliverytime, String address, double rating, int isactive,
			String imagepath) {
		super();
		this.name = name;
		this.cuisinetype = cuisinetype;
		this.deliverytime = deliverytime;
		this.address = address;
		this.rating = rating;
		this.isactive = isactive;
		this.imagepath = imagepath;
	}

	public int  getRestaurantid() {
		return restaurantid;
	}

	public void setRestaurantid(int restaurantid) {
		this.restaurantid = restaurantid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCuisinetype() {
		return cuisinetype;
	}

	public void setCuisinetype(String cuisinetype) {
		this.cuisinetype = cuisinetype;
	}

	public int getDeliverytime() {
		return deliverytime;
	}

	public void setDeliverytime(int deliverytime) {
		this.deliverytime = deliverytime;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public int getIsactive() {
		return isactive;
	}

	public void setIsactive(int isactive) {
		this.isactive = isactive;
	}

	public String getImagepath() {
		return imagepath;
	}

	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}

	@Override
	public String toString() {
		return "Restaurant [restaurantid=" + restaurantid + ", name=" + name + ", cuisinetype=" + cuisinetype
				+ ", deliverytime=" + deliverytime + ", address=" + address + ", rating=" + rating + ", isactive="
				+ isactive + ", imagepath=" + imagepath + "]";
	}
	

}
