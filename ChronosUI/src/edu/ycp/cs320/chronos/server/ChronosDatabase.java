package edu.ycp.cs320.chronos.server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;

import edu.ycp.cs320.chronos.shared.Account;
import edu.ycp.cs320.chronos.shared.Event;

//import edu.ycp.cs320.pizza.server.DerbyDatabase.DatabaseConnection;

public class ChronosDatabase implements IDatabase {
	//set the database to the FakeDatabase.java
	private static final String DATABASE = "../Chronos/edu/ycp/cs320/modelClasses/FakeDatabase.java";


	static {
		try {
			//add this to your classpath
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		} catch (Exception e) {
			throw new RuntimeException("Could not load Derby JDBC driver");
		}
	}

	private class DatabaseConnection {
		public Connection conn;
		public int refCount;
	}
	private final ThreadLocal<DatabaseConnection> connHolder = new ThreadLocal<DatabaseConnection>();

	private DatabaseConnection getConnection() throws SQLException {
		DatabaseConnection dbConn = connHolder.get();
		if (dbConn == null) {
			dbConn = new DatabaseConnection();
			dbConn.conn = DriverManager.getConnection("jdbc:derby:" + DATABASE + ";create=true");
			dbConn.refCount = 0;
			connHolder.set(dbConn);
		}
		dbConn.refCount++;
		return dbConn;
	}

	private void releaseConnection(DatabaseConnection dbConn) throws SQLException {
		dbConn.refCount--;
		if (dbConn.refCount == 0) {
			try {
				dbConn.conn.close();
			} finally {
				connHolder.set(null);
			}
		}
	}
	private<E> E databaseRun(ITransaction<E> transaction) throws SQLException {
		// FIXME: retry if transaction times out due to deadlock
		
		DatabaseConnection dbConn = getConnection();
		
		try {
			boolean origAutoCommit = dbConn.conn.getAutoCommit();
			try {
				dbConn.conn.setAutoCommit(false);

				E result = transaction.run(dbConn.conn);
				dbConn.conn.commit();
				return result;
			} finally {
				dbConn.conn.setAutoCommit(origAutoCommit);
			}
		} finally {
			releaseConnection(dbConn);
		}
	}
	
	void createTables() throws SQLException {
		databaseRun(new ITransaction<Boolean>() {
			@Override
			public Boolean run(Connection conn) throws SQLException {
				
				PreparedStatement stmt = null;
				
				try {
					stmt = conn.prepareStatement(
							"create table users (" +
							"  id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), " +
							"  user_names VARCHAR(200) NOT NULL, " +
							"  user_password VARCHAR(200) " +
							")"
					);
					
					stmt.executeUpdate();
				} finally {
					//DBUtil.closeQuietly(stmt);
				}
				
				return true;
			}
		});
	}

	@Override
	public Event getNextEvent(Account user, int month, int day, int year) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Event findEvent(int eventID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getMonth(int eventID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getDay(int eventID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getYear(int eventID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getStartTime(int eventID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getEndTime(int eventID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void createEvent(int ownerID, String eventName, int month, int day,
			int year, int startTime, int endTime, String details) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getDetails(int eventID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeEvent(Event event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createAccount(String usr, String password, String email) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeAccount(int accountID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Account getAccount(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean verifyAccount(String usr, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isDupAccount(String account) {
		// TODO Auto-generated method stub
		return false;
	}
}
