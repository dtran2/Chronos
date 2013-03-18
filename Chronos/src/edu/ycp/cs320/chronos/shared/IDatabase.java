package edu.ycp.cs320.chronos.shared;

public interface IDatabase {
	
	public Event findEvent(String eventName);
	public int getMonth(String eventName);
	public int getDay(String eventName);
	public int getYear(String eventName);
	public int getStartTime(String eventName);
	public int getEndTime(String eventName);
	public String getDetails(String eventName);
	public void createAccount(String usrName, String password, String email);
	public boolean verifyAccount(String usrName, String password);
	
}