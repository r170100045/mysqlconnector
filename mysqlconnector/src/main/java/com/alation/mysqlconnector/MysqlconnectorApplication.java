package com.alation.mysqlconnector;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MysqlconnectorApplication {

	public static void main(String[] args) {

		SpringApplication.run(MysqlconnectorApplication.class, args);
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("successful connection");
		} catch(Exception e){
			System.err.println("Exception " + e.getStackTrace());
		}
	}

}
