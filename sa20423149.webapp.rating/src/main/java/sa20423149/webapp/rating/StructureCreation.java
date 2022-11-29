package sa20423149.webapp.rating;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class StructureCreation {
	public void structure() {
		String jdbcURLString = "jdbc:h2:~/test";
		String username = "root";
		String password = "root";
		try {
			Connection connection = DriverManager.getConnection(jdbcURLString, username, password);
			System.out.println("connected");

			Statement stmt = connection.createStatement();
			String sql = "CREATE TABLE IF NOT EXISTS STUDENTS" + "(STUDENTNAME VARCHAR(45) NOT NULL,"
					+ "SUBJECT VARCHAR(45) NOT NULL," + "ASSIGNMENTCATEGORY VARCHAR(45) NOT NULL,"
					+ "DATE VARCHAR(45) NULL DEFAULT 0," + "MARKS INT NULL,"
					+ "PRIMARY KEY (STUDENTNAME, SUBJECT, ASSIGNMENTCATEGORY))";

			stmt.executeUpdate(sql);
			System.out.println("table students created");

			sql = "CREATE TABLE IF NOT EXISTS LAB" + "(STUDENTNAME VARCHAR(45) NOT NULL,"
					+ "SUBJECT VARCHAR(45) NOT NULL," + "ASSIGNMENTCATEGORY VARCHAR(45) NOT NULL,"
					+ "SEQUENCE INT NULL DEFAULT 1," + "MARK INT NULL DEFAULT 0,"
					+ "PRIMARY KEY (STUDENTNAME, SUBJECT))";
//			    +"CONSTRAINT fk_LAB_STUDENTS1 FOREIGN KEY (STUDENTNAME , SUBJECT)"+"REFERENCES STUDENTS (STUDENTNAME , SUBJECT)"+"ON DELETE CASCADE ON UPDATE CASCADE)";

			stmt.executeUpdate(sql);
			System.out.println("table lab created");

			sql = "CREATE TABLE IF NOT EXISTS PROJECT " + "(STUDENTNAME VARCHAR(45) NOT NULL,"
					+ "SUBJECT VARCHAR(45) NOT NULL," + "ASSIGNMENTCATEGORY VARCHAR(45) NOT NULL,"
					+ "SEQUENCE INT NULL DEFAULT 1," + "MARKS INT NULL DEFAULT 0,"
					+ "PRIMARY KEY (STUDENTNAME, SUBJECT))";
//				+ "PRIMARY KEY (STUDENTNAME, SUBJECT),CONSTRAINT fk_PROJECT_STUDENTS1 FOREIGN KEY (STUDENTNAME , SUBJECT)REFERENCES STUDENTS (STUDENTNAME , SUBJECT)ON DELETE CASCADE ON UPDATE CASCADE)ENGINE = InnoDB;

			stmt.executeUpdate(sql);
			System.out.println("table project created");

			sql = "CREATE TABLE IF NOT EXISTS TEST " + "(STUDENTNAME VARCHAR(45) NOT NULL,"
					+ "SUBJECT VARCHAR(45) NOT NULL," + "ASSIGNMENTCATEGORY VARCHAR(45) NOT NULL,"
					+ "SEQUENCE INT NULL DEFAULT 1," + "MARKS INT NULL DEFAULT 0,"
					+ "PRIMARY KEY (STUDENTNAME, SUBJECT))";
			stmt.executeUpdate(sql);
			System.out.println("table quiz created");

			sql = "CREATE TABLE IF NOT EXISTS QUIZ " + "(STUDENTNAME VARCHAR(45) NOT NULL,"
					+ "SUBJECT VARCHAR(45) NOT NULL," + "ASSIGNMENTCATEGORY VARCHAR(45) NOT NULL,"
					+ "SEQUENCE INT NULL DEFAULT 1," + "MARKS INT NULL DEFAULT 0,"
					+ "PRIMARY KEY (STUDENTNAME, SUBJECT))";

			stmt.executeUpdate(sql);
			System.out.println("table quiz created");

			sql = "CREATE TABLE IF NOT EXISTS OVERALLRATING" + "( STUDENTNAME VARCHAR(45) NOT NULL,"
					+ "SUBJECT VARCHAR(45) NOT NULL," + "TESTSCORE DOUBLE NULL DEFAULT 0,"
					+ "QUIZSCORE DOUBLE NULL DEFAULT 0," + "LABSCORE DOUBLE NULL DEFAULT 0,"
					+ "OVERALLSCORE DOUBLE NULL DEFAULT 0," + "PRIMARY KEY (STUDENTNAME, SUBJECT))";
			stmt.executeUpdate(sql);
			System.out.println("table overall created");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
