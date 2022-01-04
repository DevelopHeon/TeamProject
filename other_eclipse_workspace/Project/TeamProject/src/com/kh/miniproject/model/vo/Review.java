package com.kh.miniproject.model.vo;

import java.io.Serializable;

public class Review implements Comparable<Review>, Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3792294248808941040L; //직렬화
	//review에서 사용하는 변수는 제목이랑, 리뷰(본문) 두 개 
	//private String userId;
	private String userId;
	private String title;
	private String content;
	private int rNo;
		
	public Review() {}

	public Review(String userId, String title, String content) {
		super();
		this.userId = userId;
		this.title = title;
		this.content = content;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getReview() {
		return content;
	}

	public void setReview(String content) {
		this.content = content;
	}
	
	public int getRNo() {
		return rNo;
	}
	
	public void setRNo(int rNo) {
		this.rNo = rNo;
	}
	

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return rNo + ". 제목 : " + title + "\t" + " 리뷰 내용 : " + content;
	}

	@Override
	public int compareTo(Review r) {
		
		return this.rNo - r.rNo;
	}
	
}
