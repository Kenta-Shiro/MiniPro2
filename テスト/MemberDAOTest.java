package DAO;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import minipro3.Member;

public class MemberDAOTest {
	MemberDAO mdao;

	@Before
	public void setUp() {
		mdao = new MemberDAO();
	}

	@Test
	public void メンバーを取得() {
		Member get_member = mdao.getMember("abc");
		System.out.println(get_member.getId());
		System.out.println(get_member.getName());
	}

	@Test
	public void 登録されていないメンバーを取得() {
		Member get_member = mdao.getMember("xyz");
		assertThat(get_member, is(nullValue()));
	}

	@Test
	public void メンバーを登録() {
		mdao.setMember("鈴木一郎", "suzuki", "1234");
		Member get_member = mdao.getMember("suzuki");
		System.out.println(get_member.getId());
		System.out.println(get_member.getName());
	}

	@Test
	public void メンバーリストを取得() {
		List<Member> mlist = mdao.getMemberList();
		for (Member m : mlist) {
			System.out.println(m.getId());
			System.out.println(m.getName());
		}
	}
}
