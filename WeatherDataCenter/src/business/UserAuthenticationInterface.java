package business;

import java.util.List;

import javax.ejb.Local;
import javax.inject.Named;

import beans.User;

@Local
@Named
public interface UserAuthenticationInterface {

	public List<User> getUserList();
	
	public User getUser(String email);
	
	public void addUser(User newUser);
	
	public boolean checkDuplicateUsername(String username);
	
	public boolean checkDuplicateEmail(String email);
	
	public boolean validateLogin(String email, String password);
}
