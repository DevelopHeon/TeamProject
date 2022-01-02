package com.kh.miniproject.model.vo;

public class Book {
	
	private int bNum;
	
	private String title;
	
	private String author;
	
	private String publisher;
	
	public Book() {	}

	public Book(String title, String author, String publisher) {
		super();
		
		this.title = title;
		this.author = author;
		this.publisher = publisher;
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

	@Override
	public String toString() {
		return "Book [bNum=" + bNum + ", title=" + title + ", author=" + author + ", publisher=" + publisher + "]";
	}
	

	
}
