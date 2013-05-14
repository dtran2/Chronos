package edu.ycp.cs320.chronos.client;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DateLabel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment.HorizontalAlignmentConstant;
import com.google.gwt.user.client.ui.IntegerBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.datepicker.client.DatePicker;
import com.google.gwt.user.client.ui.HTML;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import com.google.gwt.event.dom.client.DoubleClickHandler;
import com.google.gwt.event.dom.client.DoubleClickEvent;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;

public class mainView extends Composite{
	private DateTimeFormat date;
	private LayoutPanel dayEventsPanel;
	private DateLabel dateLabel;
	private boolean calWin;				//Keeps track of whether or not the calendar exists on the panel 
    private final LayoutPanel createEventPanel;
    private boolean dayEventsWin;
	public mainView(){
		date = DateTimeFormat.getFormat("MMddyyyyHHmm");
		dayEventsWin = false;
		dayEventsPanel = new LayoutPanel();
		dateLabel = new DateLabel();
		calWin = false;
		createEventPanel = new LayoutPanel();
		final LayoutPanel mainPanel = new LayoutPanel();
		initWidget(mainPanel);		
		//DEBUGGING ONLY AREA///////////////
		/**
		 * Event created panel
		 *//*
		LayoutPanel eventCreated = new LayoutPanel();
		mainPanel.add(eventCreated);
		mainPanel.setWidgetLeftWidth(eventCreated, 187.0, Unit.PX, 270.0, Unit.PX);
		mainPanel.setWidgetTopHeight(eventCreated, 172.0, Unit.PX, 57.0, Unit.PX);
		
		Label lblEventCreated = new Label("Event Created!");
		lblEventCreated.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		eventCreated.add(lblEventCreated);
		eventCreated.setWidgetLeftWidth(lblEventCreated, 0.0, Unit.PX, 270.0, Unit.PX);
		eventCreated.setWidgetTopHeight(lblEventCreated, 0.0, Unit.PX, 52.0, Unit.PX);
		
		Button closeEventCreated = new Button("Close");
		eventCreated.add(closeEventCreated);
		eventCreated.setWidgetLeftWidth(closeEventCreated, 189.0, Unit.PX, 81.0, Unit.PX);
		eventCreated.setWidgetTopHeight(closeEventCreated, 24.0, Unit.PX, 30.0, Unit.PX);*/
        
       /* //Layout panel for list of selected day's events
        final LayoutPanel dayEventsPanel = new LayoutPanel();
		mainPanel.add(dayEventsPanel);
		mainPanel.setWidgetLeftWidth(dayEventsPanel, 0.0, Unit.PX, 467.0, Unit.PX);
		mainPanel.setWidgetTopHeight(dayEventsPanel, 86.0, Unit.PX, 401.0, Unit.PX);
		
        ListBox listBox_1_1 = new ListBox();
        dayEventsPanel.add(listBox_1_1);
        dayEventsPanel.setWidgetLeftWidth(listBox_1_1, 236.0, Unit.PX, 220.0, Unit.PX);
        dayEventsPanel.setWidgetTopHeight(listBox_1_1, 27.0, Unit.PX, 369.0, Unit.PX);
        listBox_1_1.setVisibleItemCount(5);
		
		Button btnX_1 = new Button("X");
		dayEventsPanel.add(btnX_1);
		dayEventsPanel.setWidgetLeftWidth(btnX_1, 203.0, Unit.PX, 27.0, Unit.PX);
		dayEventsPanel.setWidgetTopHeight(btnX_1, 169.0, Unit.PX, 30.0, Unit.PX);
		
        Button btnView = new Button("View");
        dayEventsPanel.add(btnView);
        dayEventsPanel.setWidgetLeftWidth(btnView, 121.0, Unit.PX, 81.0, Unit.PX);
        dayEventsPanel.setWidgetTopHeight(btnView, 366.0, Unit.PX, 30.0, Unit.PX);
        
        DatePicker mainDate = new DatePicker();
        dayEventsPanel.add(mainDate);
        dayEventsPanel.setWidgetLeftWidth(mainDate, 11.0, Unit.PX, 230.0, Unit.PX);
        dayEventsPanel.setWidgetTopHeight(mainDate, 169.0, Unit.PX, 235.0, Unit.PX);*/
		
		////////////////////////////////////////////////////
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
///////////////////////////////////////////////////////////////////Create Event///////////////////////////////////////////////////////////////////////////
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
	                final DatePicker dp = new DatePicker();
	                createEventPanel.add(dp);
	                createEventPanel.setWidgetLeftWidth(dp, 267.0, Unit.PX, 191.0, Unit.PX);
	                createEventPanel.setWidgetTopHeight(dp, 68.0, Unit.PX, 191.0, Unit.PX);
	
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
							if(eventName.getValue() != null && dp.getValue() != null && eventStartTime.getValue() > 0000 && eventStartTime.getValue() < 2400
									&& eventEndTime.getValue() > 0000 && eventEndTime.getValue() < 2400){
								
								RPC.eventManagementService.createEvent(ChronosUI.userID, eventName.getValue(), dp.getValue().getMonth(), dp.getValue().getDate(), dp.getValue().getYear(),
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
												//Remove the createEventPanel and notify the user of the successful event creation
												mainPanel.remove(createEventPanel);
								                //Notify the user of the newly created event
								                /**
								        		 * Event created panel
								        		 */
								        		final LayoutPanel eventCreated = new LayoutPanel();
								        		mainPanel.add(eventCreated);
								        		mainPanel.setWidgetLeftWidth(eventCreated, 187.0, Unit.PX, 270.0, Unit.PX);
								        		mainPanel.setWidgetTopHeight(eventCreated, 172.0, Unit.PX, 57.0, Unit.PX);
								        		
								        		Label lblEventCreated = new Label("Event Created!");
								        		lblEventCreated.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
								        		eventCreated.add(lblEventCreated);
								        		eventCreated.setWidgetLeftWidth(lblEventCreated, 0.0, Unit.PX, 270.0, Unit.PX);
								        		eventCreated.setWidgetTopHeight(lblEventCreated, 0.0, Unit.PX, 52.0, Unit.PX);
								        		
								        		Button closeEventCreated = new Button("Close");
								        		eventCreated.add(closeEventCreated);
								        		eventCreated.setWidgetLeftWidth(closeEventCreated, 189.0, Unit.PX, 81.0, Unit.PX);
								        		eventCreated.setWidgetTopHeight(closeEventCreated, 24.0, Unit.PX, 30.0, Unit.PX);
								        		closeEventCreated.addClickHandler(new ClickHandler() {
													@Override
													public void onClick(ClickEvent event) {
														mainPanel.remove(eventCreated);
													}
								        		});
											}							
									
								});
								
							}
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
        
//////////////////////////////////////////////////////////////////////CALENDAR BUTTON/////////////////////////////////////////////////////////////////////////////////
		/*
		 * Panel containing a calendar widget
		 * Upon selecting date and clicking on view, the client will display
		 * a list of even titles in sequential order for the given date
		 */
		Button btnCalendar = new Button("Calendar");
		mainPanel.add(btnCalendar);
		mainPanel.setWidgetLeftWidth(btnCalendar, 0.0, Unit.PX, 81.0, Unit.PX);
		mainPanel.setWidgetTopHeight(btnCalendar, 123.0, Unit.PX, 30.0, Unit.PX);
		btnCalendar.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
            	if(!dayEventsWin){
            		dayEventsWin = true;
	        		 //Layout panel for list of selected day's events
	                final LayoutPanel dayEventsPanel = new LayoutPanel();
	        		mainPanel.add(dayEventsPanel);
	        		mainPanel.setWidgetLeftWidth(dayEventsPanel, 0.0, Unit.PX, 467.0, Unit.PX);
	        		mainPanel.setWidgetTopHeight(dayEventsPanel, 86.0, Unit.PX, 401.0, Unit.PX);
	        		
	        		
					//Calendar widget
	        		final DatePicker mainDate = new DatePicker();
	        		dayEventsPanel.add(mainDate);
	        		dayEventsPanel.setWidgetLeftWidth(mainDate, 0.0, Unit.PX, 191.0, Unit.PX);
	        		dayEventsPanel.setWidgetTopHeight(mainDate, 169.0, Unit.PX, 414.0, Unit.PX);
	        		
	        		Button btnX = new Button("X");
	        		dayEventsPanel.add(btnX);
	        		dayEventsPanel.setWidgetLeftWidth(btnX, 409.0, Unit.PX, 27.0, Unit.PX);
	        		dayEventsPanel.setWidgetTopHeight(btnX, 0.0, Unit.PX, 30.0, Unit.PX);
	        		
	        		btnX.addClickHandler(new ClickHandler() {								
						public void onClick(ClickEvent event) {
							mainPanel.remove(dayEventsPanel);
						}										
							
					});
	        		
	                Button btnView = new Button("View");
	                dayEventsPanel.add(btnView);
	                dayEventsPanel.setWidgetLeftWidth(btnView, 110.0, Unit.PX, 81.0, Unit.PX);
	                dayEventsPanel.setWidgetTopHeight(btnView, 366.0, Unit.PX, 30.0, Unit.PX);
	                //Click handler for the view button
	        		btnView.addClickHandler(new ClickHandler() {
						@SuppressWarnings("deprecation")
						@Override
						public void onClick(ClickEvent event) {
	        				RPC.eventManagementService.getDayString(ChronosUI.userID, mainDate.getValue().getMonth(), mainDate.getValue().getDate(),
	        						mainDate.getValue().getYear(), new AsyncCallback<ArrayList<String>>(){
	
								@Override
								public void onFailure(Throwable caught) {
									System.out.println("RPC call to getDayString failed: " + caught.getMessage());									
								}	
								@Override
								public void onSuccess(ArrayList<String> result) {
									//Display a list of events for the selected date
									//"No events" will be the only value inside of the array if the user does not have events for that day, so it shouldn't ever be null
									//List of selected date's events
					                ListBox listBox = new ListBox();
					                dayEventsPanel.add(listBox);
					                dayEventsPanel.setWidgetLeftWidth(listBox, 190.0, Unit.PX, 220.0, Unit.PX);
					                dayEventsPanel.setWidgetTopHeight(listBox, 0.0, Unit.PX, 369.0, Unit.PX);
					                listBox.setVisibleItemCount(5);
					                //Add event titles to the box
					                for(int i = 0; i < result.size(); i++){
					                	listBox.addItem(result.get(i));
					                }				                					                
								}	        					
	        				});
						}
	        		});
	        		
	        	}
	        	else{
	        		//Remove dayEventsPanel
	        		mainPanel.remove(dayEventsPanel);
	        		dayEventsWin = false;
	        	}
            }

        });
		
		//Display the user's next event details
		mainPanel.setWidgetLeftWidth(dateLabel, 580.0, Unit.PX, 64.0, Unit.PX);
		mainPanel.setWidgetTopHeight(dateLabel, 0.0, Unit.PX, 18.0, Unit.PX);
		
		
		int month = Integer.parseInt(date.format(new Date()).substring(0, 2));
		int day = Integer.parseInt(date.format(new Date()).toString().substring(2, 4));
		int year = Integer.parseInt(date.format(new Date()).toString().substring(4, 8));
		int hour = Integer.parseInt(date.format(new Date()).toString().substring(8, 10));
		int min = Integer.parseInt(date.format(new Date()).toString().substring(10, 12));
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

