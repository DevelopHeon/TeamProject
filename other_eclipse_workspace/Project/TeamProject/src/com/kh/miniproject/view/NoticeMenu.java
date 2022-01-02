package com.kh.miniproject.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.kh.miniproject.controller.NoticeController;
import com.kh.miniproject.model.vo.Notice;

public class NoticeMenu {
	
	Scanner sc = new Scanner(System.in);
	// 공지사항 게시판 목록
	ArrayList<Notice> noticeList = new ArrayList<Notice>();
	
	NoticeController nc = new NoticeController();
	
	public NoticeMenu() {
		
	}

	// 공지 사항 관리.
	public void noticeManagement() {
		
		while(true) {
			System.out.println("===== 공지 게시판 =====");
			System.out.println("1. 공지사항 조회");
			System.out.println("2. 공지사항 등록");
			System.out.println("3. 공지사항 수정");
			System.out.println("4. 공지사항 삭제");
			System.out.println("0. 이전 메뉴로");
			System.out.println("원하시는 메뉴를 입력하세요.");
			int menu = sc.nextInt();
			sc.nextLine();
			
			switch(menu) {
			case 1:
				selectList();
				break;
			case 2:
				noticeInsert();
				break;
			case 3:
				noticeEdit();
				break;
			case 4:
				noticeDelete();
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


	public void selectList() {
		// 공지사항 조회 호출
		ArrayList<Notice> noticeList = nc.selectList();
		
		if(noticeList.isEmpty()) { // 공지사항이 비어있을 경우
			System.out.println("공지 사항이 존재하지 않습니다.");
		}else {
			// 비어있지 않다면 for each를 통해 출력
			for(Notice n : noticeList) {
				System.out.println(n);
			}
		}
		
	}

	public void noticeInsert() { // 공지사항 등록
		
		System.out.print("공지사항 제목 : ");
		String title = sc.nextLine();
		
		System.out.print("공지사항 내용 : ");
		String content = sc.nextLine();
//		sc.nextLine();
		
		Notice notice = new Notice(title, content); // 컨트롤러에 위 객체 매개변수로 넘겨준다.
		nc.insertNotice(notice);
		
	}
	
	public void noticeEdit() { // 공지사항 수정
		// 공지사항 수정은 공지사항 번호로 호출하여 수정하도록 작성
		System.out.println("몇 번째 공지사항을 수정하시겠습니까 ? ");
		int num = sc.nextInt();
		sc.nextLine();
		
		//NoticeController에 있는 메소드에 매개변수로 값을 넘겨준다
		nc.editNotice(num);
		
	}
	
	public void noticeDelete() { // 공지사항 삭제
		
		System.out.print("삭제할 공지사항 번호를 입력하세요.");
		int nNo = sc.nextInt();
		sc.nextLine();
		
		// 삭제할 공지사항 번호를 매개변수로 받는 메소드 호출
		int result = nc.deleteNotice(nNo);
		
		if(result == 1) {
			System.out.println("삭제가 완료 되었습니다.");
		}else if(result == 2){
			System.out.println("삭제 취소, 이전 메뉴로 돌아갑니다.");
		}else if(result == 0) {
			System.out.println("삭제 할 공지사항이 없습니다.");
		}else {
			System.out.println("잘못 입력하여 이전 메뉴로 돌아갑니다.");
		}
	}

	
}
