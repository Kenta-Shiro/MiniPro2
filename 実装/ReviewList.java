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
		Review r1 = new Review("面白い",new Member("山田太郎","abc","2020"));
		reviews.add(r1);
	}
	
	public String getTitle() {//新規追加
		return title;
	}
	
	public int getTitleNo() {//新規追加
		return titleNo;
	}
	
	public Review getReview(int reviewNo) {
		return reviews.get(reviewNo - 1);
	}

	public List<Review> getReviewList() {
		return reviews;
	}

	public void makeReview(String content, Member member) {
		Review r = new Review(content,member);
		reviews.add(r);
	}
	
	public void deleteReview(Review review) {
		reviews.remove(review);
	}

}
