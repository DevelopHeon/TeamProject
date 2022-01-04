package com.kh.miniproject.model.vo;

import java.io.Serializable;
import java.util.Objects;

public class Delivery implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 136752716477130319L;
	private String name;
	private String address;
	private Book book;
	
	public Delivery() {
	}

	public Delivery(String name, String address, Book book) {
		super();
		this.name = name;
		this.address = address;
		this.book = book;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	@Override
	public String toString() {
		return "[배달 정보] 수취인 : " + name + ", 주소 : " + address + ", 주문한 책 [" + book+"]";
	}

	@Override
	public int hashCode() {
		
		return Objects.hash(name, address);
	}

	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Delivery)) {
			return false;
		}
		Delivery other = (Delivery)obj;
		if(this.name.equals(other.name)&&this.address.equals(other.address)/*&&this.book.equals(other.book)*/) {
			return true;
		}else {
			return false;
		}
	}
	

}
