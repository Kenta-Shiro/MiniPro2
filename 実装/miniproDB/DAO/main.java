package DAO;

import java.io.IOException;
import java.util.Scanner;

import minipro3.Login;
import minipro3.Member;

public class main {
	public static void main(String[] args) throws IOException {
		MemberDAO m_dao = new MemberDAO();
		Login login = new Login(m_dao);

		Member member;

		boolean isEnd = false;
		String id, pw;
		Scanner scanner = new Scanner(System.in);
		while (isEnd != true) {
			System.out.println("IDを入力してください");
			id = scanner.nextLine();
			System.out.println("パスワードを入力してください");
			pw = scanner.nextLine();
			isEnd = login.judge(id, pw);
		}

		scanner.close();
		member = login.getUser();
		System.out.println(member.getName());
		System.out.println(member.getId());
	}
}
