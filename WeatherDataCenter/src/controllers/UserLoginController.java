package controllers;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import beans.User;
import business.UserAuthenticationInterface;

@SuppressWarnings("deprecation")
@Named
@ViewScoped
public class UserLoginController implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -6510937400108973938L;
	@Inject
    private UserAuthenticationInterface auth;
   
	public String onSubmit(User user) {
		FacesContext fc = FacesContext.getCurrentInstance();
		if(auth.validateLogin(user.getEmail(), user.getPassword())) {
			user = auth.getUser(user.getEmail());
			fc.getExternalContext().getSessionMap().put("sessionUser", user);
			fc.addMessage("index", new FacesMessage("You have been logged in as " + user.getUsername() + "!"));
			
			// Successful login redirects to index page
			return "index.xhtml";
		} else {
			fc.addMessage("loginForm:password", new FacesMessage("That email and password combination is invalid."));
		}
		// Go back to login if unsuccessful
		return "login.xhtml";
	}
	
	public String onLogout() {
		FacesContext fc = FacesContext.getCurrentInstance();
		fc.getExternalContext().invalidateSession();
		fc.addMessage("index", new FacesMessage("You have been logged out!"));
		return "index?faces-redirect=true";
	}
}
