package controllers;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

import beans.User;
import business.UserAuthenticationInterface;

@SuppressWarnings("deprecation")
@ManagedBean(name="registrationFormController")
@ViewScoped
public class UserRegistrationController implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	UserAuthenticationInterface users;
	
	public String onSubmit(User newUser) {
		FacesContext fc = FacesContext.getCurrentInstance();

		//check for duplicate user name and email before entering into database
		if(checkDuplicateUser(fc, newUser)) {
			// add the user back to the request before we return to the registration page
			fc.getExternalContext().getRequestMap().put("user", newUser);
			//failed, return to registration page
			return ("register.xhtml");
		}
		
		//add the user
		users.addUser(newUser);
		
		// on success go immediately to login
		return ("login.xhtml");
	}
	
	private boolean checkDuplicateUser(FacesContext fc, User newUser) {
		boolean result = false;
		
		//check for duplicate userName
		if (users.checkDuplicateUsername(newUser.getUsername())) {
			// add the error message to the page "registrationForm:userName" needs to be the
			// id of the form and the id of the userName field
			fc.addMessage("registrationForm:userName", new FacesMessage("That Username has already been taken!"));
			// Duplicate was found
			result = true;
		}
		
		// check for duplicate email
		if (users.checkDuplicateEmail(newUser.getEmail())) {
			// add the error message to the page "registrationForm:email" needs to be the id
			// of the form and the id of the email field
			fc.addMessage("registrationForm:email", new FacesMessage("That Email is being used by another person!"));
			// Duplicate was found
			result = true;
		}
		
		return result;
	}
	
}
