package edu.ycp.cs320.chronos.client;

import com.google.gwt.core.client.GWT;

public class RPC {
	
	
	public static final AccountManagementServiceAsync accountManagementService =
			(AccountManagementServiceAsync)GWT.create(AccountManagementService.class);
	
	public static final EventManagementServiceAsync eventManagementService =
			(EventManagementServiceAsync)GWT.create(EventManagementService.class);
			
}

