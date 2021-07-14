package controllers;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import beans.User;
import business.MyTimerService;
import business.SensorBusinessInterface;

@SuppressWarnings("deprecation")
@ManagedBean
public class FormController {
	
	
	SensorBusinessInterface service;
	
	@EJB
	MyTimerService timer;

	public String onSubmit() {
		
		// gets the user vales from the important form
		FacesContext context = FacesContext.getCurrentInstance();
		User user = context.getApplication().evaluateExpressionGet(context, "#{user}", User.class);
		
		
		// start a timer when the login is clicked
		timer.setTimer(10000);
		
		
		// Puts the user object in to the POST request
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("user", user);
		
		return "Response.xhtml";
	}
	
	
}
