package com.kh.miniproject.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import com.kh.miniproject.model.dao.NoticeDao;
import com.kh.miniproject.model.noticeComparator.AscNoticeNum;
import com.kh.miniproject.model.noticeComparator.AscNoticeTitle;
import com.kh.miniproject.model.noticeComparator.DescNoticeNum;
import com.kh.miniproject.model.noticeComparator.DescNoticeTitle;
import com.kh.miniproject.model.vo.Notice;
import com.kh.miniproject.view.ManagerLogin;

public class NoticeController {

	NoticeDao nd = new NoticeDao();
	Scanner sc = new Scanner(System.in);
	// 객체 담아주고 넘겨받은 값 추가해주고 하기 위한 ArrayList 생성. 크기가 제한되어있지않아 좋다.
	ArrayList<Notice> noticeList = new ArrayList<Notice>();

	public NoticeController() {
	} // 기본 생성자

	public void noticeAllList() {
		// 공지 사항 전체 조회 반복자 사용
		Iterator it = nd.displayAllList().iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
	
	public void noticeDelete() {
		System.out.print("삭제할 공지사항 번호를 입력하세요.");
		int nNo = sc.nextInt();
		sc.nextLine();
		
		//게시글 한개만 조회하기로 번호 던져준다.
		Notice notice = nd.oneList(nNo);
		
		if(notice == null) {
			System.out.println("삭제할 공지사항 번호가 존재하지 않습니다.");
		}else {
			// 담긴 공지사항 출력
			System.out.println(notice);
			
			System.out.println("해당 공지사항을 삭제하시겠습니까 ? (y/n) ");
			String input = sc.nextLine();
			
			if(input.equalsIgnoreCase("y")) {
				nd.deleteNotice(nNo);
				System.out.println(nNo + "번 공지사항이 삭제되었습니다.");
			}
			
		}
	}

	public void oneList() {
		System.out.print("조회할 공지사항 번호를 입력하세요 : ");
		int no = sc.nextInt();

		Notice notice = nd.oneList(no);

		if (notice == null) {
			System.out.println("조회된 공지사항이 없습니다.");
		} else {
			System.out.println(notice);
		}

	}

	// 공지사항 파일에 저장하기
	public void fileSave() {

		// NoticeDao에 있는 fileSave 메소드 호출
		nd.fileSave();

	}

	// 공지사항 수정하기
	public void noticeEdit() { // 공지사항 수정
		// 공지사항 수정은 공지사항 번호로 호출하여 수정하도록 작성
		System.out.println("몇 번째 공지사항을 수정하시겠습니까 ? ");
		int num = sc.nextInt();
		sc.nextLine();

		// NoticeController에 있는 메소드에 매개변수로 값을 넘겨준다
		nd.editNotice(num);

	}

	// 공지사항 등록하기
	public void noticeInsert() { // 공지사항 등록
		System.out.println("<새 공지사항 등록>");

		System.out.print("공지사항 제목 : ");
		String title = sc.nextLine();

		System.out.print("공지사항 내용 : ");
		String content = sc.nextLine();

		try {
			nd.writeNotice(new Notice(nd.getLastNoticeNo() + 1, title, content));
		} catch (IndexOutOfBoundsException e) {
			nd.writeNotice(new Notice(1, title, content));
		}

	}

	public void sortList(int menu) {

		ArrayList<Notice> nList = nd.displayAllList();
		
		if(menu == 1) { // 제목 오름차순 정렬
			nList.sort(new AscNoticeTitle());
		}else if(menu == 2) { // 제목 내림차순 정렬
			nList.sort(new DescNoticeTitle());
		}else if(menu == 3) {
			nList.sort(new AscNoticeNum());
		}else if(menu == 4) {
			nList.sort(new DescNoticeNum());
		}
		
	}

	// 공지사항 전체 삭제
	public void allClear() {
		// 공지사항 목록 출력
		
		System.out.println("<현재 공지사항 목록>");
		// 현재 목록 출력
		noticeAllList();
		
		noticeList = nd.displayAllList();
		
		// size()가 0일 경우 공지사항 존재하지 않는다고 멘트 뜨게 하려는데 안뜸 이유가..?
		for(int i=0; i<noticeList.size(); i++) {
			if(noticeList.isEmpty()) {
				System.out.println("공지사항이 존재하지 않습니다.");
			}else {
				System.out.println();
				System.out.println("관리자의 암호를 입력하세요.");
				String pwd = sc.nextLine();
				if(pwd.equals(ManagerLogin.MPWD)) {
					System.out.println("공지사항을 전부 삭제하시겠습니까? (y/n)");
					String input = sc.nextLine();
					
					if(input.equalsIgnoreCase("y")) {
						nd.allClear();
						System.out.println("성공적으로 공지사항을 삭제하였습니다.");
					}else {
						System.out.println("잘못 입력하셨습니다. 이전메뉴로 돌아갑니다.");
						return;
					}
				}
			}
		}
	}
}
