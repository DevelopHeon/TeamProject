package com.kh.miniproject.model.vo;

public class Review {
	
	private String review;
	
	public Review() {}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	@Override
	public String toString() {
		return "Review [review=" + review + "]";
	}
	
	
}
