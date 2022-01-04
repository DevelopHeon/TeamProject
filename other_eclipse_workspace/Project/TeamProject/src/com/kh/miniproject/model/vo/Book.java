package com.kh.miniproject.model.vo;

import java.io.Serializable;

public class Book implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4197926003136284548L;


	private int bNum; // 도서 번호 추가함

	
	private String title;
	
	private String author;
	
	private String publisher;
	
	private boolean rent; // 대여 상태 추가함
	
	public Book() {	}

	public Book(int bNum,String title, String author, String publisher, boolean rent) {
		super();
		this.bNum = bNum;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.rent = rent;
	}

	public int getbNum() {
		return bNum;
	}

	public void setbNum(int bNum) {
		this.bNum = bNum;
	}



	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	
	public boolean isRent() {
		return rent;
	}

	public void setRent(boolean rent) {
		this.rent = rent;
	}


	@Override
	public String toString() {

		

		
		String rentA ="";
		if(rent) {
			rentA ="가능";
		}else {
			rentA ="불가능";
		}
		return bNum + ". 제목 : " + title + ", 작가 : " + author + ", 출판사 : " + publisher + " (대출 "
				+ rentA + ")";

	}
}
	


