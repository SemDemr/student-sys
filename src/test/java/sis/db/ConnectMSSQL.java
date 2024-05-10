package sis.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectMSSQL {

	public static String dbUserName = "SisLogin";
	public static String dbPassword = "N***#2022";

	public static String dbUrl = "jdbc:sqlserver://sis.n***.com:1433; databaseName=Test";

	public static void main(String[] args) throws SQLException {

		Connection conn = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
		Statement st = conn.createStatement();

		ResultSet rs = st.executeQuery("SELECT * FROM STUDENT WHERE LastName='Jackson' ");

		// rs.next();
		// rs.next();
		// rs.next();
		// String fName = rs.getString(3);

		// System.out.println(fName);

		while (rs.next()) {
			String firstName = rs.getObject("FirstName").toString();
			String lastName = rs.getObject("LastName").toString();
			String userName = rs.getString("Username");
			String password = rs.getString("Password");

			System.out.println("Firstname: " + firstName + " Lastname: " + lastName + " Username: " + userName
					+ " Password: " + password);

		}
		conn.close();
	}

}
