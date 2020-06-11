package minipro2;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Review {
	// いらない変数
	// private int reviewId;
	private String title;

	private String reviewDate;

	private String content;

	private int reviewNo;

	private static int reviewID = 1;

	private Member member;

	public Review(String title,String content, Member member) {
		LocalDateTime date1 = LocalDateTime.now();
		DateTimeFormatter dtformat1 = 
				DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		reviewDate = dtformat1.format(date1);
		reviewNo = reviewID;
		reviewID++;
		this.title = title;
		this.content = content;
		this.member = member;
	}

	public int getReviewNo() {// 名前ややこしい
		return reviewNo;
	}

	public String getreviewsDate() {
		return reviewDate;
	}

	public String getTitle() {
		return title;
	}
	
	public String getContent() {
		return content;
	}

	public Member getUser() {
		return member;
	}

}
