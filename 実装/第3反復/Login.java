package minipro3;

import DAO.MemberDAO;

public class Login {

	private MemberDAO memberdao;
	private Member user;

	public Login(MemberDAO memberdao) {
		this.memberdao = memberdao;
	}

	public Member getUser() {
		return user;
	}

	public boolean judge(String id, String pw) {
		Member temp = memberdao.getMember(id);
		boolean flag = false;
		try {
			if (pw.equals(temp.getPw())) {
				user = temp;
				return true;
			}
		} catch (NullPointerException e) {
			// TODO 自動生成された catch ブロック
			System.out.println("ユーザーが存在しません");
		}
		return flag;
	}

}
