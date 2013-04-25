package edu.ycp.cs320.chronos.client;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.TextBox;

import edu.ycp.cs320.chronos.shared.Account;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;

public class mainView extends Composite{
	private String nxtEvent;
	public mainView(){
		final LayoutPanel mainPanel = new LayoutPanel();
		
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
		
		//Displays the user's upcoming event information
		
		Label nextEvent = new Label();
		mainPanel.add(nextEvent);
		mainPanel.setWidgetLeftWidth(nextEvent, 113.0, Unit.PX, 372.0, Unit.PX);
		mainPanel.setWidgetTopHeight(nextEvent, 50.0, Unit.PX, 57.0, Unit.PX);
		
		
		
		//Layout panel for creating a new event
		//This layout panel is intended to pop up on top of the mainView
		//Must add this part to the onClickhandler under Create Event
		LayoutPanel createEventPanel = new LayoutPanel();
		mainPanel.add(createEventPanel);
		mainPanel.setWidgetLeftWidth(createEventPanel, 87.0, Unit.PX, 481.0, Unit.PX);
		mainPanel.setWidgetTopHeight(createEventPanel, 73.0, Unit.PX, 328.0, Unit.PX);
		
		
		initWidget(mainPanel);
	}
}
