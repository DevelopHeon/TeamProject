package com.kh.miniproject.model.vo;

import java.io.Serializable;
import java.util.Objects;

public class Review implements Comparable<Review>, Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3792294248808941040L; //직렬화
	//review에서 사용하는 변수는 제목이랑, 리뷰(본문) 두 개 
	//private String userId;
	private String userId;
	private String title;
	private String review;
	private int rNo;
		
	public Review() {}

	public Review(String userId, String title, String review) {
		super();
		this.userId = userId;
		this.title = title;
		this.review = review;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
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
		return rNo + ". 제목 : " + title + "\t" + " 리뷰 내용 : " + review;
	}

	@Override
	public int compareTo(Review r) {
		
		return this.rNo - r.rNo;
	}
	
}
