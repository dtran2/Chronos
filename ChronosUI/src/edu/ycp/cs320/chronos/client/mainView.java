package edu.ycp.cs320.chronos.client;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DateLabel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.LayoutPanel;

import java.text.SimpleDateFormat;
import java.util.Date;

public class mainView extends Composite{
	//private long time;
	public mainView(){
		//time = 0;
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
		
		//Calendar button: Displays an actual calendar for the month
		Button btnCalendar = new Button("Calendar");
		mainPanel.add(btnCalendar);
		mainPanel.setWidgetLeftWidth(btnCalendar, 0.0, Unit.PX, 81.0, Unit.PX);
		mainPanel.setWidgetTopHeight(btnCalendar, 123.0, Unit.PX, 30.0, Unit.PX);
		
		DateLabel dateLabel = new DateLabel();
		mainPanel.add(dateLabel);
		mainPanel.setWidgetLeftWidth(dateLabel, 580.0, Unit.PX, 64.0, Unit.PX);
		mainPanel.setWidgetTopHeight(dateLabel, 0.0, Unit.PX, 18.0, Unit.PX);
		
		SimpleDateFormat date = new SimpleDateFormat("MMddyyyyHHmm");
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
