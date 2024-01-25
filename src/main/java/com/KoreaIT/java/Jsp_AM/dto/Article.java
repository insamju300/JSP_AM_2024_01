package com.KoreaIT.java.Jsp_AM.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public class Article {
    private int id;
    private LocalDateTime regDate;
    private int memberId;
    private String title;
    private String body; 
    private String writer;

	public Article() {
		super();
	}

	public Article(int memberId, String title, String body) {
		super();
		this.memberId = memberId;
		this.title = title;
		this.body = body;
	}

	public Article(int id, LocalDateTime regDate, int memberId, String title, String body, String writer) {
		super();
		this.id = id;
		this.regDate = regDate;
		this.memberId = memberId;
		this.title = title;
		this.body = body;
		this.writer = writer;
	}
	
	public Article(Map<String, Object> articleRow) {
		super();
		this.id = (int)articleRow.get("id");
		this.regDate = (LocalDateTime)articleRow.get("regDate");
		this.memberId =(int)articleRow.get("memberId");
		this.title = (String)articleRow.get("title");
		this.body = (String)articleRow.get("body");
		if(articleRow.get("writer")!=null && articleRow.get("writer").toString().length()>0) {
			writer = (String)articleRow.get("writer");
		}
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

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}
    
	public String getStringRegDate() {
		return regDate.format(DateTimeFormatter.ofPattern("yy-MM-dd hh:mm:ss"));
	}
	
    
    
    
}
