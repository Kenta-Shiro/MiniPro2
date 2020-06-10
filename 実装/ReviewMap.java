package minipro2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class ReviewMap {

	private HashMap<Integer, ReviewList> reviewmap;

	/*
	 * public void setTitle(int titleNo, ReviewList reviewlist) {
	 * reviewmap.put(titleNo, reviewlist);
	 * 
	 * }
	 */

	// タイトルのレビュー一覧を呼び出す（PostCon）
	public List<Review> getReviewList(int titleNo) {
		return reviewmap.get(titleNo).getReviewList();
	}

	// 作成したタイトルを基にReviewListを作成（TitleList）
	public void makeReviewList(String title, int titleNo) {
		ReviewList newlist = new ReviewList(title, titleNo);
		reviewmap.put(newlist.getTitleNo(), newlist);
	}

	// レビューを作成するメソッドをReviewListから呼び出す（TitleList）
	public void makeReview(String content, Member member, int titleNo) {
		ReviewList targetlist = reviewmap.get(titleNo);
		targetlist.makeReview(content, member);
	}

	// ユーザの口コミを取得する（MyReviewCon）
	public List<Review> getReviews(String id) {
		List<Review> userReviews = new ArrayList<Review>();// ユーザIDのレビューを一時的に保持しておくＬｉｓｔ
		for (Entry<Integer, ReviewList> entry : reviewmap.entrySet()) {
			ReviewList list = entry.getValue();//
			for (int i = 0; i < list.getReviewList().size(); i++) {
				Review r = list.getReviewList().get(i);
				if (r.getUser().getId() == id) {
					userReviews.add(r);
				}
			}
		}
		return userReviews;
	}

	// 口コミを削除する（MyReviewCon）
	public void deleteReview(int reviewNo) {
		for (Entry<Integer, ReviewList> entry : reviewmap.entrySet()) {
			ReviewList list = entry.getValue();//
			for (int i = 0; i < list.getReviewList().size(); i++) {
				Review r = list.getReviewList().get(i);
				if (r.getReviewNo() == reviewNo) {
					list.deleteReview(r);
				}
			}
		}
	}

}
