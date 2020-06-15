package minipro3;

import java.util.List;

import DAO.MemberDAO;

public class Entry {

	private MemberDAO memberDAO;

	public Entry(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}

	public void entryMember(String name, String id, String pw) {
		List<Member> members = memberDAO.getMemberList();

		if (this.isRegistered(id, members)) {
			System.out.println("既に存在しているIDです。");
		} else {
			memberDAO.setMember(name, id, pw);
		}

	}

	boolean isRegistered(String id, List<Member> members) {
		boolean check = false;
		for (Member temp : members) {
			if (temp.getId().equals(id)) {
				check = true;
			}
		}
		return check;
	}

}
