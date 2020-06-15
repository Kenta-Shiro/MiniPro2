package minipro3;

import java.util.List;

public class MyReviewCon {

	private ReviewMap reviewMap;

	public MyReviewCon(ReviewMap reviewMap) {
		this.reviewMap = reviewMap;
	}

	public List<Review> getMyReveiwList(String id) {
		return reviewMap.getReviews(id);
	}

	public void deleteMyReview(int reviewNo) {
		reviewMap.deleteReview(reviewNo);
	}
}
