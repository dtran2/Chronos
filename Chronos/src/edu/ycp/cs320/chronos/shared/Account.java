package edu.ycp.cs320.chronos.shared;

import java.io.Serializable;
import java.util.ArrayList;

public class Account implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String userName, password, emailAddress;
	private ArrayList<Event> events; // remove this?
	
	public Account() {
		
	}
	
	public Account(int accountID, String usr, String pwd, String email){
		this.id = accountID;
		this.userName = usr;
		this.password = pwd;
		this.emailAddress = email;
		this.events = new ArrayList();
		
	}
	public int getID(){
		return id;		
	}
	public String getUserName(){
		return userName;
	}
	public String getPassword(){
		return password;
	}
	public String getEmail(){
		return emailAddress;
	}
	public void addEvent(Event event){
		this.events.add(event);
	}
	public ArrayList<Event> getEvents(){
		return this.events;
	}
	/**
	 * Sift through the entire arraylist of events 
	 * to find the ones that will occur today
	 * 
	 * @param month
	 * @param day
	 * @param year
	 * @return
	 */
	public ArrayList<Event> getTodaysEvents(int month, int day, int year){
		ArrayList<Event> events = getEvents();
		ArrayList<Event> todaysEvents = new ArrayList();
		if(events == null){
			//There are no events in the arraylist
		}
		for(int i = 0; i < events.size(); i++){
			if(events.get(i).getMonth() == month && events.get(i).getDay() == day && events.get(i).getYear() == year){
				todaysEvents.add(events.get(i));
			}
		}
		return todaysEvents;
	}
}
