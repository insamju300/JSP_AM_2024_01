package com.KoreaIT.java.Jsp_AM.dto;

public class Page {
	private int page;
	private int totalCnt;
	private int  totalPage;
	private int itemsInAPage;
	private int limitFrom;
	
	
	public Page() {
		super();
	}


	public Page(int page, int totalCnt, int totalPage, int itemsInAPage, int limitFrom) {
		this.page = page;
		this.totalCnt = totalCnt;
		this.totalPage = totalPage;
		this.itemsInAPage = itemsInAPage;
		this.limitFrom = limitFrom;
	}

	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getTotalCnt() {
		return totalCnt;
	}
	public void setTotalCnt(int totalCnt) {
		this.totalCnt = totalCnt;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getItemsInAPage() {
		return itemsInAPage;
	}
	public void setItemsInAPage(int itemsInAPage) {
		this.itemsInAPage = itemsInAPage;
	}


	public int getLimitFrom() {
		return limitFrom;
	}


	public void setLimitFrom(int limitFrom) {
		this.limitFrom = limitFrom;
	}
	
	


}
