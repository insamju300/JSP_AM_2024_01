package com.KoreaIT.java.Jsp_AM.servlet;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Member {
	private int id;
	private LocalDateTime regDate;
	private String loginId;
	private String password;
	private String name;
	
	
	public Member(String loginId, String password, String name) {
		super();
		this.loginId = loginId;
		this.password = password;
		this.name = name;
	}
	public Member() {
		super();
	}
	public Member(int id, LocalDateTime regDate, String loginId, String password, String name) {
		super();
		this.id = id;
		this.regDate = regDate;
		this.loginId = loginId;
		this.password = password;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDateTime getRegDate() {
		return regDate;
	}
	public void setRegDate(LocalDateTime regDate) {
		this.regDate = regDate;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getStringRegDate() {
		return regDate.format(DateTimeFormatter.ofPattern("yy-MM-dd hh:mm:ss"));
	}
	
	
	
	

}
