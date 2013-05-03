package edu.ycp.cs320.chronos.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import edu.ycp.cs320.chronos.client.AccountManagementService;

/**
 * RemoteService that allows the user to access account
 * information found on the database
 * @author dtran2
 *
 */
public class AccountManagementServiceImpl extends RemoteServiceServlet
		implements AccountManagementService {
	private static final long serialVersionUID = 1L;
	
	@Override
	/**
	 * Takes the given username and password
	 * Returns true if the account exists and the username and password match
	 */
	public boolean verifyAccount(String username, String password) {
		if(username != null && password != null){
			return DatabaseUtil.instance().verifyAccount(username, password);
		}
		return false;
	}
	
	/**
	 * Uses the entered username, password, and email to create a new 
		 * @param usr	The specified username the user would like to use
	 					as their alias.
	 * @param password	The entered password will be compared to the
	 * 					account information using the 
	 * @param email		The email the user would like to link with the account.
	 */
	
	public void createAccount(String usr, String password, String email){
		System.out.println("creating account: usr=" + usr + ", pass=" + password + ", email=" + email);
		DatabaseUtil.instance().createAccount(usr, password, email);
	}
	/**
	 * Removes the specified account from the database
	 * @param account
	 */
	public void removeAccount(int accountID){
		DatabaseUtil.instance().removeAccount(accountID);	
	}
	
	public int getUserID(String username){
		return DatabaseUtil.instance().getAccount(username).getID();
	}
	
	


}
