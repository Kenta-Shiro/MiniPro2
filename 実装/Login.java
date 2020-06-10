package minipro2;


public class Login {

	private MemberList memberList;
	private Member user;

	public Login(MemberList memberList) {
		this.memberList = memberList;
	}

	public Member getUser() {
		return user;
	}

	public boolean judge(String id, String pw) {
		Member temp = memberList.getMember(id);
		
		if(pw.equals(temp.getPw())) {
			user = temp;
			return true;
		}
		return false;
	}

}
