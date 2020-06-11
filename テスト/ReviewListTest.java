//ReviewListTest
package minipro2;

import java.util.List;

public class Test {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		ReviewList r = new ReviewList("ワンピース",1);
		Member m = new Member("鈴木太郎","abcd","2021");
		r.makeReview("ワンピース","いい", m);
		
		System.out.println("getReviewListテスト");
		List<Review> l = r.getReviewList();
		
		for(Review temp:l) {
			System.out.println(temp.getReviewNo()+"."+temp.getContent());
		}
		
		System.out.println("makeReviewテスト");
		r.makeReview("ワンピース","嫌い", m);
		
		for(Review temp:l) {
			System.out.println(temp.getReviewNo()+"."+temp.getContent());
		}
		
		System.out.println("deleteReviewテスト");
		
		r.deleteReview(1);
		
		for(Review temp:l) {
			System.out.println(temp.getReviewNo()+"."+temp.getContent());
		}

	}

}
