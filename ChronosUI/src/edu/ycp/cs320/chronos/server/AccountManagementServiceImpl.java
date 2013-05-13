package edu.ycp.cs320.chronos.server;


import java.sql.SQLException;

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
		//try {
			return DatabaseUtil.instance().verifyAccount(username, password);
		/*} 
		catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
			e.printStackTrace();
		}	*/	
		//return false;
	}
	
	/**
	 * Uses the entered username, password, and email to create a new 
		 * @param usr	The specified username the user would like to use
	 					as their alias.
	 * @param password	The entered password will be compared to the
	 * 					account information using the 
	 * @param email		The email the user would like to link with the account.
	 */
	public void createAccount(String usr, String password, String email) {
		System.out.println("creating account: usr=" + usr + ", pass=" + password + ", email=" + email);
		//try {
			DatabaseUtil.instance().createAccount(usr, password, email);
		/*} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
			e.printStackTrace();
		}*/
	}
	/**
	 * Removes the specified account from the database
	 * @param account
	 */
	public void removeAccount(int accountID) {
		//try {
			DatabaseUtil.instance().removeAccount(accountID);
		/*} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
			e.printStackTrace();
		}	*/
	}
	
	public int getUserID(String username) {
		//try {
			return DatabaseUtil.instance().getAccount(username).getID();
		/*} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
			e.printStackTrace();
		}
		return 0;*/
	}
	
	


}
