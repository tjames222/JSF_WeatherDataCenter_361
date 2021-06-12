package beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@SuppressWarnings("deprecation")
@ManagedBean(name="user")
@ViewScoped
public class User implements Serializable {
	

	private static final long serialVersionUID = 1L;
	////////// Properties
	@NotNull()
	@Size(min=5, max=50)
	private String firstName;
	@NotNull()
	@Size(min=5, max=50)
	private String lastName;
	@NotNull()
	@Size(min=5, max=50)
	private String username;
	@NotNull()
	@Size(min=5, max=50)
	private String password;
	@NotNull()
	@Size(min=5, max=50)
	private String email;
	
	///////// Constructors
	public User() {
		this.firstName = "";
		this.lastName = "";
		this.username = "";
		this.password = "";
		this.email = "";
	}
	
	public User(String fName, String lName, String uName, String pass, String email) {
		this.firstName = fName;
		this.lastName = lName;
		this.username = uName;
		this.password = pass;
		this.email = email;
	}

	////////// Getters and Setters
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	////////// ToString() method
	@Override
	public String toString() {
		return "User [userId=" + ", firstName=" + firstName + ", lastName=" + lastName + ", username="
				+ username + ", password=" + password + ", email=" + email + "]";
	}
}
