package edu.ycp.cs320.chronos.server;

import java.sql.SQLException;
import java.util.ArrayList;

import edu.ycp.cs320.chronos.shared.Account;
import edu.ycp.cs320.chronos.shared.Event;

public interface IDatabase {
	public Event findEvent(int eventID) throws SQLException;
	
	public int getMonth(int eventID) throws SQLException;
	
	public int getDay(int eventID) throws SQLException;
	
	public int getYear(int eventID) throws SQLException;
	
	public int getStartTime(int eventID) throws SQLException;
	
	public int getEndTime(int eventID) throws SQLException;
	
	public Void createEvent(int ownerID, String eventName, int month, int day, int year, 
			int startTime, int endTime, String details)  throws SQLException;
	
	public String getDetails(int eventID) throws SQLException;
	
	public Void removeEvent(Event event) throws SQLException;
	
	public Void createAccount(String usr, String password, String email) throws SQLException;
	
	public Void removeAccount(int accountID) throws SQLException;
	
	public Account getAccount(String username) throws SQLException;
	
	public boolean verifyAccount(String usr, String password) throws SQLException;
	
	public boolean isDupAccount(String account) throws SQLException;
	
	public String nextEventString(String username, int month, int day, int year, int hour, int minutes) throws SQLException;
	
	Event getNextEvent(String username, int month, int day, int year, int hour,
			int minutes) throws SQLException;
	
	public ArrayList<String> getDayString(int userID, int month, int day, int year) throws SQLException;
}
