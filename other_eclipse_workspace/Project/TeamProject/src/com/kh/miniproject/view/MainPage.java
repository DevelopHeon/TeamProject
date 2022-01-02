package com.kh.miniproject.view;

import java.util.Scanner;

public class MainPage {
	
	public MainPage() {
		// TODO Auto-generated constructor stub
	}
	
	private Scanner sc = new Scanner(System.in);
	
	ManagerLogin mal = new ManagerLogin();
	MemberPage mem = new MemberPage();
	NoticeMenu nm = new NoticeMenu();
	
	public void mainMenu() {
		
		while(true) {
			System.out.println("==== 메뉴 ====");
			System.out.println("1. 관리자 로그인");
			System.out.println("2. 회원 로그인");
			System.out.println("3. 회원 가입");
			System.out.println("4. 공지사항");
			System.out.println("9. 프로그램 종료");
			System.out.println("메뉴 선택 : ");
			
			int menu = sc.nextInt();
			sc.nextLine();
			
			switch(menu) {
			case 1 :
				mal.managerMainMenu(); 
				break;
			case 2 :
				mem.memberMainMenu();
				break;
			case 3 :
				join();
				break;
			case 4 :
				nm.noticeMenu();
				break;
			case 9 :
				System.out.println("프로그램을 종료합니다.");
				return;
			default :
				System.out.println("잘못 입력하셨습니다. 메뉴를 다시 선택해주세요.");
				break;
			}
			
		}
		
	}
	
	public void join() {}
	
}

