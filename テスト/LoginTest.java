package minipro3;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class LoginTest {

	MemberDAO memberDAO;
	Login login;
	
	@Before
	public void setUp() {
		memberDAO = new MemberDAO();
		login = new Login(memberDAO);
	}
	
	@Test 
	public void test1() {
		boolean actual = login.judge("abc", "2020");
		boolean expected = true;
		
		assertThat(actual, is(expected));
	}
	
	@Test 
	public void test2() {
		boolean actual = login.judge("abcd", "2020");
		boolean expected = false;
		
		assertThat(actual, is(expected));
	}
	
	@Test 
	public void test3() {
		boolean actual = login.judge("abc", "2023");
		boolean expected = false;
		
		assertThat(actual, is(expected));
	}
	
	@Test 
	public void test4() {
		boolean actual = login.judge("abcd", "2023");
		boolean expected = false;
		
		assertThat(actual, is(expected));
	}
}
