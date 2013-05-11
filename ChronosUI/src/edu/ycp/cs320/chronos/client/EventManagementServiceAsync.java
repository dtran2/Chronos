package edu.ycp.cs320.chronos.client;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.AsyncCallback;

import edu.ycp.cs320.chronos.shared.Event;

public interface EventManagementServiceAsync {
	
	void createEvent(int ownerID, String eventName, int month, int day, int year, int startTime,
			int endTime, String details, AsyncCallback<Void> callback);
	
	void removeEvent(Event event, AsyncCallback<Void> callback);
	
	void findEvent(int eventID, AsyncCallback<Event> callback);
	
	void getMonth(int eventID, AsyncCallback<Integer> callback);
	
	void getDay(int eventID, AsyncCallback<Integer> callback);
	
	void getYear(int eventID, AsyncCallback<Integer> callback);
	
	void getStartTime(int eventID, AsyncCallback<Integer> callback);
	
	void getEndTime(int eventID, AsyncCallback<Integer> callback);
	
	void getDetails(int eventID, AsyncCallback<String> callback);
	
	void nextEventString(String username, int month, int day, int year, int hour, int minutes,
			AsyncCallback<String> callback);
	
	void getDayString(int userID, int month, int day, int year,
			AsyncCallback<ArrayList<String>> callback);
}
