package com.app.model;

import java.sql.Timestamp;

public class User {
	private int  userid; 
	private String username;
	private String password; 
	private String email;
	private String address;
	private String role;
	private Timestamp createdate;
	private Timestamp lastlogindate;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String username, String password, String email, String address, String role) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.address = address;
		this.role = role;
	}

	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Timestamp getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Timestamp createdate) {
		this.createdate = createdate;
	}

	public Timestamp getLastlogindate() {
		return lastlogindate;
	}

	public void setLastlogindate(Timestamp lastlogindate) {
		this.lastlogindate = lastlogindate;
	}

	@Override
	public String toString() {
		return "User [userid=" + userid + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", address=" + address + ", role=" + role + ", createdate=" + createdate + ", lastlogindate="
				+ lastlogindate + "]";
	}
	
	
}
