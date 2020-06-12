package minipro3;

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
		System.out.println("漫画口コミ投稿システム");
		System.out.println("1:ログインする");
		System.out.println("2:ログインしない");
		System.out.println("希望の番号を入力してください");
		String menuNo = this.stream();
		switch(menuNo) {
		case "1":
			this.inputLogin();
			break;
		case "2":
			this.showGuestMenu();
			break;
		default:
			this.start();
		}
	}
	
	private void showGuestMenu() {
		System.out.println("ゲストメニュー");
		System.out.println("1:口コミの閲覧");
		System.out.println("2:会員登録");
		System.out.println("希望の番号を入力してください");
		String menuNo = this.stream();
		switch(menuNo) {
		case "1":
			this.displayReviewList();
			break;
		case "2":
			//entry.inputEntry();
			break;
		default:
			break;
		}
	}
	
	private void inputLogin() {//private
		boolean isEnd = false;
		String id;
		String pw;
		while (isEnd != true) {
			System.out.println("ログイン");
			System.out.println("IDを入力してください");
			id = this.stream();
			System.out.println("パスワードを入力してください");
			pw = this.stream();
			isEnd = login.judge(id, pw);
		}
		this.member = login.getUser();
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
			break;
		case "5":
			// 投稿した口コミの削除
			this.deleteReview();
			break;
		case "6":
			// 終了
			break;
		default:
			// それ以外の入力はメニューの再表示
			this.showMenu();
		}
	}
	
	private void inputTitle() {
		System.out.println("タイトルを入力してください");
		String title = this.stream();
		titleCon.addTitle(title);
		System.out.println("");
		this.showMenu();
	}

	private void displayReviewList() {
		this.displayTitleList();
		System.out.println("口コミを閲覧したいタイトルを選択してください");
		try {
			titleNo = Integer.parseInt(this.stream());
		} catch (NumberFormatException e) {
			System.out.println("数字を入力してください");
			this.displayReviewList();
		}
		List<Review> reviews = postCon.viewReviewList(titleNo);
		if (reviews.size() == 0) {
			System.out.println("まだ口コミがありません");
		} else {
			for (Review review : reviews) {
				System.out.println(review.getUser().getName());
				System.out.println(review.getreviewsDate());
				System.out.println(review.getContent());
				System.out.println("-------------------");
			}
		}
		System.out.println("");
		System.out.println("1:タイトル一覧に戻る");
		if(member != null) {
			System.out.println("2:口コミを投稿する");
		}
		System.out.println("上記以外:メニューに戻る");
		System.out.println("希望の番号を入力してください");
		String menuNo = this.stream();
		switch (menuNo) {
		case "1":
			this.displayReviewList();
			break;
		case "2":
			if(member != null) {
				this.inputReview();
			}else {
				this.showGuestMenu();
			}
			break;
		default:
			if(member != null) {
				this.showMenu();
			}else {
				this.showGuestMenu();
			}
		}
	}
	
	private void inputReview() {
		System.out.println("");
		System.out.println("口コミを入力してください");
		String content = this.stream();
		postCon.post(content, member, titleNo);
		System.out.println("口コミが投稿されました");
		System.out.println("");
		this.displayReviewList();
	}
	
	private void displayTitleList() {
		System.out.println("タイトル一覧");
		List<Title> titles = postCon.browse();
		for (Title title : titles) {
			System.out.print(title.getTitleNo() + ":");
			System.out.println(title.getTitle());
		}
	}
	
	private void displayMyReviewList(String id) {
		List<Review> reviews = new ArrayList<Review>();
		reviews = myReviewCon.getMyReveiwList(id);
		for (Review r : reviews) {
			System.out.print(r.getReviewNo() + ":");
			System.out.println(r.getTitle());
			System.out.println(r.getreviewsDate());
			System.out.println(r.getContent());
			System.out.println("-------------------");
		}
		System.out.println("");
		System.out.println("1:メニューを表示");
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

	private void deleteReview() {
		System.out.println("削除したいレビューの番号を入力してください");
		System.out.println("削除をやめてメニューに戻る場合はその他の番号を入力してください");
		try {
			int reviewNo = Integer.parseInt(this.stream());
			myReviewCon.deleteMyReview(reviewNo);
			System.out.println("削除しました");
			this.displayMyReviewList(member.getId());
		}catch(IndexOutOfBoundsException e) {
			this.showMenu();
		}
		
	}

}
