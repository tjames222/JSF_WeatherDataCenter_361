package model;

import javax.validation.constraints.Min;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class User
{
	@NotNull(message="First name cannot be null.")
    @Size(min=2, max=30, message="First name must be between 2 and 30 characters.")
	private String firstName;
    
	@NotNull(message="Last name cannot be null.")
    @Size(min=2, max=30, message="Last name must be between 2 and 30 characters.")
	private String lastName;
    
	@NotNull(message="Username cannot be null.")
    @Size(min=8, max=32, message="Username must be between 8 and 32 characters.")
	private String username;
	
	@NotNull(message="Password cannot be null.")
    @Size(min=8, max=32, message="Password must be between 8 and 32 characters.")
	private String password;
	
	@NotNull(message="Email cannot be null.")
    @Size(min=8, max=64, message="E-Mail must be between 8 and 364 characters.")
	private String email;
	

	public User()
	{
		firstName = "";
		lastName = "";
	}
	public User(String firstName, String lastName)
	{
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public String getFirstName()
	{
		return firstName;
	}
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}
	
	public String getLastName()
	{
		return lastName;
	}
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}
	
}
