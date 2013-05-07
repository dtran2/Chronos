package edu.ycp.cs320.chronos.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import edu.ycp.cs320.chronos.client.EventManagementService;
import edu.ycp.cs320.chronos.shared.Account;
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
	 * Takes the given eventID, month, day, year,
	 * startTime, endTime, and details
	 * to create a new event in the database
	 * 
	 */
	@Override
	public void createEvent(int ownerID, String eventName, int month, int day, int year, int startTime,
			int endTime, String details){
		DatabaseUtil.instance().createEvent(ownerID, eventName, month, day, year, startTime,
				endTime, details);
	}	
	/**
	 * Takes the given eventID finds it in the database
	 * and deletes its from the database
	 */
	@Override
	public void removeEvent(Event event) {
		DatabaseUtil.instance().removeEvent(event);
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
	public Event getNextEvent(String username, int month, int day, int year) {
		return DatabaseUtil.instance().getNextEvent(username, month, day, year);
	}

	@Override
	/**
	 * Takes the given eventID
	 * Returns the event object with the corresponding name
	 */
	public Event findEvent(int eventID){
		return DatabaseUtil.instance().findEvent(eventID);
	}
	@Override
	/**
	 * Takes the given eventID and uses the findEvent
	 * method to get the month for that event
	 * Returns an integer for the the month of the event
	 */
	public int getMonth(int eventID) {
		return DatabaseUtil.instance().getMonth(eventID);
	}

	@Override
	/**
	 * Takes the given eventID and uses the findEvent
	 * method to get the day for that event
	 * Returns an integer for the the day of the event
	 */
	public int getDay(int eventID) {
		return DatabaseUtil.instance().getDay(eventID);
	}

	@Override
	/**
	 * Takes the given eventID and uses the findEvent
	 * method to get the year for that event
	 * Returns an integer for the the year of the event
	 */
	public int getYear(int eventID) {
		return DatabaseUtil.instance().getYear(eventID);
	}

	@Override
	/**
	 * Takes the given eventID and uses the findEvent
	 * method to get the start time for that event
	 * Returns an integer for the the start time of the event in 0000 format
	 */
	public int getStartTime(int eventID) {
		return DatabaseUtil.instance().getStartTime(eventID);
	}

	@Override
	/**
	 * Takes the given eventID and uses the findEvent
	 * method to get the end time for that event
	 * Returns an integer for the the end time of the event in 0000 format
	 */
	public int getEndTime(int eventID) {
		return DatabaseUtil.instance().getEndTime(eventID);
	}

	@Override
	/**
	 * Takes the given eventID and uses the findEvent
	 * method to get the details that describe the event
	 * Returns a string with the description of the event
	 */
	public String getDetails(int eventID) {
		return DatabaseUtil.instance().getDetails(eventID);
	}	
	public String nextEventString(String username, int month, int day, int year) {
		return DatabaseUtil.instance().nextEventString(username, month, day, year);
	}

}
