package minipro2;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Review {
	//いらない変数
	//private int reviewId;

	private String reviewDate;

	private String content;

	private int reviewNo;
	
	private static int reviewID = 1;

	private Member member;

	public Review(String content, Member member) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		reviewDate = sdf.format(date);
		reviewNo = reviewID;
		reviewID++;
		this.content = content;
		this.member = member;
	}

	public int getReviewId() {//名前ややこしい
		return reviewNo;
	}

	public String getreviewsDate() {
		return reviewDate;
	}

	public String getContent() {
		return content;
	}

	public Member getUser() {
		return member;
	}

}
