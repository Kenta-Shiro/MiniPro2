package minipro2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class UI {

	private int titleNo;

	private MyReviewCon myReviewCon;

	private TitleCon titleCon;

	private PostCon postCon;

	private Login login;

	private Member member;

	public UI(Login login, TitleCon titleCon, PostCon postCon, MyReviewCon myReviewCon) {
		this.login = login;
		this.titleCon = titleCon;
		this.postCon = postCon;
		this.myReviewCon = myReviewCon;
	}

	private String stream() {
		String line = "";
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			line = reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return line;
	}

	public void start() {
		// ログイン終了判定の変数
		boolean isEnd = false;
		String id;
		String pw;
		while (isEnd != true) {
			System.out.println("IDを入力してください");
			id = this.stream();
			System.out.println("パスワードを入力してください");
			pw = this.stream();
			isEnd = login.judge(id, pw);
		}
		this.member = login.getUser();
		// メニュー表示
		this.showMenu();
	}

	private void showMenu() {
		System.out.println("メニュー");
		System.out.println("1:タイトルの追加");
		System.out.println("2:口コミの閲覧");
		System.out.println("3:口コミの投稿");
		System.out.println("4:自分の口コミリストの閲覧");
		System.out.println("5:投稿した口コミの削除");
		System.out.println("6:終了");
		System.out.println("希望の番号を入力してください");
		String memuNum = this.stream();
		switch (memuNum) {
		case "1":
			// タイトルの追加
			this.inputTitle();
			break;
		case "2":
			// 口コミの閲覧
			this.displayReviewList();
			break;
		case "3":
			// 口コミの投稿
			this.displayReviewList();
			break;
		case "4":
			// 自分の口コミリストの閲覧
			this.displayMyReviewList(member.getId());
		case "5":
			// 投稿した口コミの削除
			this.deleteReview();
			break;
		case "6":
			// 終了
			// readerをclose()する
			break;
		default:
			// メニュー再表示
			this.showMenu();
		}
	}

	private void displayMyReviewList(String id) {
		List<Review> reviews = new ArrayList<Review>();
		reviews = myReviewCon.getMyReveiwList(id);
		for (Review r : reviews) {
			System.out.print(r.getReviewNo() + ":");
			System.out.println(r.getreviewsDate());
			System.out.println(r.getContent());
			System.out.println("");
		}
		System.out.println("");
		System.out.println("1:メニューを表示を選択");
		System.out.println("2:投稿した口コミの削除");
		System.out.println("希望の番号を入力してください");
		String n = this.stream();

		switch (n) {
		case "1":
			// メニューを表示
			this.showMenu();
			break;
		case "2":
			// 口コミの削除
			this.deleteReview();
			break;
		default:
			this.displayMyReviewList(id);
		}
	}

	private void inputTitle() {
		System.out.println("タイトルを入力してください");
		String title = this.stream();
		titleCon.addTitle(title);
		this.showMenu();
	}

	private void deleteReview() {
		int reviewNo = Integer.parseInt(this.stream());
		// int titleNo = Integer.parseInt(this.stream());
		myReviewCon.deleteMyReview(reviewNo);
		this.displayMyReviewList(member.getId());
	}

	private void displayReviewList() {
		this.displayTitleList();
		System.out.println("口コミを閲覧したいタイトルを選択してください");
		try {
			titleNo = Integer.parseInt(this.stream());
		} catch (NumberFormatException e) {
			// TODO 自動生成された catch ブロック
			System.out.println("数字を入力してください");
			this.displayReviewList();// バグるかもしれない
		}
		List<Review> reviews = postCon.viewReviewList(titleNo);
		for (Review review : reviews) {
			System.out.println(review.getUser().getName());
			System.out.println(review.getreviewsDate());
			System.out.println(review.getContent());
		}
		System.out.println("1:口コミを投稿する");
		System.out.println("2:タイトル一覧に戻る");
		System.out.println("1,2以外:メニューに戻る");
		String menuNo = this.stream();
		switch (menuNo) {
		case "1":
			this.inputReview();
			break;
		case "2":
			this.displayReviewList();// 設計書から変更
			break;
		default:
			this.showMenu();
		}
	}

	private void displayTitleList() {
		List<Title> titles = postCon.browse();
		for (Title title : titles) {
			System.out.print(title.getTitleNo() + ":");
			System.out.println(title.getTitle());
		}
	}

	private void inputReview() {
		System.out.println("");
		String content = this.stream();
		postCon.post(content, member, titleNo);
		System.out.println("口コミが投稿されました");
		System.out.println("");
		this.displayReviewList();
	}

}
