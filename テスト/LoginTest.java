package minipro2;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class LoginTest {

	MemberList memberList;
	Login login;
	
	@Before
	public void setUp() {
		memberList = new MemberList();
		login = new Login(memberList);
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
