package edu.ycp.cs320.chronos.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("accountManagement")
public interface AccountManagementService extends RemoteService {
	public boolean verifyAccount(String username, String password);
}