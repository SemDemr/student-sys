package sis.db;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectWithURL {

	public static String dbUrl = "jdbc:sqlserver://sis.n****.com:1433; "
			+ "dataBase=Test; user=SisLogin; password=N***#2022; ";

	public static void main(String[] args) throws SQLException {
		
		Connection con = DriverManager.getConnection(dbUrl);
		//Information about database
		DatabaseMetaData dbMeta = con.getMetaData();
		
		String dbName = dbMeta.getDatabaseProductName();
		String dbVersion = dbMeta.getDatabaseProductVersion();
		
		System.out.println(dbName + " -> " + dbVersion);
		
		System.out.println("");


	}
	
	
	
	
	
	
}
