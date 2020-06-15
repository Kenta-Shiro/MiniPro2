package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import minipro.Member;
import minipro.Review;

public class ReviewDAO {
	Connection connection = null;
	PreparedStatement pre_statement = null;
	// mySQLの接続
	private final static String URL = "jdbc:mysql://localhost:3306/mangasystem?useUnicode=true&characterEncoding=utf8";
	private static final String USER = "root";
	private static final String PASS = "Houki2744044";// 自分のMySQLのパスワード

	// 重複のないreviewnoを設定
	public int getReviewNo() {
		int no = 0;
		ResultSet result_set = null;

		String sql = "SELECT reviewno FROM review ORDER BY reviewno ASC";

		try {
			Connection conn = DriverManager.getConnection(URL, USER, PASS);
			PreparedStatement ps = conn.prepareStatement(sql);
			result_set = ps.executeQuery();

			while (result_set.next()) {
				int get_no = result_set.getInt("reviewno");
				if (no == get_no) {
					no++;
				}
			}

		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} finally {
			closeSql(connection, pre_statement, result_set);
		}
		return no;
	}

	private static java.sql.Timestamp getCurrentTimeStamp() {
		java.util.Date today = new java.util.Date();
		return new java.sql.Timestamp(today.getTime());
	}

	// レビューの登録
	public void setReview(String id, int titleno, String content) {
		ResultSet result_set = null;

		String sql = "INSERT INTO review(reviewno, titleno, member_id, reviewdate, content) VALUES (?, ?, ?, ?, ?)";

		try {
			Connection conn = DriverManager.getConnection(URL, USER, PASS);
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, getReviewNo());
			ps.setInt(2, titleno);
			ps.setString(3, id);
			ps.setTimestamp(4, getCurrentTimeStamp());
			ps.setString(5, content);
			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} finally {
			closeSql(connection, pre_statement, result_set);
		}
	}

	// タイトル毎のレビューリストを持ってくる
	public List<Review> getReviews(int titleno) {
		List<Review> review_list = new ArrayList<Review>();
		ResultSet result_set = null;
		Member member;

		String sql = "SELECT * FROM review INNER JOIN member ON review.member_id = member.id WHERE titleno = ?";

		try {
			Connection conn = DriverManager.getConnection(URL, USER, PASS);
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, titleno);
			result_set = ps.executeQuery();

			while (result_set.next()) {
				member = new Member(result_set.getString("name"), result_set.getString("member_id"));
				Review review = new Review(result_set.getInt("reviewno"), result_set.getString("reviewdate"),
						result_set.getString("content"), member);
				review_list.add(review);
			}

		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} finally {
			closeSql(connection, pre_statement, result_set);
		}
		return review_list;
	}

	// ユーザーごとのレビューリストを持ってくる
	public List<Review> getMyReviews(Member member) {// getMyReviewList
		List<Review> review_list = new ArrayList<Review>();
		ResultSet result_set = null;
		String id = member.getId();

		String sql = "SELECT * FROM review INNER JOIN title ON review.titleno = title.titleno WHERE member_id = ?";

		try {
			Connection conn = DriverManager.getConnection(URL, USER, PASS);
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			result_set = ps.executeQuery();

			while (result_set.next()) {
				Review review = new Review(result_set.getInt("reviewno"), result_set.getString("titlename"),
						result_set.getString("reviewdate"), result_set.getString("content"), member);
				review_list.add(review);
			}

		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} finally {
			closeSql(connection, pre_statement, result_set);
		}
		return review_list;
	}

	// レビューの削除
	public void deleteReview(int reviewNo) {
		ResultSet result_set = null;

		String sql = "DELETE FROM review WHERE reviewno = ?;";

		try {
			Connection conn = DriverManager.getConnection(URL, USER, PASS);
			PreparedStatement ps = conn.prepareStatement(sql);
			result_set = ps.executeQuery();
			ps.setInt(1, reviewNo);

		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} finally {
			closeSql(connection, pre_statement, result_set);
		}
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
