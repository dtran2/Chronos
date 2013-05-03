package edu.ycp.cs320.chronos.server;

import edu.ycp.cs320.chronos.server.FakeDatabase;
public class DatabaseUtil {

	private static final IDatabase Instance = new FakeDatabase();
	/**
	 * 
	 * @return an instance of the Fakedatabase
	 */
	public static IDatabase instance() {
		return Instance;
	}
}