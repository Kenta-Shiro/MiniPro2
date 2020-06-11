package minipro2;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertThat;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;

public class PostConTest {

	ReviewMap rm;
	TitleList tl;
	PostCon pc;
	Member m;
	
	@Before
	public void setUp() {
		rm = new ReviewMap();
		tl = new TitleList(rm);
		pc = new PostCon(tl, rm);
		m = new Member("鈴木太郎","abcd","2021");
	}
	
	@Test
	public void test1() {
		List<Title> actual = pc.browse();
		List<Title> expected = tl.getTitleList();
		
		assertThat(actual, is(expected));
	}
	
	@Test
	public void test2() {
		List<Review> actual = pc.viewReviewList(1);
		List<Review> expected = rm.getReviewList(1);
		
		assertThat(actual, is(expected));
	}
	
	@Test
	public void test3() {
		pc.post("口コミです。", m, 1);
		
		Review actual = pc.viewReviewList(1).get(0);
		Review expected = rm.getReviewList(1).get(0);
		
		assertThat(actual, is(expected));
	}
}
