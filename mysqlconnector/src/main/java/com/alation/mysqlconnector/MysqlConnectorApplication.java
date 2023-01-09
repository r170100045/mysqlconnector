package com.alation.mysqlconnector;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.*;

@SpringBootApplication
public class MysqlConnectorApplication {

	public static void main(String[] args) throws SQLException {

		SpringApplication.run(MysqlConnectorApplication.class, args);
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("successful connection");
		} catch(Exception e){
			System.err.println("Exception " + e.getStackTrace());
		}
		String url = "jdbc:mysql://localhost:3306/?user=root";
		String username = "root";
		String password = "211099";
		Connection con = DriverManager.getConnection(url, username, password);
		DatabaseMetaData meta = con.getMetaData();
		ResultSet res = meta.getSchemas();
		System.out.println("List of schemas: ");
		while (res.next()) {
			System.out.println(
					"   "+res.getString("TABLE_SCHEM")
							+ ", "+res.getString("TABLE_CATALOG"));
		}
		System.out.println("connection established");
		Statement st = con.createStatement();
//		String query = "select * from concept_complex";
//		ResultSet rs
//				= st.executeQuery(query); // Execute query
//		rs.next();
//		String name
//				= rs.getString("handler");
//		System.out.println(name); // Print result on console
//		ResultSetMetaData rsMetaData = rs.getMetaData();
//		System.out.println("List of column names in the current table: ");
//		//Retrieving the list of column names
//		int count = rsMetaData.getColumnCount();
//		for(int i = 1; i<=count; i++) {
//			System.out.println(rsMetaData.getColumnName(i));
//		}
		st.close(); // close statement
		con.close(); // close connection
		System.out.println("Connection Closed....");

	}

}
