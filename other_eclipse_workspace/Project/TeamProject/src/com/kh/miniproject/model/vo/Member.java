package com.kh.miniproject.model.vo;

import java.io.Serializable;

// toString은 안 만들었어요
public class Member implements Serializable {
	/**
	 * 
	 */
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
	public String toString() {
		return "회원 [id=" + id + ", pwd=" + pwd + ", 이름=" + name +"]";
	}
	
}
