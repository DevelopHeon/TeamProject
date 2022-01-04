package com.kh.miniproject.model.vo;

import java.io.Serializable;
import java.util.ArrayList;//전재은

// toString은 안 만들었어요
public class Member /*extends Admin*/ implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5461114678133906765L;

	private String id;
	
	private String pwd;
	
	private String name;
	// 필드부
	private int age;

	private char gender;

	private String address;

	private String phoneNum;
	
	//전재은
	private ArrayList<Book> rentList;

	private int overdue;

	public Member() {

	}

	public Member(String id, String pwd, String name, int age, char gender, String address, String phoneNum) {

//		super(id, pwd, name);
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.address = address;
		this.phoneNum = phoneNum;
		this.overdue = overdue;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	//전재은
	public ArrayList<Book> getRentList() {
		return rentList;
	}
	
	public void setRentList(ArrayList<Book> rentList) {
		this.rentList = rentList;
	}
	
	//전재은

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public int getOverdue() {
		return overdue;
	}

	public void setOverdue(int overdue) {
		this.overdue = overdue;
	}

	@Override
	public String toString() {
		return "회원 [id=" + id + ", pwd=" + pwd + ", 이름=" + name + ", 나이=" + age + ", 성별=" + gender
				+ ", 주소=" + address + ", 핸드폰번호=" + phoneNum + ", rentList=" + rentList + ", overdue=" + overdue
				+ "]";
	}

	@Override
	public int hashCode() {
		return (id + pwd).hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		
		if(!(obj instanceof Member)) {
			return false;
		}
		Member mb = (Member)obj;
		if(this.id.equals(mb.id) && this.pwd.equals(mb.pwd)) {
			return true;
		}
		return false;
	}

//	public String information() {
//		return "id : " + super.getId() + ", pwd : " + super.getPwd() + ", 이름 : " + super.getName() + ", 나이 : " + age
//				+ ", 성별 : " + gender + ", address : " + address + ", phoneNum : " + phoneNum + ", overdue=" + overdue;
//		/*
//		 * return "Member [id=\" + id + \", pwd=\" + pwd + \", name=\" + name + \"age="
//		 * + age + ", gender=" + gender + ", address=" + address + ", phoneNum=" +
//		 * phoneNum + ", overdue=" + overdue + "]";
//		 */
//
//	}
	
	

}
