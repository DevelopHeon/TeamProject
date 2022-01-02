package com.kh.miniproject.model.vo;

public class Manager extends Admin{
	
	private String dept; // 부서
	
	private String rank; // 직급
	
	public Manager() {
		
	}
	
	public Manager(String id, String pwd, String name, String dept, String rank) {
		super(id, pwd, name);
		this.dept = dept;
		this.rank = rank;

	}


	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}
	
	
}
