package com.kh.miniproject.model.vo;

import java.io.Serializable;
import java.util.ArrayList;

// toString은 안 만들었어요

public class Member implements Serializable{

	

	private static final long serialVersionUID = 5461114678133906765L;

	private String id;
	
	private String pwd;
	
	private String name;

	public Member() { }

	


	public Member(String id, String pwd, String name) {

		this.id = id;
		this.pwd = pwd;
		this.name = name;

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


	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return (id+pwd+name).hashCode(); 
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
