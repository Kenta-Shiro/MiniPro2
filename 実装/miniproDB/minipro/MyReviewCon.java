package minipro;

import java.util.List;

import DAO.ReviewDAO;

public class MyReviewCon {

	private ReviewDAO reviewDAO;

	public MyReviewCon(ReviewDAO reviewDAO) {
		this.reviewDAO = reviewDAO;
	}

	public List<Review> getMyReveiwList(Member member) {
		return reviewDAO.getMyReviews(member);
	}

	public void deleteMyReview(int reviewNo) {
		reviewDAO.deleteReview(reviewNo);
	}
}
