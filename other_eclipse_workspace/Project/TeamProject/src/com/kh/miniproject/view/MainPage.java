package com.kh.miniproject.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.kh.miniproject.controller.MemberController;
import com.kh.miniproject.controller.NoticeController;
import com.kh.miniproject.model.dao.LoginDao;
import com.kh.miniproject.model.vo.Member;

public class MainPage {

	public MainPage() {

	}

	private Scanner sc = new Scanner(System.in);

	MemberController mc = new MemberController();
	ManagerLogin mal = new ManagerLogin();
	MemberPage mp = new MemberPage();
	NoticeController nc = new NoticeController();
	LoginDao ld = new LoginDao();

	MemberPage mem = new MemberPage();
							
	public void mainMenu() {

		while (true) {
			System.out.println("==== 메뉴 ====");
			System.out.println("1. 관리자 로그인");
			System.out.println("2. 회원 로그인");
			System.out.println("3. 회원 가입");
			System.out.println("4. 공지사항");
			System.out.println("9. 프로그램 종료");
			System.out.println("메뉴 선택 : ");

			int menu = sc.nextInt();
			sc.nextLine();

			switch (menu) {
			case 1:
				mal.managerMainMenu();
				break;
			case 2:
				mc.login();
				break;
			case 3:
				mc.join();
				break;
			case 4:
				nc.noticeAllList();
				break;
			case 9:
				System.out.println("프로그램을 종료합니다.");
				return;
			default:
				System.out.println("잘못 입력하셨습니다. 메뉴를 다시 선택해주세요.");
				break;
			}

		}

	}
}

	

	