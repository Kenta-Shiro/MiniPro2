package minipro;

import DAO.MemberDAO;
import DAO.ReviewDAO;
import DAO.TitleDAO;

public class Main {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		MemberDAO memberDAO = new MemberDAO();
		ReviewDAO reviewDAO = new ReviewDAO();
		TitleDAO titleDAO = new TitleDAO();
		Login login = new Login(memberDAO);
		Entry entry = new Entry(memberDAO);
		TitleCon titleCon = new TitleCon(titleDAO);
		PostCon postCon = new PostCon(titleDAO, reviewDAO);
		MyReviewCon myReviewCon = new MyReviewCon(reviewDAO);
		UI ui = new UI(login, titleCon, postCon, myReviewCon, entry);

		ui.start();

	}

}
