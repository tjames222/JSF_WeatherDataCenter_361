package beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@SuppressWarnings("deprecation")
@ManagedBean(name="userAuthentication", eager=true)
@ApplicationScoped
public class UserAuthentication {
	
	private List<User> userList;
	
	public UserAuthentication() {
		userList = new ArrayList<>();
	}
	
	public void addUser(User user) {
		userList.add(user);
	}
	
	public boolean validateLogin(String email, String password) {
		boolean permission = false;
		for (User u : userList) {
			if (u.getEmail().equals(email) && u.getPassword().equals(password))
				permission = true;
		}
		
		return permission;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
}
