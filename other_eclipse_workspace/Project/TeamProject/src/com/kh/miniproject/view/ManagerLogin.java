package com.kh.miniproject.view;

import java.util.Scanner;

public class ManagerLogin {
	
	Scanner sc = new Scanner(System.in);
	
	NoticeMenu nc = new NoticeMenu();
	
	public ManagerLogin() {
		// TODO Auto-generated constructor stub
	}
	
	public void managerMainMenu() {
		
		while(true) {
			System.out.println("==== 관리자 메뉴 ====");
			System.out.println("1. 공지사항 관리");
			System.out.println("2. 도서 관리");
			System.out.println("3. 전체 회원 조회");
			System.out.println("4. 연체회원 조회");
			System.out.println("5. 리뷰 게시판 조회");
			System.out.println("0. 이전 메뉴로");
			System.out.println("메뉴 선택 : ");
			
			int menu = sc.nextInt();
			sc.nextLine();
			
			switch(menu) {
			case 1 :
				nc.noticeManagement();
				break;
			case 2 :
				bookManagement();
				break;
			case 3 :
				allMember();
				break;
			case 4 :
				overdueMember();
				break;
			case 5 :
				reviewBoard();
				break;
			case 0 :
				System.out.println("이전 메뉴로 돌아갑니다.");
				return;
			default :
				System.out.println("잘못 입력하셨습니다. 메뉴를 다시 선택해주세요.");
				break;
			}
		}
	}
	
	
	public void bookManagement() {}
	
	public void allMember() {}
	
	public void overdueMember() {}
	
	public void reviewBoard() {}
}
