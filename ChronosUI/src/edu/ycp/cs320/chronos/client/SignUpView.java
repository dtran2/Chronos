package edu.ycp.cs320.chronos.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;


public class SignUpView extends Composite {
	private TextBox userNamesignup;
	private PasswordTextBox passwordsignup;
	private TextBox emailsignup;
	//private String emailtext;
	//private String userNametext;
	//private String passwordtext;
	//String emailText;
	public SignUpView(){
		
	final LayoutPanel signUpPanel = new LayoutPanel();
	initWidget(signUpPanel);
	signUpPanel.setSize("590px", "415px");
	
	// Location of userName text box and label
		Label lblUsername = new Label("Username");
		signUpPanel.add(lblUsername);
		signUpPanel.setWidgetLeftWidth(lblUsername, 86.0, Unit.PX, 83.0, Unit.PX);
		signUpPanel.setWidgetTopHeight(lblUsername, 49.0, Unit.PX, 33.0, Unit.PX);
	
		userNamesignup = new TextBox();
		signUpPanel.add(userNamesignup);
		signUpPanel.setWidgetLeftWidth(userNamesignup, 175.0, Unit.PX, 182.0, Unit.PX);
		signUpPanel.setWidgetTopHeight(userNamesignup, 49.0, Unit.PX, 33.0, Unit.PX);
		//userNametext = userNamesignup.getText();
			
	// Location of password text box and label
		Label lblPassword = new Label("Password");
		signUpPanel.add(lblPassword);
		signUpPanel.setWidgetLeftWidth(lblPassword, 86.0, Unit.PX, 83.0, Unit.PX);
		signUpPanel.setWidgetTopHeight(lblPassword, 88.0, Unit.PX, 33.0, Unit.PX);
		
		passwordsignup = new PasswordTextBox();
		signUpPanel.add(passwordsignup);
		signUpPanel.setWidgetLeftWidth(passwordsignup, 175.0, Unit.PX, 182.0, Unit.PX);
		signUpPanel.setWidgetTopHeight(passwordsignup, 88.0, Unit.PX, 33.0, Unit.PX);
		//passwordtext = passwordsignup.getText();
		
	// Location of email text box and label
		Label lblEmail = new Label("E-mail");
		signUpPanel.add(lblEmail);
		signUpPanel.setWidgetLeftWidth(lblEmail, 86.0, Unit.PX, 83.0, Unit.PX);
		signUpPanel.setWidgetTopHeight(lblEmail, 127.0, Unit.PX, 33.0, Unit.PX);
		
		emailsignup = new TextBox();
		signUpPanel.add(emailsignup);
		signUpPanel.setWidgetLeftWidth(emailsignup, 175.0, Unit.PX, 182.0, Unit.PX);
		signUpPanel.setWidgetTopHeight(emailsignup, 127.0, Unit.PX, 33.0, Unit.PX);
		//emailText = emailsignup.getText();
		
		//Sign up button
		Button signUp = new Button("Sign up!");
		//Click handler: Add the new account to the database
		//Send the user back to sign in panel to sign in to their new account
		signUp.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				//TODO: Add the account to the key found in FakeDatabase
				RPC.accountManagementService.createAccount(userNamesignup.getText(), passwordsignup.getText(), emailsignup.getText(), new AsyncCallback<Void>() {
					@Override
					public void onFailure(Throwable caught) {
						GWT.log("RPC call to create account failed: ", caught);
					}

					@Override
					public void onSuccess(Void result) {
						//The new account has been added to the database
						//Direct the user to the login view to login with their newly created account
						GWT.log("Account added to database");
						ChronosUI.setCurrentView(new LoginView());
						//TODO: User cannot login with newly created account from the loginView, must fix
					}
				});
			}
		});
				
		signUpPanel.add(signUp);
		signUpPanel.setWidgetLeftWidth(signUp, 276.0, Unit.PX, 81.0, Unit.PX);
		signUpPanel.setWidgetTopHeight(signUp, 166.0, Unit.PX, 30.0, Unit.PX);
		//emailtext = emailsignup.getText();
				
	}

}
