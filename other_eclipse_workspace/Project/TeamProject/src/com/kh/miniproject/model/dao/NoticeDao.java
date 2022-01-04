package com.kh.miniproject.model.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import com.kh.miniproject.model.vo.Notice;

public class NoticeDao {

	Scanner sc = new Scanner(System.in);

	ArrayList<Notice> noticeList = new ArrayList<Notice>();

	public NoticeDao() { // 입력 받아서 생성자로 호출
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("noticeFile.dat"))) {

			// ArrayList에 있는 addAll메소드로 불러온다.
			noticeList.addAll((ArrayList<Notice>) ois.readObject());

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	// 1. 공지사항 전체 조회
	public ArrayList<Notice> displayAllList() {

		return noticeList;
	}

	// 마지막 번호 얻어 오기
	public int getLastNoticeNo() {
		return noticeList.get(noticeList.size() - 1).getNoticeNum();

	}

	// 2. 게시글 등록
	public void writeNotice(Notice notice) {
		noticeList.add(notice);
		fileSave();
	}

	// 3. 공지사항 수정하기
	public void editNotice(int num) {
		// 매개 변수로 넘겨받은 번호의 공지사항을 수정

		for (int i = 0; i < noticeList.size(); i++) {
			if (noticeList.get(i).getNoticeNum() == num) {
				System.out.println("공지사항 중 수정할 메뉴를 선택하세요. (1. 제목 , 2. 내용)");
				int menu = sc.nextInt();
				sc.nextLine();

				// menu 1번 선택시 제목 변경
				if (menu == 1) {
					System.out.print("변경 할 제목 : ");
					String title = sc.nextLine();

					// 공지사항 등록 전 수정 할 것인지 한번 더 물어본다.
					System.out.print("공지사항을 수정 하시겠습니까? (y/n) ");
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
					System.out.print("변경 할 내용 : ");
					String content = sc.nextLine();

					System.out.print("공지사항을 수정 하시겠습니까? (y/n) ");
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
		fileSave();
	}

	// 공지사항 삭제 후 오름차순 정렬
	public void deleteNotice(int nNo) {
		
		int index = 1;
		for(int i=0; i<noticeList.size(); i++) {
			
			// 만약 nNo하고 공지사항 리스트 중 같은 번호의 공지사항이 있으면
			if(noticeList.get(i).getNoticeNum() == nNo) {
			// 해당 공지사항 삭제
				noticeList.remove(noticeList.get(i));
				
				//삭제 된 곳부터 번호 땡겨주기
				for(Notice n : noticeList) {
					n.setNoticeNum(index++);
				}
				//comparable 오버라이딩해서 오름차순으로 정렬해준다.
				Collections.sort(noticeList);
				fileSave();
				break;
			}
		}
	}

	// 5. 공지사항 한개만 조회
	public Notice oneList(int no) {
		// Notice 객체 null로 선언
		Notice notice = null;

		for (Notice n : noticeList) {
			// for문 돌리면서 입력받은 번호와 기존 공지사항 번호가 같으면
			if (n.getNoticeNum() == no) {
				// 그 객체를 미리 선언해둔 변수에 담고 종료
				notice = n;
				break;
			}
		}
		// if문 타지 않을시 그냥 null값 반환
		return notice;
	}

	// 6. 공지사항 저장하기
	public void fileSave() {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("noticeFile.dat"))) {
			oos.writeObject(noticeList);
			
		} catch (FileNotFoundException e) {
			System.out.println("저장 할 파일을 찾을 수 없습니다.");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void allClear() {
		// clear() 메소드로 공지사항 전체 삭제
		noticeList.clear();
		fileSave();
	}

}
