package minipro;

import java.util.List;

import DAO.ReviewDAO;
import DAO.TitleDAO;

public class PostCon {

	private TitleDAO titleDAO;
	private ReviewDAO reviewDAO;

	public PostCon(TitleDAO titleDAO, ReviewDAO reviewDAO) {
		this.titleDAO = titleDAO;
		this.reviewDAO = reviewDAO;
	}

	public List<Title> browse() {
		return titleDAO.getTitleList();
	}

	public List<Review> viewReviewList(int titleNo) {
		return reviewDAO.getReviews(titleNo);
	}

	public void post(String content, Member member, int titleNo) {
		String id = member.getId();
		reviewDAO.setReview(id, titleNo, content);
	}

}
