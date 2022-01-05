package com.kh.miniproject.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import com.kh.miniproject.model.dao.LoginDao;
import com.kh.miniproject.model.vo.Member;

public class MemberController {

	private LoginDao ld = new LoginDao();
	Scanner sc = new Scanner(System.in);
	ArrayList<Member> memList = new ArrayList<>();

	// 기본생성자
	public MemberController() {
	}

	// 회원등록
	public void join() {
		
		while (true) {
			System.out.println("Id : ");
			String id = sc.nextLine();

			//exit 입력시 이전화면으로 돌아감
			if (id.equals("exit")) {
				return;
			} else {
				
				// checkId를 통해 중복된 아이디가 있는지 확인한다. 반환 값 int
				int num = ld.checkId(id);

				//1이 아닌 다른 값을 반환한 경우 중복된 아이디 없는경우, 회원가입 진행
				if (num != 1) {

					System.out.println("Pwd :");
					String pwd = sc.nextLine();

					System.out.println("이름: ");
					String name = sc.nextLine();

					ld.writeMember(new Member(id, pwd, name));
					memberAllList(); // 출력시 회원가입한 정보 출력 나옴, 근데 다른데서는 안나옴 이유가?
					ld.LoginDaoOpen();
					return;
				} else { // 반환한 숫자가 1인경우 중복된 아이디 존재 재입력
					System.out.println("중복된 아이디가 존재합니다. 재 입력 (이전 화면으로 돌아가기 exit 입력)");
				}
			}
		}
	}

	// 회원정보수정
	public void memberInfoEdit() {
		System.out.println("아이디를 입력하세요.");
		String id = sc.nextLine();

		System.out.print("새로운 비밀번호를 입력하세요.");
		String newPwd = sc.nextLine();

		ld.memberInfoEdit(id, newPwd);

	}

	// 회원정보출력
	public void memberPrint() {

		System.out.println("회원의 아이디를 입력해주세요");
		String id = sc.nextLine();
		try {
			ArrayList<Member> memList = ld.memberSearch(id);

			for (int i = 0; i < memList.size(); i++) {
				if (memList.get(i).getId().equals(id)) {
					System.out.println(memList.get(i));
				}
			}
		} catch (NullPointerException e) {
			System.out.println("조회된 아이디가 없습니다.");
		}
	}

	// 회원탈퇴
	public void memberWithdraw() {
		System.out.println("탈퇴할 아이디를 입력하세요");
		String id = sc.nextLine();

		ld.memberWithdraw(id);
		System.out.println("회원탈퇴가 완료 되었습니다. 프로그램을 종료합니다.");
		System.exit(0);

	}

	// 전체 회원 조회
	public void memberAllList() {
		Iterator it = ld.memberAll().iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
