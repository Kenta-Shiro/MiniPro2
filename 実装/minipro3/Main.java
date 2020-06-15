package minipro3;

import DAO.MemberDAO;

public class Main {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		MemberDAO memberDAO = new MemberDAO();
		ReviewMap reviewMap = new ReviewMap();
		TitleList titleList = new TitleList(reviewMap);
		Login login = new Login(memberDAO);
		Entry entry = new Entry(memberDAO);
		TitleCon titleCon = new TitleCon(titleList);
		PostCon postCon = new PostCon(titleList, reviewMap);
		MyReviewCon myReviewCon = new MyReviewCon(reviewMap);
		UI ui = new UI(login, titleCon, postCon, myReviewCon, entry);

		ui.start();

	}

}
