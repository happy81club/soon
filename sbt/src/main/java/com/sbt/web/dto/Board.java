package com.sbt.web.dto;

public class Board {
	private int articleNumber;
	private String title;
	private String content;
	private String writer;
	private String registrationTime;
	private String modificationTime;
	private int groupNumber;
	private int groupOrder;
	private int groupHierarchy;
	
	private int rownum;
	private int replyNum;
	
	//페이징
	private int startPage;   // 시작 페이지 번호
	private int perPageNum;  // 페이지 당 게시물 갯수
   
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getPerPageNum() {
		return perPageNum;
	}
	public void setPerPageNum(int perPageNum) {
		this.perPageNum = perPageNum;
	}
	
	
	public int getArticleNumber() {
		return articleNumber;
	}
	public void setArticleNumber(int articleNumber) {
		this.articleNumber = articleNumber;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getRegistrationTime() {
		return registrationTime;
	}
	public void setRegistrationTime(String registrationTime) {
		this.registrationTime = registrationTime;
	}
	public String getModificationTime() {
		return modificationTime;
	}
	public void setModificationTime(String modificationTime) {
		this.modificationTime = modificationTime;
	}
	public int getGroupNumber() {
		return groupNumber;
	}
	public void setGroupNumber(int groupNumber) {
		this.groupNumber = groupNumber;
	}
	public int getGroupOrder() {
		return groupOrder;
	}
	public void setGroupOrder(int groupOrder) {
		this.groupOrder = groupOrder;
	}
	public int getGroupHierarchy() {
		return groupHierarchy;
	}
	public void setGroupHierarchy(int groupHierarchy) {
		this.groupHierarchy = groupHierarchy;
	}
	public int getRownum() {
		return rownum;
	}
	public int getReplyNum() {
		return replyNum;
	}
	

}
