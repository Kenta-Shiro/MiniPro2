package minipro2;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.sameInstance;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;

public class ReviewListTest {

	ReviewList reviewList;
	Member m;
	
	@Before
	public void setUp() {
		reviewList = new ReviewList("ワンピース",1);
		m = new Member("鈴木太郎","abcd","2021");
	}
	
	@Test
	public void test1() {
		ReviewList exList = new ReviewList("ワンピース",1);
		
		List<Review> actual = reviewList.getReviewList();
		List<Review> expected = exList.getReviewList();
		
		assertThat(actual, is(expected));
	} 
	
	@Test
	public void test2() {
		Review expected = new Review("面白い", m);
		
		reviewList.makeReview("面白い", m);
		List<Review> actual = reviewList.getReviewList();
		
		assertThat(actual, hasItem(expected));
	} 
	
	@Test
	public void test3() {
		Review r = new Review("面白い", m);
		
		reviewList.deleteReview(r);
		List<Review> actual = reviewList.getReviewList();
		
		Review expected = r;
		
		assertThat(actual, hasItem(expected));
	} 
}
