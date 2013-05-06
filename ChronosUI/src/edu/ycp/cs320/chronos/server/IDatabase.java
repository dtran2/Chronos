package edu.ycp.cs320.chronos.server;

import edu.ycp.cs320.chronos.shared.Account;
import edu.ycp.cs320.chronos.shared.Event;

public interface IDatabase {
	public Event findEvent(int eventID);
	public int getMonth(int eventID);
	public int getDay(int eventID);
	public int getYear(int eventID);
	public int getStartTime(int eventID);
	public int getEndTime(int eventID);
	public void createEvent(int ownerID, String eventName, int month, int day, int year, 
			int startTime, int endTime, String details);
	public String getDetails(int eventID);
	public void removeEvent(Event event);
	public void createAccount(String usr, String password, String email);
	public void removeAccount(int accountID);
	public Account getAccount(String username);
	public boolean verifyAccount(String usr, String password);
	public boolean isDupAccount(String account);
	public Event getNextEvent(String username, int month, int day, int year);
	

}
