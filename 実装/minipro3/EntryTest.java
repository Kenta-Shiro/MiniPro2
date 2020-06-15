package minipro3;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class EntryTest {

	MemberDAO md;
	//MemberList ml;
	List<Member> members;
	Entry e;
	
	@Before
	public void setUp() {
		md = new MemberDAO();
		members = md.getMemberList();
		e = new Entry(md);
		/*
		ml = new MemberList();
		members = ml.getMemberList();
		e = new Entry(ml);
		*/
	}
	
	@Test
	public void test1() {
		boolean actual = e.isRegistered("abc", members);
		boolean expected = true;
		
		assertThat(actual, is(expected));
	}
	
	@Test
	public void test2() {
		boolean actual = e.isRegistered("def", members);
		boolean expected = false;
		
		assertThat(actual, is(expected));
	}
}
