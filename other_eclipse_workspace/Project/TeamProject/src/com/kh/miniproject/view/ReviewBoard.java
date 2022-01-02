package com.kh.miniproject.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.kh.miniproject.controller.ReviewController;
import com.kh.miniproject.model.vo.Member;
import com.kh.miniproject.model.vo.Review;

public class ReviewBoard {
	
	private ReviewController rc = new ReviewController();
	Scanner sc = new Scanner(System.in);
	
	public ReviewBoard() { //기본생성자
	}

	public void ReviewBoard() {
		
		//==== 리뷰 메뉴 ==== //무한 반복 실행
		//1. 리뷰 게시판 조회
		//2. 리뷰 작성
		//3. 리뷰 내역 조회
		//0. 이전 메뉴로 가기
		//9. 프로그램 종료
		
		while(true) {
			System.out.println("< 리뷰 메뉴 >");
			System.out.println("1. 리뷰 게시판 조회");
			System.out.println("2. 리뷰 작성");
			System.out.println("3. 리뷰 내역 조회");
			System.out.println("0. 이전 메뉴로 가기");
			System.out.println("9. 프로그램 종료");
			System.out.println("번호를 입력하세요 : ");
			int num = sc.nextInt();
			sc.nextLine(); //엔터 빼주기
			
			switch(num) {
			case 1 :
				selectAll(); //전체 조회
				break;
			case 2 :
				writeReview(); //리뷰 작성
				break;
			case 3 :
				myReview(); //나의 리뷰 조회
				break;
			case 0 :
				System.out.println("이전 메뉴로 돌아갑니다.");
				break;
			case 9 :
				System.out.println("프로그램을 종료합니다.");
				return;
			default :
				System.out.println("번호를 잘못 입력하셨습니다. 다시 입력해주세요.");
				break;
			}
		}
		
	}

	//리뷰 조회, 도서 제목 검색을 통해 리뷰 출력
	public void selectAll() {
		System.out.println("< 리뷰 게시판 조회 >");
		//ReviewController의 slectAll() 메소드 호출하여 결과 값을 Review에 담기
		ArrayList<Review> rList = rc.selectAll();
		
		for(Review r : rList) {
			System.out.println(r);
		}
		
		//검색 -> 키워드로
		while(true) {
			System.out.println();//한줄 띄기
			System.out.println("1. 검색하기");
			System.out.println("0. 이전 메뉴로 돌아가기");
			System.out.println("번호를 입력하세요 : ");
			int num = sc.nextInt();
			sc.nextLine();
			
			if(num == 1) {
				System.out.println("검색할 제목을 입력하세요 : ");
				String title = sc.nextLine();
				ArrayList<Review> searchList = rc.searchBook(title);
				
				// searchList가 비어 있을 경우 >> “검색 결과가 존재하지 않습니다.”출력
				// searchList가 비어있지 않을 경우 >> for문을 이용하여 searchList 출력
				if(searchList.isEmpty() == true) { //isEmpty()가 true면 비어있다는 것 = 검색결과 없음
					System.out.println("검색 결과가 존재하지 않습니다.");
				} else {
					for(Review review : searchList) {
						System.out.println(review);
					}
				}
				
			}else if(num == 0) {
				System.out.println("이전 메뉴로 돌아갑니다.");
				break;
			}else {
				System.out.println("번호를 잘못 입력하셨습니다. 다시 입력해주세요.");
				break;
			}
			
		}
		
	}
	//리뷰 적기
	public void writeReview() { //리뷰에 추가
		
		System.out.println("< 리뷰 작성 >");
		
		System.out.println("회원 아이디를 입력하세요 : ");
		String userId = sc.nextLine();
		
		System.out.println("책 제목 : ");
		String title = sc.nextLine();
		
		System.out.println("리뷰 내용 : ");
		String text = sc.nextLine();
		
		// 위에서 입력 받은 title, text를 매개변수로 한 Review 객체 생성 (review)
		// ReviewController의 writeReview 메소드로 review 전달
		
		Review review = new Review(userId, title, text); //count 
		rc.writeReview(review);
	
	}
	//나의 리뷰내역 조회
	public void myReview() {
		
		while(true) {
			System.out.println("< 나의 리뷰내역 조회 >");
			
			System.out.println("회원 아이디를 입력하세요 : ");
			String userId = sc.nextLine();
			
			ArrayList<Review> checkList = rc.checkId(userId);
			
			if(checkList.isEmpty() == true) {
				System.out.println("작성한 리뷰가 존재 하지 않습니다.");
				break;
			
			}else {
				
				System.out.println(checkList);
				//리뷰 수정, 삭제
				System.out.println("1. 리뷰 수정");
				System.out.println("2. 리뷰 삭제");
				System.out.println("0. 이전 메뉴로 돌아가기");
				System.out.println("번호를 입력하세요 : ");
				int num = sc.nextInt();
				sc.nextLine();
				
				//리뷰 수정 창
				if(num == 1) {
					while(true) {
						System.out.println("< 리뷰 수정 >");
						System.out.println("1. 제목 수정");
						System.out.println("2. 내용 수정");
						System.out.println("0. 이전 메뉴로");
						System.out.println("번호를 입력하세요 : ");
						int num2 = sc.nextInt();
						sc.nextLine();
						
						switch(num2) {
						case 1 :
							System.out.println("변경할 제목을 입력하세요 : ");
							String title = sc.nextLine();
							rc.updateTitle(checkList, title);
							break;
						case 2 :
							System.out.println("변경할 내용을 입력하세요 : ");
							String review = sc.nextLine();
							rc.updateReview(checkList, review);
							break;
						case 0 :
							System.out.println("이전 메뉴로 돌아갑니다.");
							return;
						default :
							System.out.println("번호를 잘못 입력하셨습니다. 다시 입력해주세요.");
							break;
						}										
					}	
				}
				else if(num == 2) {
					deleteReview();
				}
				else if(num == 0) {
					System.out.println("이전 메뉴로 돌아갑니다.");
					break;
				}else {
					System.out.println("번호를 잘못 입력하셨습니다. 다시 입력해주세요.");
					break;
				}
			}			
		}
	}


	public void deleteReview() {
		System.out.println("삭제할 리뷰 번호를 입력해주세요 : ");
		int rNo = sc.nextInt();
		sc.nextLine();
		
		int result = rc.deleteReview(rNo); 
		
		
		if(result == 1) {
			System.out.println("정말 삭제하시겠습니까?(y/n) : ");
			char respon = sc.nextLine().toUpperCase().charAt(0);
			
			if(respon == 'Y') {
				rc.deleteReview(rNo);
				System.out.println("리뷰가 삭제 되었습니다.");
			}else {
				System.out.println("리뷰 삭제가 취소 되었습니다.");
				return;
			}
		}

	
	}
	

}
