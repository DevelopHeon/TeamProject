package com.kh.miniproject.run;


import com.kh.miniproject.model.dao.LoginDao;

import com.kh.miniproject.view.MainPage;

public class Run {

	public static void main(String[] args) {
	
	MainPage main = new MainPage();
		main.mainMenu();
		
		LoginDao ld = new LoginDao();
		ld.LoginDaoOpen();
		
//		MemberDao md = new MemberDao();
	}
	
}
