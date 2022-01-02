package com.kh.miniproject.model.vo;
// toString은 안 만들었어요
public class Member extends Admin{
	
	private int age;
	
	private char gender;
	
	private String address;
	
	private String phoneNum;
	
	private int overdue;
	
	public Member() {
		
	}

	public Member(String id, String pwd, String name, int age, 
			char gender, String address, String phoneNum, int overdue) {
		
		super(id, pwd, name);
		this.age = age;
		this.gender = gender;
		this.address = address;
		this.phoneNum = phoneNum;
		this.overdue = overdue;
	}

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
	
	

}
