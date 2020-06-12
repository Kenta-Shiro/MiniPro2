package minipro3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import minipro2.Title;

public class TitileDao {
	Connection connection = null;
	PreparedStatement pre_statement = null;
	// mySQLの接続
	private final static String URL = "jdbc:mysql://localhost:3306/mangasystem?useUnicode=true&characterEncoding=utf8";
	private static final String USER = "root";
	private static final String PASS = "masterkey";// 自分のMySQLのパスワード

	public void setTitle(String title) {
		ResultSet result_set = null;

		String sql = "INSERT INTO title(title) VALUES (?)";

		try {
			Connection conn = DriverManager.getConnection(URL, USER, PASS);
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, title);
			result_set = ps.executeQuery();

		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} finally {
			closeSql(connection, pre_statement, result_set);
		}
	}

	public List<Title> getTitleList() {
		List<Title> Title_list = new ArrayList<Title>();

		ResultSet result_set = null;

		String sql = "SELECT * FROM title";

		try {
			Connection conn = DriverManager.getConnection(URL, USER, PASS);
			PreparedStatement ps = conn.prepareStatement(sql);
			result_set = ps.executeQuery();
			while (result_set.next()) {
				Title title = new Title(result_set.getInt("titleno"), result_set.getString("titlename"));
				Title_list.add(title);
			}

		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} finally {
			closeSql(connection, pre_statement, result_set);
		}
		return Title_list;
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
