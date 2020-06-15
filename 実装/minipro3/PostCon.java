package minipro3;

import java.util.List;

public class PostCon {

	private TitleList titleList;
	private ReviewMap reviewMap;

	public PostCon(TitleList titleList, ReviewMap reviewMap) {
		this.titleList = titleList;
		this.reviewMap = reviewMap;
	}

	public List<Title> browse() {
		return titleList.getTitleList();
	}

	public List<Review> viewReviewList(int titleNo) {
		return reviewMap.getReviewList(titleNo);
	}

	public void post(String content, Member member, int titleNo) {
		reviewMap.makeReview(content, member, titleNo);
	}

}
