package edu.ycp.cs320.chronos.server;
/*
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import com.google.gwt.dev.util.collect.HashMap;
import com.sun.corba.se.pept.transport.Connection;

import edu.ycp.cs320.chronos.shared.Account;
import edu.ycp.cs320.chronos.shared.Event;
*/
public class Database /*implements IDatabase*/ {
	
//	private Map<String, Account> accountMap;
//
//	@Override
//	public Event findEvent(String eventName) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//
//
//	@Override
//	public void createAccount(String usrName, String password, String email) {
//
//		return databaseRun(new ITransaction<Map<String, Account>>() {
//
//			public Map<String, Account> run(Connection conn) throws SQLException {
//				PreparedStatement stmt = null;
//				ResultSet resultSet = null;
//
//				try {
//					stmt = conn.prepareStatement("select * from accounts");
//					resultSet = stmt.executeQuery();
//
//					Map<String, Account> result = new HashMap<String, Account>();
//
//					while (resultSet.next()) {
//						Account account = new Account(usrName, password, email);
//
//						account.setId(resultSet.getInt(1));
//						account.setUserName(resultSet.getString(2));
//						account.setPassword(resultSet.getString(3));
//						account.setEmail(resultSet.getString(4));
//
//						result.add(account);
//					}
//
//					return result;
//				} finally {
//					DatabaseUtil.closeQuietly(stmt);
//					DatabaseUtil.closeQuietly(resultSet);
//				}
//			}
//		});
//
//	}
//
//
//	@Override
//	public boolean verifyAccount(String usrName, String password) {
//		// TODO Auto-generated method stub
//		return this.verifyAccount(usrName, password);
//	}
//
//	@Override
//	public Event getNextEvent(Account user) {
//		// TODO Auto-generated method stub
//		return this.getNextEvent(user);
//	}
//
//
//
//	@Override
//	public int getMonth(String eventName) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//
//
//	@Override
//	public int getDay(String eventName) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//
//
//	@Override
//	public int getYear(String eventName) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//
//
//	@Override
//	public int getStartTime(String eventName) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//
//
//	@Override
//	public int getEndTime(String eventName) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//
//
//	@Override
//	public String getDetails(String eventName) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
}
