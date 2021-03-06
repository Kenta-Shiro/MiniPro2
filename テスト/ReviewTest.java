package minipro2;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class ReviewTest {
	Member member;
	Review review;

	@Before
	public void setUp() {
		member = new Member("yamada", "abc", "2020");
		review = new Review("面白い", member);
	}

	@Test
	public void Test_reviewNo() {
		int expected_reviewNo = 1;
		int actual = review.getReviewId();

		assertThat(actual, is(expected_reviewNo));
	}

	@Test
	public void Test_content() {
		String expected_reviewContent = "面白い";
		String actual = review.getContent();

		assertThat(actual, is(expected_reviewContent));
	}

	@Test
	public void Test_reviewDate() {
		String expected_reviewDate = "2020/06/10";
		String actual = review.getreviewsDate();

		assertThat(actual, is(expected_reviewDate));
	}

	@Test
	public void Test_reviewMember() {
		Member expected_reviewMember = member;
		Member actual = review.getUser();

		assertThat(actual, is(expected_reviewMember));
	}

}
