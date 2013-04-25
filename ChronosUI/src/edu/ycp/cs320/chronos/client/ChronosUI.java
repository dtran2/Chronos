package edu.ycp.cs320.chronos.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.RootLayoutPanel;


public class ChronosUI implements EntryPoint{

	public static ChronosUI instance;
	private static IsWidget currentView;
	
	@SuppressWarnings("deprecation")
	@Override
	
	public void onModuleLoad() {
		GWT.log("Reached entry point!");
		
		RootLayoutPanel.get().setStyleName("makeitred", true);
		
		instance = this;
		
		setCurrentView(new LoginView());
		
		
	}
	
	public static void setCurrentView(IsWidget cv) {
		if (currentView != null) {
			RootLayoutPanel.get().remove(currentView);
		}
		currentView = cv;
		RootLayoutPanel.get().add(cv);
		RootLayoutPanel.get().setWidgetTopBottom(cv, 10.0, Unit.PX, 10.0, Unit.PX);
		RootLayoutPanel.get().setWidgetLeftRight(cv, 10.0, Unit.PX, 10.0, Unit.PX);
		GWT.log("Set current view: " + cv.getClass().getName());
	}
	
}


