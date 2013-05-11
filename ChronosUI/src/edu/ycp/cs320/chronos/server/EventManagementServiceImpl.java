package edu.ycp.cs320.chronos.server;

import java.sql.SQLException;
import java.util.ArrayList;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import edu.ycp.cs320.chronos.client.EventManagementService;
import edu.ycp.cs320.chronos.shared.Event;

/**
 * RemoteService that allows the user to access all event
 * details and create, remove, or modify an event
 * @author agrzybow
 *
 */
public class EventManagementServiceImpl extends RemoteServiceServlet
		implements EventManagementService{
	private static final long serialVersionUID = 1L;	
	
	/**
	 * Creates an event and stores it in the database
	 */
	@Override
	public void createEvent(int ownerID, String eventName, int month, int day, int year, int startTime,
			int endTime, String details){
		try {
			DatabaseUtil.instance().createEvent(ownerID, eventName, month, day, year, startTime,
					endTime, details);
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
			e.printStackTrace();
		}
	}	
	/**
	 * Remove a specified event from the database
	 */
	@Override
	public void removeEvent(Event event){
		try {
			DatabaseUtil.instance().removeEvent(event);
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
			e.printStackTrace();
		}
	}
	/**
	 * Takes the given user, month, day, and year and
	 * finds the next event after the current one
	 * @param user 	The current user 
	 * @param month The current month
	 * @param day 	The current day
	 * @param year	The current year
	 * Returns the event that will come next
	 */
	//@Override
	public Event getNextEvent(String username, int month, int day, int year, int hour, int minutes) {
		try {
			return DatabaseUtil.instance().getNextEvent(username, month, day, year, hour, minutes);
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

	@Override
	/**
	 * Takes the given eventID
	 * Returns the event object with the corresponding name
	 */
	public Event findEvent(int eventID){
		try {
			return DatabaseUtil.instance().findEvent(eventID);
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
			e.printStackTrace();
			return null;
		}
		
	}
	@Override
	/**
	 * Takes the given eventID and uses the findEvent
	 * method to get the month for that event
	 * Returns an integer for the the month of the event
	 */
	public int getMonth(int eventID){
		try {
			return DatabaseUtil.instance().getMonth(eventID);
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
			e.printStackTrace();
			return 0;
		}
	}
	@Override
	/**
	 * Takes the given eventID and uses the findEvent
	 * method to get the day for that event
	 * Returns an integer for the the day of the event
	 */
	public int getDay(int eventID ){
		try {
			return DatabaseUtil.instance().getDay(eventID);
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
			e.printStackTrace();
			return 1;
		}
	}

	@Override
	/**
	 * Takes the given eventID and uses the findEvent
	 * method to get the year for that event
	 * Returns an integer for the the year of the event
	 */
	public int getYear(int eventID){
		try {
			return DatabaseUtil.instance().getYear(eventID);
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	/**
	 * Takes the given eventID and uses the findEvent
	 * method to get the start time for that event
	 * Returns an integer for the the start time of the event in 0000 format
	 */
	public int getStartTime(int eventID){
		try {
			return DatabaseUtil.instance().getStartTime(eventID);
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	/**
	 * Takes the given eventID and uses the findEvent
	 * method to get the end time for that event
	 * Returns an integer for the the end time of the event in 0000 format
	 */
	public int getEndTime(int eventID){
		try {
			return DatabaseUtil.instance().getEndTime(eventID);
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	/**
	 * Takes the given eventID and uses the findEvent
	 * method to get the details that describe the event
	 * Returns a string with the description of the event
	 */
	public String getDetails(int eventID){
		try {
			return DatabaseUtil.instance().getDetails(eventID);
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
			e.printStackTrace();
			return "Error encountered";
		}
	}	
	
	@Override
	public String nextEventString(String username, int month, int day, int year, int hour, int minutes){
		try {
			return DatabaseUtil.instance().nextEventString(username, month, day, year, hour, minutes);
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
			e.printStackTrace();
			return "Error encountered";
		}
	}
	
	@Override
	public ArrayList<String> getDayString(int userID, int month, int day, int year){
		try {
			return DatabaseUtil.instance().getDayString(userID, month, day, year);
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

}
