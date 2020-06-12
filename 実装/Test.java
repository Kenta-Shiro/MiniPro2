package minipro2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test {
	public static void main(String[] args) {
		// TODO code application logic here
		Connection connection = null;
		PreparedStatement pre_statement = null;
		ResultSet result_set = null;

		try {
			// mySQLの接続
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/mangasystem?useUnicode=true&characterEncoding=utf8", "root",
					"password");

			String sql1 = "select * from member";
			String sql2 = "insert into member()";
			pre_statement = connection.prepareStatement(sql1);
			result_set = pre_statement.executeQuery();

			while (result_set.next()) {
				System.out.print(result_set.getString("name"));
				System.out.println(result_set.getString("id"));
			}

		} catch (SQLException sqle) {
			sqle.printStackTrace();
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
