package com.kh.miniproject.run;

import com.kh.miniproject.view.MainPage;
import com.kh.miniproject.view.ReviewBoard;

public class Run {

	public static void main(String[] args) {
	
		MainPage main = new MainPage();
		main.mainMenu();
		
		ReviewBoard review = new ReviewBoard();
		review.ReviewBoard();
		
		
	}
	

}
