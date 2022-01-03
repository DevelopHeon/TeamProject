package com.kh.miniproject.controller;

import com.kh.miniproject.model.vo.Member;

public class MemberController {

	public static final int SIZE = 100;
	private int memberCount;
	private Member[] mem = new Member[SIZE];

	Member m = new Member();

	{
		mem[0] = new Member("skyblue1", "bcbc", "홍길동", 10, 'M', "서울시 마포구", "010-1234-4567", 0);
		mem[1] = new Member("skyblue2", "cdcd", "도라지", 11, 'M', "서울시 용산구", "010-5656-5656", 0);
		mem[2] = new Member("skyblue3", "efef", "미역국", 12, 'M', "서울시 강남구", "010-8989-8989", 0);
		memberCount = 3;

	}

	public int login(String id, String pwd) {
		int num = 0;
		for (int i = 0; i < memberCount; i++) {
			if (mem[i].getId().equals(id) && mem[i].getPwd().equals(pwd)) {
				System.out.println(mem[i].information() + "1번");
				num = 1;
			}
		}
		return num;
	}

	public int getMemberCount() {

		return memberCount;
	}

	public Member[] getMem() {
		return mem;
	}

	public Member checkId(String id) {

		// 전달받은 회원의 아이디와 일치하는 회원 객체를 보관할 변수
		Member m = null;
		// 현재 회원 수 만큼 반복
		for (int i = 0; i < memberCount; i++) { // 일치하는 회원을 찾았을 경우
			if (mem[i].getId().equals(id)) {
				m = mem[i];
			}

		}
		return m;
	}

	public void memberInfoEdit(Member mem, int menu, String edit) {
		// 메뉴 1 -> 비밀번호 수정
		if (menu == 1) {
			mem.setPwd(edit);

			// 메뉴 2 -> 이름 수정
		} else if (menu == 2) {
			mem.setName(edit);

			// 메뉴 3 -> 주소 수정
		} else if (menu == 3) {
			mem.setAddress(edit);

			// 메뉴 4 -> 휴대폰번호 수정
		} else {
			mem.setPhoneNum(edit);

		}

	}

	public void memberWithdraw(String id) {
		// 현재 회원수만큼 반복
		for (int i = 0; i < memberCount; i++) {

			// 해당 순차적으로 접근한 객체의 아이디와 전달된 삭제할 회원의 아이디와 비교
			if (mem[i].getId().equals(id)) {// 일치하는 회원 찾았을 경우

				// 만약 해당 회원이 마지막 회원이였을 경우
				if (i == memberCount - 1) {
					mem[i] = null; // 해당 회원 삭제만하면 됨 (null로 대입)

				} else { // 만약 해당 회원이 마지막 회원이 아닌 중간에 있었던 회원이였을 경우 => 뒤에 있는 회원들을 한칸씩 앞으로 땡겨야 된다.

					// 뒤에 있었던 회원들을 한칸씩 앞으로 땡기는 작업
					for (int j = i; j < memberCount - 1; j++) {
						mem[j] = mem[j + 1];
					}
					mem[memberCount - 1] = null; // 그리고 마지막이였던 회원은 null로
				}

				memberCount--; // 삭제했으니깐 memberCount 1감소

				break; // 삭제 한 후 이 반복문 빠져나가야됨
			}
		}

	}

	public void insertMember(Member m) {
		mem[memberCount++] = m;
	}

	public void allMember() {
		System.out.println("전체 회원 목록");

		}
		
	}


