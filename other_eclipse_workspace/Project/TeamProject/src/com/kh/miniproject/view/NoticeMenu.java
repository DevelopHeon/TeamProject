package com.kh.miniproject.view;

import java.util.Scanner;

import com.kh.miniproject.controller.NoticeController;

public class NoticeMenu {

	Scanner sc = new Scanner(System.in);
	// 공지사항 게시판 목록
//	ArrayList<Notice> noticeList = new ArrayList<Notice>();

	NoticeController nc = new NoticeController();

	public NoticeMenu() {

	}

	// 공지 사항 관리.
	public void noticeManagement() {


		
		while(true) {

			System.out.println("===== 공지 게시판 =====");
			System.out.println("1. 공지사항 전체 조회");
			System.out.println("2. 공지사항 등록");
			System.out.println("3. 공지사항 수정");
			System.out.println("4. 공지사항 삭제");
			System.out.println("5. 공지사항 한 개 보기");
			System.out.println("6. 정렬하기 ");
			System.out.println("7. 공지사항 전체 삭제 ");
			System.out.println("0. 이전 메뉴로");
			System.out.println("원하시는 메뉴를 입력하세요.");
			int menu = sc.nextInt();
			sc.nextLine();

			switch (menu) {
			case 1:
				nc.noticeAllList();
				break;
			case 2:
				nc.noticeInsert();
				break;
			case 3:
				nc.noticeEdit();
				break;
			case 4:
				nc.noticeDelete();
				break;
			case 5:
				nc.oneList();
				break;
			case 6:
				noticesort();
				break;
			case 7:
				nc.allClear();
				break;
			case 0:
				System.out.println("이전 메뉴로 돌아갑니다.");
				return;
			default:
				System.out.println("잘못된 메뉴입니다. 재입력 해주세요.");
				break;

			}

		}
	}

	//7. 정렬하기 Comparator 클래스 생성하고 불러온다.
	public void noticesort() {
		System.out.println("<정렬 할 메뉴 선택>");
		System.out.println("1. 제목 오름차순 정렬 ");
		System.out.println("2. 제목 내림차순 정렬 ");
		System.out.println("3. 공지사항 번호 오름차순 정렬");
		System.out.println("4. 공지사항 번호 내림차순 정렬");
		System.out.println("메뉴를 선택하세요 : ");
		int menu = sc.nextInt();
		sc.nextLine();
		
		if(menu == 1) {
			nc.sortList(1);
		}else if(menu == 2) {
			nc.sortList(2);
		}else if(menu == 3) {
			nc.sortList(3);
		}else if(menu == 4) {
			nc.sortList(4);
		}else {
			System.out.println("잘못 입력하셨습니다. 이전메뉴로 돌아갑니다.");
		}
	}
}
