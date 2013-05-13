/*package edu.ycp.cs320.chronos.server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import edu.ycp.cs320.chronos.shared.Account;
import edu.ycp.cs320.chronos.shared.Event;
*//**
 * Main database class
 * @author dtran2
 *
 *//*
public class ChronosDatabase implements IDatabase {
	//Set the database to the FakeDatabase.java (located within the same package)
	//FIXME: The address set to DATABASE may need to change if problems occur
	private static final String DATABASE = "../FakeDatabase";
	

	static {
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		} catch (Exception e) {
			throw new RuntimeException("Derby JDBC driver could not be loaded: " + e.getMessage());
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
							"create table account_list (" +
							"  id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), " +
							"  user_names VARCHAR(200) NOT NULL, " +
							"  user_password VARCHAR(200) " +
							")"
					);
					
					stmt.executeUpdate();
				} finally {
					DatabaseUtil.closeQuietly(stmt);
				}
				
				return true;
			}
		});
	}

	
	*//**
	 * Methods for getting values from the database
	 *//*
	
	
	@Override
	public Event getNextEvent(String username, int month, int day, int year, int hour, int minutes) throws SQLException {
		return databaseRun(new ITransaction<Event>(){
			@Override
			public Event run(Connection conn) throws SQLException {
				return null;
			}
			
		});
	}
	@Override
	public Event findEvent(int eventID) throws SQLException{
		return databaseRun(new ITransaction<Event>(){
			@Override
			public Event run(Connection conn) throws SQLException {
				return null;
			}
			
		});
	}

	@Override
	public int getMonth(int eventID) throws SQLException {
		return databaseRun(new ITransaction<Integer>(){
			@Override
			public Integer run(Connection conn) throws SQLException {
				PreparedStatement ps = null;
				try{
					return 0;
				}
				finally{
					//Not complete
				}
			}
			
		});
	}

	@Override
	public int getDay(int eventID) throws SQLException {
		return databaseRun(new ITransaction<Integer>(){
			@Override
			public Integer run(Connection conn) throws SQLException {
				// TODO Auto-generated method stub
				return null;
			}
			
		});
	}

	@Override
	public int getYear(int eventID) throws SQLException {
		return databaseRun(new ITransaction<Integer>(){
			@Override
			public Integer run(Connection conn) throws SQLException {
				return null;
			}
			
		});
	}

	@Override
	public int getStartTime(int eventID) throws SQLException {
		return databaseRun(new ITransaction<Integer>(){
			@Override
			public Integer run(Connection conn) throws SQLException {
				// TODO Auto-generated method stub
				return null;
			}			
		});
	}

	@Override
	public int getEndTime(int eventID) throws SQLException {
		return databaseRun(new ITransaction<Integer>(){
			@Override
			public Integer run(Connection conn) throws SQLException {
				// TODO Auto-generated method stub
				return null;
			}			
		});
	}

	@Override
	public Void createEvent(int ownerID, String eventName, int month, int day,
			int year, int startTime, int endTime, String details) throws SQLException {
		
		return databaseRun(new ITransaction<Void>(){
			@Override
			public Void run(Connection conn) throws SQLException {
				// TODO Auto-generated method stub
				return null;
			}			
		});
		
	}

	@Override
	public String getDetails(int eventID) throws SQLException {
		return databaseRun(new ITransaction<String>(){
			@Override
			public String run(Connection conn) throws SQLException {
				// TODO Auto-generated method stub
				return null;
			}
			
		});
	}

	@Override
	public Void removeEvent(Event event) throws SQLException {
		return databaseRun(new ITransaction<Void>(){
			@Override
			public Void run(Connection conn) throws SQLException {
				// TODO Auto-generated method stub
				return null;
			}
			
		});
		
	}

	@Override
	public Void createAccount(String usr, String password, String email) throws SQLException {
		return databaseRun(new ITransaction<Void>(){
			@Override
			public Void run(Connection conn) throws SQLException {
				// TODO Auto-generated method stub
				return null;
			}
			
		});
	}

	@Override
	public Void removeAccount(int accountID) throws SQLException {
		return databaseRun(new ITransaction<Void>(){
			@Override
			public Void run(Connection conn) throws SQLException {
				// TODO Auto-generated method stub
				return null;
			}			
		});
		
	}

	@Override
	public Account getAccount(String username) throws SQLException {
		return databaseRun(new ITransaction<Account>(){
			@Override
			public Account run(Connection conn) throws SQLException {
				// TODO Auto-generated method stub
				return null;
			}
			
		});
	}

	@Override
	public boolean verifyAccount(String usr, String password) throws SQLException {
		return databaseRun(new ITransaction<Boolean>(){
			@Override
			public Boolean run(Connection conn) throws SQLException {
				// TODO Auto-generated method stub
				return false;
			}
			
		});
	}

	@Override
	public boolean isDupAccount(String account) throws SQLException {
		return databaseRun(new ITransaction<Boolean>(){
			@Override
			public Boolean run(Connection conn) throws SQLException {
				return true;
			}
			
		});
	}

	@Override
	public String nextEventString(String username, int month, int day, int year, int hour, int minutes) throws SQLException {
		return databaseRun(new ITransaction<String>(){
			@Override
			public String run(Connection conn) throws SQLException {
				return null;
			}
			
		});
	}

	@Override
	public ArrayList<String> getDayString(int userID, int month, int day,
			int year) throws SQLException {
				return databaseRun(new ITransaction<ArrayList<String>>(){
					@Override
					public ArrayList<String> run(Connection conn) throws SQLException {
						// TODO Auto-generated method stub
						return null;
					}
					
				});
	}
}
*/