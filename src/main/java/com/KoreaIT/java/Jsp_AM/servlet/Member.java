package com.KoreaIT.java.Jsp_AM.servlet;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public class Member {
	private int id;
	private LocalDateTime regDate;
	private String loginId;
	private String loginPw;
	private String name;
	
	
	
	public Member(String loginId, String loginPw, String name) {
		super();
		this.loginId = loginId;
		this.loginPw = loginPw;
		this.name = name;
	}



	public Member() {
		super();
	}



	public Member(int id, LocalDateTime regDate, String loginId, String loginPw, String name) {
		super();
		this.id = id;
		this.regDate = regDate;
		this.loginId = loginId;
		this.loginPw = loginPw;
		this.name = name;
	}
	
	public Member(Map<String, Object> articleRow) {
		super();
		this.id = (int)articleRow.get("id");
		this.regDate = (LocalDateTime)articleRow.get("regDate");
		this.loginId =(String)articleRow.get("loginId");
		this.loginPw = (String)articleRow.get("loginPw");
		this.name = (String)articleRow.get("name");;
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



	public String getLoginPw() {
		return loginPw;
	}



	public void setLoginPw(String loginPw) {
		this.loginPw = loginPw;
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
