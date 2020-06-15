package minipro3;

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

	public String getTitle() {
		return title;
	}

	public int getTitleNo() {
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
