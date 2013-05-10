package edu.ycp.cs320.chronos.client;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DateLabel;
import com.google.gwt.user.client.ui.IntegerBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.datepicker.client.DatePicker;

import java.text.SimpleDateFormat;
import java.util.Date;
import com.google.gwt.event.dom.client.DoubleClickHandler;
import com.google.gwt.event.dom.client.DoubleClickEvent;

public class mainView extends Composite{
	private SimpleDateFormat date = new SimpleDateFormat("MMddyyyyHHmm");
	private DateLabel dateLabel;
	private boolean calWin;				//Keeps track of whether or not the calendar exists on the panel 
    private DatePicker mainDate;		//Calendar widget
    private final LayoutPanel createEventPanel;
    private final LayoutPanel dayEventsPanel;
	public mainView(){
		dateLabel = new DateLabel();
		calWin = false;	
		mainDate = new DatePicker();
		createEventPanel = new LayoutPanel();
		dayEventsPanel = new LayoutPanel();
		final LayoutPanel mainPanel = new LayoutPanel();
		initWidget(mainPanel);
		
		
		
		//Sign out button: signs the user out upon click
		Button signOut = new Button("Sign out");
		signOut.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				ChronosUI.setCurrentView(new LoginView());
			}
		});
		mainPanel.add(signOut);
		mainPanel.setWidgetLeftWidth(signOut, 0.0, Unit.PX, 81.0, Unit.PX);
		mainPanel.setWidgetTopHeight(signOut, 50.0, Unit.PX, 30.0, Unit.PX);
		
		//Create Event button: Upon click, the user will be able to enter information needed in order to make a new event
		Button createEvent = new Button("Create Event");
		mainPanel.add(createEvent);
		mainPanel.setWidgetLeftWidth(createEvent, 0.0, Unit.PX, 81.0, Unit.PX);
		mainPanel.setWidgetTopHeight(createEvent, 87.0, Unit.PX, 30.0, Unit.PX);
		// Displays new panel for create event, closes at click of close or add event to calendar

        createEvent.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
            	if(!createEventPanel.isAttached()){
	                // Code for layout panel when user clicks CreateEvent
	                mainPanel.add(createEventPanel);
	                mainPanel.setWidgetLeftWidth(createEventPanel, 97.0, Unit.PX, 550.0, Unit.PX);
	                mainPanel.setWidgetTopHeight(createEventPanel, 111.0, Unit.PX, 349.0, Unit.PX);
	                
	                //Event name
	                final TextBox eventName = new TextBox();
	                createEventPanel.add(eventName);
	                createEventPanel.setWidgetLeftWidth(eventName, 71.0, Unit.PX, 174.0, Unit.PX);
	                createEventPanel.setWidgetTopHeight(eventName, 46.0, Unit.PX, 31.0, Unit.PX);
	
	                Label eventNamelabel = new Label();
	                eventNamelabel.setText("Title");
	                createEventPanel.add(eventNamelabel);
	                createEventPanel.setWidgetLeftWidth(eventNamelabel, 96.0, Unit.PX, 101.0, Unit.PX);
	                createEventPanel.setWidgetTopHeight(eventNamelabel, 20.0, Unit.PX, 20.0, Unit.PX);
	                
	                //Calendar date picker widget
	                createEventPanel.add(mainDate);
	                createEventPanel.setWidgetLeftWidth(mainDate, 267.0, Unit.PX, 191.0, Unit.PX);
	                createEventPanel.setWidgetTopHeight(mainDate, 68.0, Unit.PX, 191.0, Unit.PX);
	
	                Label datePickerlabel = new Label();
	                datePickerlabel.setText("Select a date");
	                createEventPanel.add(datePickerlabel);
	                createEventPanel.setWidgetLeftWidth(datePickerlabel, 316.0, Unit.PX, 91.0, Unit.PX);
	                createEventPanel.setWidgetTopHeight(datePickerlabel, 42.0, Unit.PX, 20.0, Unit.PX);
	                
	                //Event start time
	                final IntegerBox eventStartTime = new IntegerBox();
	                createEventPanel.add(eventStartTime);
	                createEventPanel.setWidgetLeftWidth(eventStartTime, 71.0, Unit.PX, 111.0, Unit.PX);
	                createEventPanel.setWidgetTopHeight(eventStartTime, 100.0, Unit.PX, 31.0, Unit.PX);
	
	                Label eventStartlabel = new Label();
	                eventStartlabel.setText("Start Time:");
	                createEventPanel.add(eventStartlabel);
	                createEventPanel.setWidgetLeftWidth(eventStartlabel, 5.0, Unit.PX, 60.0, Unit.PX);
	                createEventPanel.setWidgetTopHeight(eventStartlabel, 100.0, Unit.PX, 45.0, Unit.PX);
	                
	                //Event end time
	                final IntegerBox eventEndTime = new IntegerBox();
	                createEventPanel.add(eventEndTime);
	                createEventPanel.setWidgetLeftWidth(eventEndTime, 71.0, Unit.PX, 111.0, Unit.PX);
	                createEventPanel.setWidgetTopHeight(eventEndTime, 150.0, Unit.PX, 31.0, Unit.PX);
	
	                Label eventEndlabel = new Label();
	                eventEndlabel.setText("End Time:");
	                createEventPanel.add(eventEndlabel);
	                createEventPanel.setWidgetLeftWidth(eventEndlabel, 5.0, Unit.PX, 35.0, Unit.PX);
	                createEventPanel.setWidgetTopHeight(eventEndlabel, 146.0, Unit.PX, 45.0, Unit.PX);
	                
	                //Event details
	                final TextArea eventDetails = new TextArea();
	                createEventPanel.add(eventDetails);
	                createEventPanel.setWidgetLeftWidth(eventDetails, 38.0, Unit.PX, 191.0, Unit.PX);
	                createEventPanel.setWidgetTopHeight(eventDetails, 214.0, Unit.PX, 130.0, Unit.PX);
	                
	                Label detailslabel = new Label();
	                detailslabel.setText("Event Description:");
	                createEventPanel.add(detailslabel);
	                createEventPanel.setWidgetLeftWidth(detailslabel, 81.0, Unit.PX, 111.0, Unit.PX);
	                createEventPanel.setWidgetTopHeight(detailslabel, 188.0, Unit.PX, 20.0, Unit.PX);
	
	                // Add Event to Calendar button and ClickHandler
	                Button btnAddEvent = new Button("Add Event");
	                btnAddEvent.setText("Add Event");
	                createEventPanel.add(btnAddEvent);
	                createEventPanel.setWidgetLeftWidth(btnAddEvent, 267.0, Unit.PX, 191.0, Unit.PX);
	                createEventPanel.setWidgetTopHeight(btnAddEvent, 286.0, Unit.PX, 40.0, Unit.PX);
	                
	                btnAddEvent.addClickHandler(new ClickHandler() {
		                @SuppressWarnings("deprecation")
		
		                public void onClick(ClickEvent event) { 
							//Create the event if all fields have been completed
							if(eventName.getValue() != null && mainDate.getValue() != null && eventStartTime.getValue() > 0000 && eventStartTime.getValue() < 2400
									&& eventEndTime.getValue() > 0000 && eventEndTime.getValue() < 2400){
								
								RPC.eventManagementService.createEvent(ChronosUI.userID, eventName.getValue(), mainDate.getValue().getMonth(), mainDate.getValue().getDate(), mainDate.getValue().getYear(),
										eventStartTime.getValue(), eventEndTime.getValue(), eventDetails.getValue(), new AsyncCallback<Void>(){
	
											@Override
											public void onFailure(Throwable caught) {
												GWT.log("RPC call to create event failed: " + caught.getMessage());
												
											}
	
											@Override
											public void onSuccess(Void result) {
												createEventPanel.clear();
												mainPanel.remove(createEventPanel);
												GWT.log("Event created");
											}
									
									
								});
								
							}
							/*else{	//Blank fields exist
								Label error = new Label("Required fields are empty.");
								createEventPanel.add(error);
								createEventPanel.setWidgetLeftWidth(error, 177.0, Unit.PX, 170.0, Unit.PX);
								createEventPanel.setWidgetTopHeight(error, 358.0, Unit.PX, 57.0, Unit.PX);							
							}*/
		                }
		                
	                });   
	
	                // Clears the layout Panel if user decides not to create event
	                Button btnClose = new Button("Close");
	                createEventPanel.add(btnClose);
	                createEventPanel.setWidgetLeftWidth(btnClose, 459.0, Unit.PX, 91.0, Unit.PX);
	                createEventPanel.setWidgetTopHeight(btnClose, 0.0, Unit.PX, 40.0, Unit.PX);
	                btnClose.addClickHandler(new ClickHandler() {
		                public void onClick(ClickEvent event) {
		                	mainPanel.remove(createEventPanel);
		                }
	                });
	            }
	        }});
        
		
		//Calendar button: Displays an actual calendar for the month
		Button btnCalendar = new Button("Calendar");
		mainPanel.add(btnCalendar);
		mainPanel.setWidgetLeftWidth(btnCalendar, 0.0, Unit.PX, 81.0, Unit.PX);
		mainPanel.setWidgetTopHeight(btnCalendar, 123.0, Unit.PX, 30.0, Unit.PX);
		btnCalendar.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
            	if(!createEventPanel.isAttached()){
	            	if(!calWin){
		                // Label to select a date
		                Label lblSelectADate = new Label("Select a date to view events");
		                mainPanel.add(lblSelectADate);
		                mainPanel.setWidgetLeftWidth(lblSelectADate, 110.0, Unit.PX, 175.0, Unit.PX);
		                mainPanel.setWidgetTopHeight(lblSelectADate, 0.0, Unit.PX, 25.0, Unit.PX);
		                
		                //DatePicker for selecting day you want events to be displayed for
		                mainPanel.add(mainDate);
		                mainPanel.setWidgetLeftWidth(mainDate, 110.0, Unit.PX, 191.0, Unit.PX);
		                mainPanel.setWidgetTopHeight(mainDate, 30.0, Unit.PX, 414.0, Unit.PX);
		                
		                //View button - Displays the selected date's list of events
		                Button btnView = new Button("View");
		                mainPanel.add(btnView);
		        		mainPanel.setWidgetLeftWidth(btnView, 220.0, Unit.PX, 81.0, Unit.PX);
		        		mainPanel.setWidgetTopHeight(btnView, 227.0, Unit.PX, 30.0, Unit.PX);
		        		btnView.addDoubleClickHandler(new DoubleClickHandler() {
		        			public void onDoubleClick(DoubleClickEvent event) {
		        				//Create a new panel to display the selected day's events
		        				mainPanel.add(dayEventsPanel);
		        				mainPanel.setWidgetLeftWidth(dayEventsPanel, 87.0, Unit.PX, 324.0, Unit.PX);
		        				mainPanel.setWidgetTopHeight(dayEventsPanel, 50.0, Unit.PX, 384.0, Unit.PX);
		        				
		        				int month = Integer.parseInt(date.format(new Date()).substring(0, 2));
		        				int day = Integer.parseInt(date.format(new Date()).substring(2, 4));
		        				int year = Integer.parseInt(date.format(new Date()).substring(4, 8));
		        				
		        				
		        				RPC.eventManagementService.getDayEvents(ChronosUI.userID, month, day, year, new AsyncCallback<String>(){

									@Override
									public void onFailure(Throwable caught) {
										GWT.log("RPC call to get selected day's events failed: " + caught.getMessage());										
									}

									@Override
									public void onSuccess(String result) {
										final String dayEvents = result;
				        				Label lblListdayevents = new Label(dayEvents);
				        				dayEventsPanel.add(lblListdayevents);
				        				dayEventsPanel.setWidgetLeftWidth(lblListdayevents, 277.0, Unit.PX, 292.0, Unit.PX);
				        				dayEventsPanel.setWidgetTopHeight(lblListdayevents, 50.0, Unit.PX, 437.0, Unit.PX);
									}      					
		        					
		        				});
		        				
		        			}
		        		});
		        		
	            	}
	            	else{
	            		mainPanel.remove(mainDate);
	            	}	            	
	            }
            }

        });
		
		//Display the user's next event details
		mainPanel.add(dateLabel);
		mainPanel.setWidgetLeftWidth(dateLabel, 580.0, Unit.PX, 64.0, Unit.PX);
		mainPanel.setWidgetTopHeight(dateLabel, 0.0, Unit.PX, 18.0, Unit.PX);
		
		
		
		
		
		
		
		int month = Integer.parseInt(date.format(new Date()).substring(0, 2));
		int day = Integer.parseInt(date.format(new Date()).substring(2, 4));
		int year = Integer.parseInt(date.format(new Date()).substring(4, 8));
		int hour = Integer.parseInt(date.format(new Date()).substring(8, 10));
		int min = Integer.parseInt(date.format(new Date()).substring(10, 12));
		RPC.eventManagementService.nextEventString(ChronosUI.user, month, day, year, hour, min, new AsyncCallback<String>(){
			@Override
			public void onFailure(Throwable caught) {
				GWT.log("Account's next event retrieval failed: " + caught.getMessage());				
			}
			@Override
			public void onSuccess(String result) {
				Label lblNextevent = new Label(result);
				mainPanel.add(lblNextevent);
				mainPanel.setWidgetLeftWidth(lblNextevent, 144.0, Unit.PX, 320.0, Unit.PX);
				mainPanel.setWidgetTopHeight(lblNextevent, 50.0, Unit.PX, 41.0, Unit.PX);				
			}
		});
	}
}
