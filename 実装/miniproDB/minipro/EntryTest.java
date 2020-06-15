package minipro;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import DAO.MemberDAO;

public class EntryTest {
	MemberDAO md;
	List<Member> members;
	Entry e;

	@Before
	public void setUp() {
		md = new MemberDAO();
		members = md.getMemberList();
		e = new Entry(md);
	}

	@Test
	public void test1() {
		boolean actual = e.isRegistered("abc");
		boolean expected = true;

		assertThat(actual, is(expected));
	}

	@Test
	public void test2() {
		boolean actual = e.isRegistered("xyz");
		boolean expected = false;

		assertThat(actual, is(expected));
	}
}
