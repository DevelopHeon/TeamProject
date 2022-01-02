package com.kh.miniproject.view;

import java.util.Scanner;

import com.kh.miniproject.controller.MemberController;
import com.kh.miniproject.model.vo.Member;
import com.kh.miniproject.view.MainPage;

public class MainPage {

	public MainPage() {

	}

	private Scanner sc = new Scanner(System.in);

	MemberController mc = new MemberController();
	ManagerLogin mal = new ManagerLogin();
	MemberPage mp = new MemberPage();
	NoticeMenu nm = new NoticeMenu();

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
				login();
				break;
			case 3:
				join();

				break;
			case 4:
				nm.selectList();
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

	public void login() {

		System.out.println("id :");
		String id = sc.nextLine();

		System.out.println("pwd :");
		String pwd = sc.nextLine();

		int result = mc.login(id, pwd);
		System.out.println("reult : " + result);

		if (result == 1) {
			mp.memberMainMenu();
		} else {
			System.out.println("로그인에 실패하였습니다.");
		}

	}

	public void join() {
		// 아이디 입력
		System.out.println("아이디 :");
		String id = sc.nextLine();

		// 중복 아이디 확인
		Member m = mc.checkId(id);
		if (m != null) {
			System.out.println("동일한 아이디가 존재합니다.");

		} else {
			System.out.println("비밀번호 : ");
			String pwd = sc.nextLine();

			System.out.print("이름 : ");
			String name = sc.nextLine();

			System.out.print("나이 : ");
			int age = sc.nextInt();
			sc.nextLine();

			System.out.print("성별 : ");
			char gender = sc.nextLine().charAt(0);

			System.out.println("주소 :");
			String address = sc.nextLine();
			System.out.println("휴대폰 번호 : ");
			String phoneNum = sc.nextLine();

			Member newMember = new Member(id, pwd, name, age, gender, address, phoneNum, 0);

			mc.insertMember(newMember);
		}

	}
}