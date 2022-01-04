package com.kh.miniproject.controller;

import java.util.ArrayList;
import java.util.Scanner;

import com.kh.miniproject.model.dao.LoginDao;

import com.kh.miniproject.model.dao.MemberDao;

import com.kh.miniproject.model.vo.Member;
import com.kh.miniproject.view.MemberPage;

public class MemberController {

	MemberDao md = new MemberDao();
	Scanner sc = new Scanner (System.in);
	MemberPage mp = new MemberPage();
	LoginDao ld = new LoginDao();
	public ArrayList <Member> memList = new ArrayList<Member>();
	
	//기본생성자
	public MemberController() {	}

	
	

	//로그인
	public void login() {

		System.out.println("id :");
		String id = sc.nextLine();

		System.out.println("pwd :");
		String pwd = sc.nextLine();

		int result = ld.login(id, pwd);
		
		if (result == 1) {
			mp.memberMainMenu();
		} else {
			System.out.println("로그인에 실패하였습니다.");
		}

	}
	//회원등록
	public void join() {
		System.out.println("Id : ");
		String id = sc.nextLine();
		
		System.out.println("Pwd :");
		String pwd = sc.nextLine();
		
		System.out.println("이름: ");
		String name = sc.nextLine();
		
		System.out.println("나이: ");
		int age = sc.nextInt();
		
		System.out.println("성별: ");
		char gender = sc.next().charAt(0);
		
		System.out.println("주소: ");
		String address = sc.nextLine();
		
		System.out.println("휴대폰 번호: ");
		String phoneNum = sc.nextLine();
		
		Member join = new Member(id, pwd, name, age, gender, address, phoneNum);
		
	}


	//회원정보수정
	public void memberInfoEdit() {
		System.out.println("회원정보를 수정하시겠습니까? (y/n) ");
		String info = sc.nextLine();
		
		md.memberInfoEdit(info);
	}


	//회원정보출력
	public void memberPrint() {
	System.out.println("회원의 아이디를 입력해주세요");
	String id = sc.nextLine();
	
	Member member = md.memberPrint(id);
	if(member == null) {
		System.out.println("조회된 아이디가 없습니다.");
		
	}else {
		System.out.println(id);
	}
	
		
	}


	//회원탈퇴
	/*public void memberWithdraw() {
		System.out.println("탈퇴할 아이디를 입력하세요");
		String id = sc.nextLine();
		
		
		md.memberWithdraw(withdraw);
		
	}*/



	

}
