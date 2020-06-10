package minipro2;

public class MyReviewCon {

	private ReviewMap reviewMap;;

	public MyReviewCon(ReviewMap reviewMap) {
        this.reviewMap = reviewMap;
	}
	
	public List<Review> getMyReveiwList(String id) {
		return ReviewMao.getReviews(String id);
	}

	public void deleteMyReview(int reviewNo) {
        reviewMap.deleteReview(int reviewNo);
	}
}
