package com.egt.persistence.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "USERS", schema = BaseEntity.SCHEMA)
public class UserBean extends BaseEntity implements Serializable{
	@Column(name = "username")
	private String userName;
	@Column(name = "password")
	private String password;
	
	public UserBean() {
		this("","");
	}
	
	public UserBean(String userName , String password) {
		this.userName = userName;
		this.password = password;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
