package com.kh.miniproject.model.vo;

import java.io.Serializable;
import java.util.ArrayList;//전재은

// toString은 안 만들었어요
public class Member implements Serializable{

	
	private static final long serialVersionUID = 5461114678133906765L;

	private String id;
	
	private String pwd;
	
	private String name;
	
	private int age;

	private char gender;

	private String address;

	private String phoneNum;
	
	//전재은
	private ArrayList<Book> rentList;

	

	public Member(String id, String pwd, String name, int age, char gender, String address, String phoneNum) {

//		super(id, pwd, name);
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.address = address;
		this.phoneNum = phoneNum;
		
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


	

	@Override
	public String toString() {
		return "회원 [id=" + id + ", pwd=" + pwd + ", 이름=" + name + ", 나이=" + age + ", 성별=" + gender
				+ ", 주소=" + address + ", 핸드폰번호=" + phoneNum + ", rentList=" + rentList ;
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return (id+pwd+name+age+gender+address+phoneNum).hashCode(); 
	}

	@Override 
	public boolean equals(Object obj) {
		if(!(obj instanceof Member)) {
			return false;
		}
		
		Member other = (Member)obj;
		if(this.id.equals(other.id)&& this.pwd.equals(other.pwd)) {
			return true;
		}else {
		}
		return false;
	}



}
