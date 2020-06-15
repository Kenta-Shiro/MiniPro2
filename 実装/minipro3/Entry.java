package minipro3;

import java.util.List;

import DAO.MemberDAO;

public class Entry {

	private MemberDAO memberDAO;

	public Entry(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}

	public void entryMember(String name, String id, String pw) {
		memberDAO.setMember(name, id, pw);
	}

	public boolean isRegistered(String id) {
		List<Member> members = memberDAO.getMemberList();
		boolean check = false;
		for (Member temp : members) {
			if (temp.getId().equals(id)) {
				System.out.println("既に存在するIDです");
				check = true;
			}
		}
		return check;
	}

}
