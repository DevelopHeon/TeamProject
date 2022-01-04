package com.kh.miniproject.controller;

import java.util.ArrayList;
import java.util.Scanner;

import com.kh.miniproject.model.dao.LoginDao;
import com.kh.miniproject.model.vo.Member;

public class MemberController {

	private LoginDao ld = new LoginDao();
	Scanner sc = new Scanner (System.in);

	//기본생성자
	public MemberController() {	}

	//회원등록
	public void join() {
		System.out.println("Id : ");
		String id = sc.nextLine();

		System.out.println("Pwd :");
		String pwd = sc.nextLine();

		System.out.println("이름: ");
		String name = sc.nextLine();

		ld.writeMember(new Member(id, pwd, name));
	}


	//회원정보수정
	public void memberInfoEdit() {
		System.out.println("아이디를 입력하세요.");
		String id = sc.nextLine();
		
		System.out.print("새로운 비밀번호를 입력하세요.");
		String newPwd = sc.nextLine();

		ld.memberInfoEdit(id, newPwd);
		
	}


	//회원정보출력
	public void memberPrint() {

		System.out.println("회원의 아이디를 입력해주세요");
		String id = sc.nextLine();
		try {
			ArrayList<Member> memList = ld.memberSearch(id);

			for(int i = 0; i < memList.size(); i++) {
				if(memList.get(i).getId().equals(id)) {
					System.out.println(memList.get(i));
				}
			}
		}catch(NullPointerException e) {
			System.out.println("조회된 아이디가 없습니다.");
		}
	}


	//회원탈퇴
	public void memberWithdraw() {
		System.out.println("탈퇴할 아이디를 입력하세요");
		String id = sc.nextLine();
		
		ld.memberWithdraw(id);
		
	}

}
