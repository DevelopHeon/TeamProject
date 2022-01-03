package com.kh.miniproject.model.vo;

import java.io.Serializable;

// toString은 안 만들었어요
public class Member extends Admin implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2378811559915259317L;

	// 필드부
	private int age;

	private char gender;

	private String address;

	private String phoneNum;

	private int overdue;

	public Member() {

	}

	public Member(String id, String pwd, String name, int age, char gender, String address, String phoneNum,
			int overdue) {

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

	public String information() {
		return "id : " + super.getId() + ", pwd : " + super.getPwd() + ", 이름 : " + super.getName() + ", 나이 : " + age
				+ ", 성별 : " + gender + ", address : " + address + ", phoneNum : " + phoneNum + ", overdue=" + overdue;
		/*
		 * return "Member [id=\" + id + \", pwd=\" + pwd + \", name=\" + name + \"age="
		 * + age + ", gender=" + gender + ", address=" + address + ", phoneNum=" +
		 * phoneNum + ", overdue=" + overdue + "]";
		 */

	}

}
