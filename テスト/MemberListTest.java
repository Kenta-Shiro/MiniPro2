package minipro2;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class MemberListTest {

	MemberList memberList;
	
	@Before
	public void setUp() {
		memberList = new MemberList();
	}
	
	@Test
	public void test1() {
		String actual = memberList.getMember("abc").getId();
		String expected = "abc";
		
		assertThat(actual,is(expected));
	}
}
