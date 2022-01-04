package com.kh.miniproject.view;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Scanner;

<<<<<<< HEAD
import com.kh.miniproject.controller.MemberController;
=======
import com.kh.miniproject.model.dao.LoginDao;
import com.kh.miniproject.model.vo.Member;
>>>>>>> branch 'master' of https://github.com/DevelopHeon/TeamProject.git

public class ManagerLogin {

	public static final String mId = "manager"; // 관리자 아이디와 비밀번호는 상수로 생성
	public static final String mPwd = "12345";

	Scanner sc = new Scanner(System.in);

	ReviewBoard rc = new ReviewBoard();
	NoticeMenu nc = new NoticeMenu();
	BookMenu bm = new BookMenu();
<<<<<<< HEAD
	MemberController mc = new MemberController();
	
=======
	LoginDao ld = new LoginDao();

>>>>>>> branch 'master' of https://github.com/DevelopHeon/TeamProject.git
	public ManagerLogin() {

	}

	public void managerMainMenu() {

		while (true) {

			System.out.println("아이디 : ");
			String id = sc.nextLine();
			System.out.println("비밀번호 : ");
			String pwd = sc.nextLine();

			if (mId.equals(id) && pwd.equals(mPwd)) {
				System.out.println("로그인 성공");
				break;
			} else {
				System.out.println("로그인 실패했습니다. 다시 입력해보세요.");
				continue;

			}
		}

		while (true) {
			System.out.println("==== 관리자 메뉴 ====");
			System.out.println("1. 공지사항 관리");
			System.out.println("2. 도서 관리");
			System.out.println("3. 전체 회원 조회");
<<<<<<< HEAD
			
=======
>>>>>>> branch 'master' of https://github.com/DevelopHeon/TeamProject.git
			System.out.println("4. 리뷰 게시판 조회");
			System.out.println("0. 이전 메뉴로");
			System.out.println("메뉴 선택 : ");

			int menu = sc.nextInt();
			sc.nextLine();

			switch (menu) {
			case 1:
				nc.noticeManagement();
				break;
			case 2:
				bm.bookManagement();
				break;
			case 3:
				ld.LoginDaoOpen();
				break;
			case 4:
<<<<<<< HEAD
				reviewBoard();
=======
				rc.selectAll();
>>>>>>> branch 'master' of https://github.com/DevelopHeon/TeamProject.git
				break;
			case 0:
				System.out.println("이전 메뉴로 돌아갑니다.");
				return;
			default:
				System.out.println("잘못 입력하셨습니다. 메뉴를 다시 선택해주세요.");
				break;
			}
		}
	}

<<<<<<< HEAD
	public void allMember() {
		System.out.println("=====회원정보조회=====");
		
		int cnt = mc.getMemberCount(); 
		
		if(cnt == 0){ //회원이 0명이면
			System.out.println("현재 추가된 회원이 없습니다.");
			
			
		}

	}
		
	

	public void overdueMember() {
	}

	public void reviewBoard() {
	}
=======
//	// 회원 정보가 저장된 파일을 출력한다.
//	public void allMember() {
//
//		System.out.println("<전체 회원 정보 출력>");
//		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Member.dat"))) {
//
//			while (true) {
//
//				System.out.println((Member) ois.readObject());
//
//			}
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		} catch (FileNotFoundException e) {
//			System.out.println("출력할 회원 정보가 존재하지 않습니다.");
//		} catch (EOFException e) {
//			System.out.println("회원 정보 출력 완료");
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
>>>>>>> branch 'master' of https://github.com/DevelopHeon/TeamProject.git
}
