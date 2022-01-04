package com.kh.miniproject.model.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Scanner;

import com.kh.miniproject.model.vo.Member;

public class MemberDao {

	Scanner sc = new Scanner(System.in);

	public ArrayList<Member> memList = new ArrayList<Member>();
	{ 
		// 초기화 블록
		memList.add(new Member("user1", "user1", "홍길동", 10, 'M', "서울시 마포구", "010-1234-4567"));
		memList.add(new Member("user2", "user2", "도라지", 11, 'F', "서울시 용산구", "010-5656-5656"));
		memList.add(new Member("user3", "user3", "미역국", 12, 'M', "서울시 강남구", "010-8989-8989"));
	
	 {
		 
	}
	
	}
	
	
	public MemberDao() {
	
		try(ObjectInputStream my = new ObjectInputStream(new FileInputStream("memberFile.dat"))) {
			
			for(int i = 0 ; i< memList.size(); i ++) {
		
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	} 


	
	// 회원등록
	public void join(Member join) {
		for (int i = 0; i < memList.size(); i++) {
			if (memList.get(i).getId() == null) {
				memList.add(join);
			} else {
				System.out.println("이미 등록된 아이디입니다.");

			}
		}

	}

	// 회원정보수정
	public void memberInfoEdit(String info) {
		for (int i = 0; i < memList.size(); i++) {
			System.out.println("1. 비밀번호 2. 이름 3. 나이 4. 성별 5. 주소 6. 휴대폰 번호");
			int menu = sc.nextInt();
			
			// 1번 선택 시
			if (menu == 1) {
				System.out.println("기존 정보 : " + memList.toString());
				System.out.println("변경 할 비밀번호 :");
				String pwd = sc.nextLine();

				System.out.println("비밀번호를 수정하시겠습니까? (y/n) ");
				String pInput = sc.nextLine();

				if (pInput.equalsIgnoreCase("y")) {
					memList.get(i).setPwd(pwd);
					System.out.println("비밀번호 수정이 완료되었습니다.");
				}else {
					System.out.println("비밀번호 수정 등록이 취소되었습니다. 이전 메뉴로 돌아갑니다.");
					return;
				}
				
				// 2번 선택 시
			}else if (menu == 2) {
					System.out.println("기존 정보 : " + memList.toString());
					System.out.println("변경 할 이름 :");
					String name = sc.nextLine();

					System.out.println("이름을 수정하시겠습니까? (y/n) ");
					String nInput = sc.nextLine();

					if (nInput.equalsIgnoreCase("y")) {
						memList.get(i).setPwd(name);
						System.out.println("이름 수정이 완료되었습니다.");		
					} else {
						System.out.println("이름 수정이 취소되었습니다. ");
						return;
					}
					// 3번 선택 시
				}else if (menu == 3) {
						System.out.println("기존 정보 : " + memList.toString());
						System.out.println("변경 할 나이 :");
						String age = sc.nextLine();

						System.out.println("나이를 수정하시겠습니까? (y/n) ");
						String agInput = sc.nextLine();

						if (agInput.equalsIgnoreCase("y")) {
							memList.get(i).getAge();
							System.out.println("나이 수정이 완료되었습니다.");		
						} else {
							System.out.println("나이 수정이 취소되었습니다. ");
							return;
						}
						//4번 선택 시
					}else if (menu == 4) {
							System.out.println("기존 정보 : " + memList.toString());
							System.out.println("변경 할 성별 :");
							String gender = sc.nextLine();

							System.out.println("성별을 수정하시겠습니까? (y/n) ");
							String gInput = sc.nextLine();

							if (gInput.equalsIgnoreCase("y")) {
								memList.get(i).getGender();
								System.out.println("성별 수정이 완료되었습니다.");
							}else {
								System.out.println("제목 수정 등록이 취소되었습니다. 이전 메뉴로 돌아갑니다.");
								return;
							}
							//5번 선택 시
						}else if (menu == 5) {
						System.out.println("기존 정보 : " + memList.toString());
						System.out.println("변경 할 주소 :");
						String address = sc.nextLine();

						System.out.println("주소를 수정하시겠습니까? (y/n) ");
						String aInput = sc.nextLine();

						if (aInput.equalsIgnoreCase("y")) {
							memList.get(i).setAddress(address);
							System.out.println("주소 수정이 완료되었습니다.");		
						} else {
							System.out.println("주소 수정이 취소되었습니다. ");
							return;
						}
						//6번 선택 시
						} else if (menu == 6) {
							System.out.println("기존 정보 : " + memList.toString());
							System.out.println("변경 할 휴대폰 번호 :");
							String PhoneNum = sc.nextLine();

							System.out.println("휴대폰 번호를 수정하시겠습니까? (y/n) ");
							String phInput = sc.nextLine();

							if (phInput.equalsIgnoreCase("y")) {
								memList.get(i).setPhoneNum(phInput);
								System.out.println("휴대폰 번호 수정이 완료되었습니다.");		
							} else {
								System.out.println("휴대폰 번호 수정이 취소되었습니다. ");
								return;
							}
						}
					}
				}
			
				
/*
	// 나의 회원 정보 출력
	public Member memberPrint(String id) {
		Member member = null;
		
		for(Member m : memList) {
			if(m.getId() == id) {
				member = m;
				break;
			}
		}
		return member;
	}

*/
	/*
	// 회원탈퇴
	public void memberWithdraw(int withdraw) {

		for (int i = 0; i < memList.size(); i++) {
			if (memList.get(i).getId().equals(memList)) {

				System.out.println("정말 탈퇴하시겠습니까? ");
				String wInput = sc.nextLine();
				if (wInput.equalsIgnoreCase("y")) {
					memList.remove(object o); // 얘가 왜 안될까요 ㅠㅠ
				}
				System.out.println("탈퇴가 완료되었습니다.");
				return;

			}
		}

	}*/
}
