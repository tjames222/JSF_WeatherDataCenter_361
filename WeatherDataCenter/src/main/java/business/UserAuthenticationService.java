package business;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.LocalBean;
//import javax.ejb.Stateful;
//import javax.ejb.Stateless;

import beans.User;
import dao.UserDataAccessInterface;

//@Stateful
@Local(UserAuthenticationInterface.class)
@LocalBean
public class UserAuthenticationService implements UserAuthenticationInterface {


	private UserDataAccessInterface<User> dao;
	    
	////////// Default constructor.  
    public UserAuthenticationService() {

    }

    @Override
    public List<User> getUserList() {
        return dao.getAll();
    }
    
    @Override
    public User getUser(String email) {
    	return dao.get(email);
    }
    
    @Override
    public boolean checkDuplicateUsername(String username) {
    	for(User u : this.getUserList()) {
    		if(u.getUsername().equals(username)) {
    			return true;
    		}
    	}
    	return false;
    }
    
    @Override
    public boolean checkDuplicateEmail(String email) {
    	for(User u : this.getUserList()) {
    		if(u.getEmail().equals(email)) {
    			return true;
    		}
    	}
    	return false;
    }
	
    @Override
    public void addUser(User newUser) {
        dao.save(newUser);
    }

	@Override
	public boolean validateLogin(String email, String password) {
		boolean loginVerified = false;
		for (User u : this.getUserList()) {
			if (u.getEmail().equalsIgnoreCase(email)) {
				if (u.getPassword().equals(password))
					loginVerified = true;
			}
		}
		return loginVerified;
	}
}
