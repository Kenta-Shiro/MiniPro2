package minipro2;

import java.util.ArrayList;
import java.util.List;

public class ReviewList {

	private String title;

	private int titleNo;

	private List<Review> reviews = new ArrayList<Review>();

	public ReviewList(String title, int titleNo) {
		this.title = title;
		this.titleNo = titleNo;
	}

	public String getTitle() {// 新規追加
		return title;
	}

	public int getTitleNo() {// 新規追加
		return titleNo;
	}

	public Review getReview(int reviewNo) {
		return reviews.get(reviewNo - 1);
	}

	public List<Review> getReviewList() {
		return reviews;
	}

	public void makeReview(String title, String content, Member member) {
		Review r = new Review(title, content, member);
		reviews.add(r);
	}

	public void deleteReview(int reviewNo) {
		reviews.remove(reviewNo - 1);
	}

}
