package edu.ycp.cs320.chronos.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

import edu.ycp.cs320.chronos.shared.Account;
import edu.ycp.cs320.chronos.shared.Event;

public interface EventManagementServiceAsync {

	void createEvent(int ownerID, String eventName, int month, int day, int year, int startTime,
			int endTime, String details, AsyncCallback<Void> callback);
	void isDupEvent(String eventName, AsyncCallback<Boolean> callback);
	void removeEvent(String eventName, AsyncCallback<Void> callback);
	void getNextEvent(Account user, int month, int day, int year,
			AsyncCallback<Event> callback);
	void findEvent(int eventID, AsyncCallback<Event> callback);
	void getMonth(int eventID, AsyncCallback<Integer> callback);
	void getDay(int eventID, AsyncCallback<Integer> callback);
	void getYear(int eventID, AsyncCallback<Integer> callback);
	void getStartTime(int eventID, AsyncCallback<Integer> callback);
	void getEndTime(int eventID, AsyncCallback<Integer> callback);
	void getDetails(int eventID, AsyncCallback<String> callback);
}
