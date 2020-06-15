package minipro3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class ReviewMap {

	private HashMap<Integer, ReviewList> reviewmap = new HashMap<Integer, ReviewList>();

	public ReviewMap() {
		this.makeReviewList("ワンピース", 1);
	}

	public List<Review> getReviewList(int titleNo) {
		return reviewmap.get(titleNo).getReviewList();
	}

	public void makeReviewList(String title, int titleNo) {
		ReviewList newlist = new ReviewList(title, titleNo);
		reviewmap.put(newlist.getTitleNo(), newlist);
	}

	public void makeReview(String content, Member member, int titleNo) {
		ReviewList targetlist = reviewmap.get(titleNo);
		targetlist.makeReview(targetlist.getTitle(), content, member);
	}

	public List<Review> getReviews(String id) {
		List<Review> userReviews = new ArrayList<Review>();
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

	public void deleteReview(int reviewNo) {
		for (Entry<Integer, ReviewList> entry : reviewmap.entrySet()) {
			ReviewList list = entry.getValue();//
			for (int i = 0; i < list.getReviewList().size(); i++) {
				list.deleteReview(reviewNo);
			}
		}
	}

	public HashMap<Integer, ReviewList> getReviewMap() {
		return reviewmap;
	}

}
