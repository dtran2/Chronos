package edu.ycp.cs320.chronos.server;

import java.sql.SQLException;

public class CreateTables {

	public static void main(String[] args) throws SQLException {
		ChronosDatabase db = new ChronosDatabase();
		db.createTables();
		
		db.createAccount("alice", "abc", "alice@xyz.com");
		
		System.out.println("Successfully created tables");
	}

}
