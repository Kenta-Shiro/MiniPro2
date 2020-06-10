package minipro2;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class MemberTest {

	Member member;
	
	@Before
	public void setUp() {
		member = new Member("山田太郎","abc","2020");
	}
	
	@Test
	public void test1() {
		String actual = member.getId();
		String expected = "abc";
		
		assertThat(actual, is(expected));
	}
	
	@Test
	public void test2() {
		String actual = member.getName();
		String expected = "山田太郎";
		
		assertThat(actual, is(expected));
	}
	
	@Test
	public void test3() {
		String actual = member.getPw();
		String expected = "2020";
		
		assertThat(actual, is(expected));
	}
}
