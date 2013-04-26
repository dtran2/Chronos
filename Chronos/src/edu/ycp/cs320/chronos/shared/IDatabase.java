package edu.ycp.cs320.chronos.shared;

import java.util.ArrayList;

public interface IDatabase {

	public Event getNextEvent(Account user, int month, int day, int year);
	public Event findEvent(int eventID);
	public int getMonth(int eventID);
	public int getDay(int eventID);
	public int getYear(int eventID);
	public int getStartTime(int eventID);
	public int getEndTime(int eventID);
	public void createEvent(int ownerID, String eventName, int month, int day, int year, 
			int startTime, int endTime, String details);
	public String getDetails(int eventID);
	boolean isDupEvent(String eventName);
	public void removeEvent(String eventName);
	public void createAccount(String usr, String password, String email);
	public void removeAccount(int accountID);
	public Account getAccount(String username);
	public boolean verifyAccount(String usr, String password);
	public boolean isDupAccount(String account);
	
	
}



