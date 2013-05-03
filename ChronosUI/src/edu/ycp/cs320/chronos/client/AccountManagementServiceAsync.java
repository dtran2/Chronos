package edu.ycp.cs320.chronos.client;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface AccountManagementServiceAsync {

	void verifyAccount(String username, String password,
			AsyncCallback<Boolean> callback);

	void createAccount(String usr, String password, String email,
			AsyncCallback<Void> callback);

	void removeAccount(int accountID, AsyncCallback<Void> callback);

	void getUserID(String username, AsyncCallback<Integer> callback);

}
