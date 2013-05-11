package edu.ycp.cs320.chronos.client;

import java.sql.SQLException;
import java.util.ArrayList;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import edu.ycp.cs320.chronos.shared.Event;
/*
import edu.ycp.cs320.chronos.modelClasses.Account;
import edu.ycp.cs320.chronos.modelClasses.Event;
*/
@RemoteServiceRelativePath("eventManagement")
public interface EventManagementService extends RemoteService {
	public void createEvent(int ownerID, String eventName, int month, int day, int year, int startTime,
			int endTime, String details) throws SQLException;
	public void removeEvent(Event event) throws SQLException;
	public Event findEvent(int eventID) throws SQLException;
	public int getMonth(int eventID) throws SQLException;
	public int getDay(int eventID) throws SQLException;
	public int getYear(int eventID) throws SQLException;
	public int getStartTime(int eventID) throws SQLException;
	public int getEndTime(int eventID) throws SQLException;
	public String getDetails(int eventID) throws SQLException;
	public String nextEventString(String username, int month, int day, int year, int hour, int minutes) throws SQLException;
	public String getDayEvents(int userID, int month, int day, int year) throws SQLException;
	public ArrayList<String> getDayString(int userID, int month, int day, int year) throws SQLException;
}
