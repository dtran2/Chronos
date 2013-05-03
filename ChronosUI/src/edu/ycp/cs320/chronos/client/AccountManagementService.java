package edu.ycp.cs320.chronos.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

//import edu.ycp.cs320.chronos.server.DatabaseUtil;

@RemoteServiceRelativePath("accountManagement")
public interface AccountManagementService extends RemoteService {
	public boolean verifyAccount(String username, String password); 
	public void createAccount(String usr, String password, String email);
	public void removeAccount(int accountID);
	public int getUserID(String username);
	
}
