package edu.ycp.cs320.chronos.server;

	

import java.sql.SQLException;
import java.util.ArrayList;
import edu.ycp.cs320.chronos.shared.Account;
import edu.ycp.cs320.chronos.shared.Event;

public class FakeDatabase implements IDatabase {
	//private Map<String, Event> nameToEventMap;
	//private Map<String, Account> accountMap;
	//Use Maps to organize events to accounts
	private int accountIDCount;	//Handles current account id when making a new account
	private int eventIDCount;	//Handles current event id when making a new Event
	private ArrayList<Account> accountList;	//List of accounts
	private ArrayList<Event> eventList;	//List of events
	//private ArrayList<EventInvitation> eventInvitationList;
	
	public FakeDatabase() throws SQLException {
		accountIDCount = 0;
		eventList = new ArrayList<Event>();
		accountList = new ArrayList<Account>();		
		//Create test accounts
		createAccount("Spongebob", "Squarepants", "x@y.z");
		createAccount("Patric", "Star", "a@b.c");
		createAccount("Sandy", "Cheeks", "q@r.s");
		//Create test events to work with
		createEvent(getAccount("Spongebob").getID(), "Christmas", 12, 25, 2013, 1200, 2400, "Christmas");
		createEvent(getAccount("Spongebob").getID(), "New Years", 1, 1, 2014, 1200, 2400, "New Years day!");
		createEvent(getAccount("Spongebob").getID(), "Thanksgiving", 11, 28, 2013, 1200, 2400, "turkey turkey turkey");		
	}
	
	/**
	 * Methods for handling event info.
	 * 
	 */

	@Override
	/**
	 * Sifts through a list of today's events and returns the Event that will occur next
	 * 
	 *            Note: nextEvent initialized to first element of today...this may cause problems if it has already occured.
	 */
	public Event getNextEvent(String username, int month, int day, int year, int hour, int minutes){
		Account user = getAccount(username);
		ArrayList<Event> today = new ArrayList<Event>();
		today = getTodaysEvents(user.getID(), month, day, year);
		Event nextEvent = new Event(eventIDCount, getUserID(username), month, day, year, 0, 0, "No events today", "default");
		eventIDCount++;
		//Remove events that have already occured
		if(!today.isEmpty()){
			for(int i = 0; i < today.size(); i++){
				if(today.get(i).getStartTime() < (hour * 1000 + minutes)){
					today.remove(i);
				}
			}
			nextEvent = today.get(0); //Set the "nextEvent" to the first Event in the arrayList "events"
			//Sift through the array list to find the next coming event
			for(int i = 1; i < today.size(); i++){
				//if the current "nextEvent"'s start time is greater, it is not the next event 
				if(nextEvent.getStartTime() > today.get(i).getStartTime() && today.get(i).getStartTime() > (hour*1000 + minutes)){
					nextEvent = today.get(i);
				}
			}
		}
		return nextEvent;
	}
	
	/**
	 * Returns the details of the next event of the given account
	 * @param username
	 * @param month
	 * @param day
	 * @param year
	 * @return
	 */
	public String nextEventString(String username, int month, int day, int year, int hour, int minutes){
		return getNextEvent(username, month, day, year, hour, minutes).getDetails();		
	}
	
	/**
	 * Uses the given account id (UserID) to sift through the database's
	 * arrayList of events and collects all user's events in an arrayList
	 * @param userID
	 * @return userEvents
	 */
	public ArrayList<Event> getAccountEvents(int userID){
		ArrayList<Event> userEvents = new ArrayList<Event>();
		for(int i = 0; i < eventList.size(); i++){
			if(eventList.get(i).getOwnerID() == userID){
				userEvents.add(eventList.get(i));
			}
			
		}
		return userEvents;		
	}
	
	/**
	 * Returns the a list of the user's events on a given date
	 * in sequential order; returns NULL if there are no events found for today.
	 * Can be used for other specified dates as well.
	 * @param userID 	-Current user's ID
	 * @param month		-Specified month
	 * @param day		-SpecifiedDay
	 * @param year		-Specified Year
	 * @return
	 */
	public ArrayList<Event> getTodaysEvents(int userID, int month, int day, int year){
		ArrayList<Event> userEvents = getAccountEvents(userID);
		ArrayList<Event> today = new ArrayList<Event>();
		ArrayList<Event> seq = new ArrayList<Event>();
		if(today.size() != 0){
			for(int i = 0; i < userEvents.size(); i++){
				if(userEvents.get(i).getMonth() == month && userEvents.get(i).getDay() == day && userEvents.get(i).getYear() == year){
					today.add(userEvents.get(i));
				}
			}
			Event lower = today.get(0);
			int size = today.size();
			//Order events sequentially
			for(int i = 0; i < size; i++){
				for(int j = 0; j < i; j++){
					if(lower.getStartTime() >= today.get(j).getStartTime()){
						lower = today.get(j);
					}				
				}
				seq.add(lower);
				today.remove(lower);
			}
		}
		return today;
	}
	
	/**
	 * Returns a list of the user's event names on a specified date
	 */
	public ArrayList<String> getDayString(int userID, int month, int day, int year){
		ArrayList<Event> list = getTodaysEvents(userID, month, day, year);
		ArrayList<String> s = new ArrayList<String>();
		if(!list.isEmpty()){
			for(int i = 0; i < list.size(); i++){
				s.add(list.get(i).getName());
			}
		}
		else{
			s.add("No events");
		}
		return s;
	}
	
	/**
	 * Uses the given int eventID to return
	 * the specified event object. Returns null if
	 * the event cannot be found.	
	 * @param eventID
	 * @return
	 */
	public Event findEvent(int eventID) {
		for(int i = 0; i < eventList.size(); i++){
			if(eventList.get(i).getID() == eventID){
				return eventList.get(i);
			}
		}
		return null;
	}
	
	public int getMonth(int eventID){
		return findEvent(eventID).getMonth();
	}
	
	public int getDay(int eventID){
		return findEvent(eventID).getDay();
	}
	
	public int getYear(int eventID){
		return findEvent(eventID).getYear();
	}
	
	public int getStartTime(int eventID){
		return findEvent(eventID).getStartTime();
	}
	
	public int getEndTime(int eventID){
		return findEvent(eventID).getEndTime();
	}
	
	public String getDetails(int eventID){
		return findEvent(eventID).getDetails();
	}
	
	/**
	 * Create an event using the specified values.
	 * Add the new event to eventList (ArrayList<Event>)
	 * @param ownerID	Account ID of event's creator
	 * @param eventName
	 * @param month
	 * @param day
	 * @param year
	 * @param startTime
	 * @param endTime
	 * @param details
	 */
	public Void createEvent(int ownerID, String eventName, int month, int day, int year, 
			int startTime, int endTime, String details) throws SQLException{
		
		Event e = new Event(eventIDCount, ownerID, month, day, year, startTime, endTime, details, eventName);
		eventIDCount++;
		eventList.add(e);
		return null;
	}	
	
	/**
	 * Removes specified event from the database
	 * @param eventName
	 */
	public Void removeEvent(Event event) throws SQLException{
		//FIXME: This method may need to be revised
		eventList.remove(event);
		return null;
	}
	
	/**
	 * Methods for handling Account info.
	 */
	
	/**
	 * Create an account and add it to the database.
	 * accountList.Uses the database's accountIDCount value to associate the new
	 * account with a unique ID. Updates accountIDCount
	 * @param usr
	 * @param password
	 * @param email
	 */
	public Void createAccount(String usr, String password, String email) throws SQLException{
		if(!isDupAccount(usr)){
			System.out.println("Creating account for user: " + usr + ", pass: " + password);
			Account a = new Account(accountIDCount, usr, password, email);
			accountList.add(a);
			accountIDCount++;
		}
		else{
			System.out.println("Account already exists");
		}
		return null;
	}
	
	/**
	 * Remove an account from the database
	 * @param accountID	- Target account ID info
	 */
	public Void removeAccount(int accountID) throws SQLException{
		for(int i = 0; i < accountList.size(); i++){
			if(accountList.get(i).getID() == accountID){
				accountList.remove(i);				
			}
			
		}
		return null;
	}
	
	public int getUserID(String username){
		return getAccount(username).getID();		
	}
	
	/**
	 * Uses the given String username to find
	 * the specified account
	 * @param username
	 */
	public Account getAccount(String username){
		for(int i = 0; i < accountList.size(); i++){
			if(accountList.get(i).getUserName().compareTo(username) == 0){
				return accountList.get(i);
			}
		}
		return null;
	}
	
	/**
	 * Method for verifying account username and password.
	 * Returns true if the password is correct, otherwise returns false.
	 * @param usr
	 * @param password
	 * @return true if password matches with the account; false otherwise
	 */
	public boolean verifyAccount(String usr, String password){
		
		if(accountList.contains(getAccount(usr))){	//Account exists in the database
			System.out.println("Account exists: " + usr);
			Account account = getAccount(usr);
			if(account.getPassword().equals(password)){
				return true;				
			}
			else{
				System.out.println("Password does not match");
				return false;
			}
		}
		System.out.println("No such account: " + usr);
		return false;		
	}
	
	/**
	 * Takes the username (string) and checks to see if
	 * it already exists within the database
	 */
	public boolean isDupAccount(String account){
		for(int i = 0; i < accountList.size(); i++){
			if(accountList.get(i).getUserName().equals(account)){
				return true;
			}
		}
		return false;
	}

}
