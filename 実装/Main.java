package minipro2;

public class Main {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		MemberList memberList = new MemberList();
		ReviewMap reviewMap = new ReviewMap();
		TitleList titleList = new TitleList(reviewMap);
		Login login = new Login(memberList);
		TitleCon titleCon = new TitleCon(titleList);
		PostCon postCon = new PostCon(titleList,reviewMap);
		MyReviewCon myReviewCon = new MyReviewCon(reviewMap);
		UI ui = new UI(login,titleCon,postCon,myReviewCon);
		
		ui.start();
	
	}

}
