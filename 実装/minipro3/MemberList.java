package minipro2;

import java.util.ArrayList;
import java.util.List;

public class MemberList {

	private List<Member> members = new ArrayList<Member>();

	public MemberList() {
		Member member1 = new Member("山田太郎", "abc", "2020");
		Member member2 = new Member("鈴木一郎", "def", "2023");
		members.add(member1);
		members.add(member2);
	}

	public Member getMember(String id) {
		Member empty = new Member("", "", "");
		for (Member temp : members) {
			if (id.equals(temp.getId())) {
				return temp;
			}
		}
		return empty;
	}

}