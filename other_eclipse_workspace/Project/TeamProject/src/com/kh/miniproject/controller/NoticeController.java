package com.kh.miniproject.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import com.kh.miniproject.model.vo.Notice;

public class NoticeController {

	Scanner sc = new Scanner(System.in);
	// 객체 담아주고 넘겨받은 값 추가해주고 하기 위한 ArrayList 생성. 크기가 제한되어있지않아 좋다.
	ArrayList<Notice> noticeList = new ArrayList<Notice>();

	public NoticeController() {
	} // 기본 생성자

	{ // 공지사항 초기화 블럭을 이용해 초기화
		noticeList.add(new Notice("휴무 일정", "12월 31일, 1월 1일, 설날은 휴무입니다. 다른 날..."));
		noticeList.add(new Notice("** 기념행사", "이번 달 1달간 기념으로 ..."));
		noticeList.add(new Notice("최우수 독서왕 행사", "책을 읽고 가장 많은 리뷰..."));
		noticeList.add(new Notice("프로젝트가 하기 싫다.", "주말에도 이러고 있는게 싫은 사람이.."));
		noticeList.add(new Notice("가위바위보", "가위바위보를 이기면"));

		// 공지사항 번호 넣어주기 위한 변수 선언
		int i = 1;

		for (Notice n : noticeList) {
			n.setNoticeNum(i++);
		}

	}

	public ArrayList<Notice> selectList() {
		// 공지 사항 조회
		return noticeList;
	}

	public void insertNotice(Notice notice) {
		// 매개변수로 전달받은 Notice타입 객체를 공지사항 목록에 추가해준다.
		// noticeMenu에서 호출
		int lastNo = 0;

		try {
			lastNo = noticeList.get(noticeList.size() - 1).getNoticeNum() + 1;

		} catch (IndexOutOfBoundsException e) {계속 진도가 나간다고 능사가 아닐 것 같은데, 

			lastNo = 1;
		}
		// setter 이용해서 매개변수로 받은 notice에 마지막 번호 추가
		notice.setNoticeNum(lastNo);

		// 공지사항 등록 전 한 번 더 물어본다.
		System.out.println("공지사항을 추가하시겠습니까? (y/n)");
		String input = sc.next();
		// 소문자 대문자 구분 없이 y이면
		if (input.equalsIgnoreCase("y")) {
			// ArrayList인 noticeList에 add 메소드로 추가
			noticeList.add(notice);
			System.out.println("공지사항 등록이 완료 되었습니다.");

		} else {
			// 그 외에 대답은 공지사항 등록 취소 이전 메뉴로 돌아간다.
			System.out.println("공지사항 등록을 취소합니다. 이전 메뉴로 돌아갑니다.");
			return;
		}

	}

	public void editNotice(int num) {
		// 매개 변수로 넘겨받은 번호의 공지사항을 수정

		for (int i = 0; i < noticeList.size(); i++) {
			if (noticeList.get(i).getNoticeNum() == num) {
				System.out.println("공지사항 중 수정할 메뉴를 선택하세요. (1. 제목 , 2. 내용)");
				int menu = sc.nextInt();
				sc.nextLine();

				// menu 1번 선택시 제목 변경
				if (menu == 1) {
					System.out.println("변경 할 제목 : ");
					String title = sc.nextLine();

					// 공지사항 등록 전 수정 할 것인지 한번 더 물어본다.
					System.out.println("공지사항을 수정 하시겠습니까? (y/n) ");
					String tInput = sc.nextLine();

					if (tInput.equalsIgnoreCase("y")) {
						noticeList.get(i).setNoticeTitle(title);
						System.out.println("제목 수정이 완료 되었습니다.");
					} else {
						System.out.println("제목 수정 등록이 취소되었습니다. 이전 메뉴로 돌아갑니다.");
						return;
					}

					// menu 2번 선택시 내용 변경
				} else if (menu == 2) {
					System.out.println("변경 할 내용 : ");
					String content = sc.nextLine();

					System.out.println("공지사항을 수정 하시겠습니까? (y/n) ");
					String cInput = sc.nextLine();

					if (cInput.equalsIgnoreCase("y")) {
						noticeList.get(i).setNoticeContent(content);
						System.out.println("내용 수정이 완료 되었습니다.");
					} else {
						System.out.println("내용 수정 등록이 취소되었습니다. 이전 메뉴로 돌아갑니다.");
						return;
					}
				}
			}
		}
	}

	public int deleteNotice(int nNo) {
		// 공지사항 번호 넘겨받아서 삭제 반환값은 int형이다.

		int index = 1;
		for (int i = 0; i < noticeList.size(); i++) {

			if (noticeList.get(i).getNoticeNum() == nNo) {
				// 매개변수 nNo과 같다면

				System.out.println("해당 공지사항을 삭제하시겠습니까 ? (y/n) ");
				String dInput = sc.nextLine();

				// 공지사항을 삭제 할 경우
				if (dInput.equalsIgnoreCase("y")) {

					noticeList.remove(noticeList.get(i)); // 그 객체 삭제 i번째 객체가 들어오기때문

					// 다시 remove한 객체부터 땡겨서 정렬해주기 위해 for문 선언
					for (Notice n : noticeList) {
						n.setNoticeNum(index++);
					}
					// comparable 오버라이딩해서 오름차순으로 정렬해준다.
					Collections.sort(noticeList);
					return 1;
				} else if (dInput.equalsIgnoreCase("n")) {
					return 2;
				} else {
					System.out.println("잘못 입력 하셨습니다.");
					return 3;
				}
			}
		}
		// 위 구문에서 for문 타지 않았을시 0 반환
		return 0;
	}
}
