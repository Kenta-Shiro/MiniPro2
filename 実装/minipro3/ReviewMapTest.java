package minipro2;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ReviewMapTest {
	Member member;
	// HashMap<Integer, ReviewList> reviewmap;
	ReviewList reviewlist1, reviewlist2;
	ReviewMap reviewMap;
	Title title1, title2;

	@Before
	public void setUp() {
		member = new Member("山口一郎", "sakana", "1234");
		reviewMap = new ReviewMap();
		title1 = new Title("ワンピース");
		title2 = new Title("キングダム");
		reviewlist1 = new ReviewList(title1.getTitle(), title1.getTitleNo());
		reviewlist2 = new ReviewList(title2.getTitle(), title2.getTitleNo());
		reviewMap.setTitle(title1.getTitleNo(), reviewlist1);
		reviewMap.setTitle(title2.getTitleNo(), reviewlist2);
		reviewlist1.makeReview("ワンピース", "おもしろい！", member);
	}

	@Test
	public void レビューリストを取得する() {
		Review expected = reviewlist1.getReviewList().get(0);

		List<Review> actual = reviewMap.getReviewList(1);

		assertThat(actual, hasItem(expected));
	}

	@Test
	public void レビューリストを作成() {
		reviewMap.makeReviewList(title2.getTitle(), title2.getTitleNo());

		List<Review> expected = reviewMap.getReviewList(2);
		assertThat(expected, is(instanceOf(ArrayList.class)));
	}

	@Test
	public void レビューを作成() {
		// reviewMap.makeReviewList(title2.getTitle(), title2.getTitleNo());
		reviewMap.makeReview("最高！", member, 2);

		Review expected = reviewMap.getReviewList(2).get(0);

		List<Review> actual = reviewMap.getReviewList(2);

		assertThat(actual, hasItem(expected));
	}

	@Test
	public void 自分の口コミを取得() {
		// reviewMap.makeReviewList(title2.getTitle(), title2.getTitleNo());
		List<Review> actual = reviewMap.getReviews(member.getId());

		Review expected = reviewlist1.getReviewList().get(0);

		assertThat(actual, hasItem(expected));
	}

	@Test
	public void 口コミを削除() {
		reviewMap.deleteReview(1);

		int actual = 0;
		int expected = reviewlist1.getReviewList().size();

		assertThat(actual, is(expected));
	}
}
