package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import minipro2.Member;

public class MemberDAO {
	Connection connection = null;
	PreparedStatement pre_statement = null;
	// mySQLの接続
	private final static String URL = "jdbc:mysql://localhost:3306/mangasystem?useUnicode=true&characterEncoding=utf8";
	private static final String USER = "root";
	private static final String PASS = "password";// 自分のMySQLのパスワード

	public Member getMember(String id) {
		ResultSet result_set = null;
		Member member = null;
		String sql = "select * from member where id = ?";

		try {
			Connection conn = DriverManager.getConnection(URL, USER, PASS);
			PreparedStatement ps = conn.prepareStatement(sql);
			result_set = ps.executeQuery();

			member = new Member(result_set.getString("name"), result_set.getString("id"), result_set.getString("pass"));

		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} finally {
			closeSql(connection, pre_statement, result_set);
		}
		return member;
	}

	public void setMember(String name, String id, String pw) {
		ResultSet result_set = null;

		String sql = "INSERT INTO member(name, id, pw) VALUES (?, ?, ?)";

		try {
			Connection conn = DriverManager.getConnection(URL, USER, PASS);
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, id);
			ps.setString(3, pw);
			result_set = ps.executeQuery();

		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} finally {
			closeSql(connection, pre_statement, result_set);
		}
	}

	public List<Member> getMemberList(String name, String id, String pw) {
		List<Member> member_list = new ArrayList<Member>();

		ResultSet result_set = null;

		String sql = "SELECT * FROM member";

		try {
			Connection conn = DriverManager.getConnection(URL, USER, PASS);
			PreparedStatement ps = conn.prepareStatement(sql);
			result_set = ps.executeQuery();
			while (result_set.next()) {
				Member member = new Member(result_set.getString("name"), result_set.getString("id"),
						result_set.getString("pw"));
				member_list.add(member);
			}

		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} finally {
			closeSql(connection, pre_statement, result_set);
		}
		return member_list;
	}

	static void closeSql(Connection con, PreparedStatement ps, ResultSet rs) {
		try {
			if (con != null) {
				con.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException sqle) {
			System.err.println("Error closeSql Func");
			sqle.printStackTrace();
		}
	}
}
