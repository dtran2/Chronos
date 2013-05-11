package edu.ycp.cs320.chronos.client;

import java.sql.SQLException;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

//import edu.ycp.cs320.chronos.server.DatabaseUtil;

@RemoteServiceRelativePath("accountManagement")
public interface AccountManagementService extends RemoteService {
	public boolean verifyAccount(String username, String password) throws SQLException; 
	public void createAccount(String usr, String password, String email) throws SQLException;
	public void removeAccount(int accountID) throws SQLException;
	public int getUserID(String username) throws SQLException;
	
}
