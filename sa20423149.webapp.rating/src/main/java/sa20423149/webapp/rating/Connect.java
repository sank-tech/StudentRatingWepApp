package sa20423149.webapp.rating;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
	public static Connection getConnection() {

		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:h2:~/test", "root", "root");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;

	}

}
