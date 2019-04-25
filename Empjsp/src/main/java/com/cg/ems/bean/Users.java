package com.cg.ems.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Users {
@Id
	private int UserId;
	private String UserName;
	private String Password;
	private String Role;
	public int getUserId() {
		return UserId;
	}
	public void setUserId(int userId) {
		UserId = userId;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getRole() {
		return Role;
	}
	public void setRole(String role) {
		Role = role;
	}
	@Override
	public String toString() {
		return "users [UserId=" + UserId + ", UserName=" + UserName + ", Password=" + Password + ", Role=" + Role + "]";
	}
	public Users(int userId, String userName, String password, String role) {
		super();
		UserId = userId;
		UserName = userName;
		Password = password;
		Role = role;
	}
	
	public Users() {
		// TODO Auto-generated constructor stub
	}
}

