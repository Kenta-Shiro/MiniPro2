package minipro2;

public class PostCon {

	private TitleList titleList;

	private ReviewMap reviewMap;

	public PostCon(TitleList titleList, ReviewList reviewList) {
        this.titleList = titleList;
        this.reviewMap = reviewMap;
	}
	
	public void Post(String content, Member member) {

	}

	public List<Title> browse() {
		return titleList.getTitleList();
	}

	public List<Review> viewReviewList(int titleNo) {
		return reviewMap.getReviewList(int titleNo);
	}

	public void post(String content, Member member, int titleNo) {
        return reviewMap.makeReview(String content, Member member, int titleNo);
	}

}
