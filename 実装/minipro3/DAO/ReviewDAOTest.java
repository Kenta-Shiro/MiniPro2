package DAO;

import java.util.List;

import minipro3.Member;
import minipro3.Review;
import minipro3.Title;

public class ReviewDAOTest {
	public static void main(String[] args) {
		ReviewDAO rdao = new ReviewDAO();
		TitleDAO tdao = new TitleDAO();
		MemberDAO mdao = new MemberDAO();

		Member member = mdao.getMember("abc");

		List<Title> tlist = tdao.getTitleList();
		for (Title t : tlist) {
			System.out.print(t.getTitleNo() + ":");
			System.out.println(t.getTitle());
			List<Review> rlist = rdao.getReviews(t.getTitleNo());
			for (Review r : rlist) {
				System.out.print(r.getUser().getName() + ":");
				System.out.println(r.getreviewsDate());
				System.out.println(r.getContent());
				System.out.println("----------------------------------");
			}
		}

		List<Review> mylist = rdao.getMyReviews(member);
		System.out.println("");
		System.out.println("");
		System.out.println(member.getName() + "の投稿レビュー一覧");
		for (Review r : mylist) {
			System.out.print(r.getReviewNo() + ":");
			System.out.print(r.getTitle() + ":");
			System.out.println(r.getreviewsDate());
			System.out.println(r.getContent());
			System.out.println("----------------------------------");
		}

		System.out.println("");
		System.out.println("");
		rdao.setReview(member.getId(), 2, "はいエドテン");
		System.out.println("");
		System.out.println("");

		List<Review> rlist = rdao.getReviews(2);
		for (Review r : rlist) {
			System.out.print(r.getUser().getName() + ":");
			System.out.println(r.getreviewsDate());
			System.out.println(r.getContent());
			System.out.println("----------------------------------");
		}
	}
}
