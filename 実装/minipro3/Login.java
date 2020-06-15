package minipro3;

import DAO.MemberDAO;

public class Login {

	private MemberDAO memberDAO;
	private Member user;

	public Login(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}

	public Member getUser() {
		return user;
	}

	public boolean judge(String id, String pw) {
		Member temp = memberDAO.getMember(id);

		if (pw.equals(temp.getPw())) {
			user = temp;
			return true;
		}
		return false;
	}

}
