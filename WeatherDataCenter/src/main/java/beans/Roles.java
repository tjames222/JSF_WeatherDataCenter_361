package beans;

public class Roles {

	////////// Properties
	private int roleId;
	private String roleName;
	private String roleDescription;
	private int accessLevel;
	
	////////// Constructors
	public Roles() {
		super();
	}
	
	public Roles(int roleId, String roleName, String roleDescription, int accessLevel) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		this.roleDescription = roleDescription;
		this.accessLevel = accessLevel;
	}
	
	////////// Methods
	public void setRole(User user, int level) {
		accessLevel = level;
		// Logic to tie user to the role
	}
	

	////////// Getters and Setters
	public int getRoleId() {
		return roleId;
	}
	
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getRoleDescription() {
		return roleDescription;
	}
	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}
	public int getAccessLevel() {
		return accessLevel;
	}
	public void setAccessLevel(int accessLevel) {
		this.accessLevel = accessLevel;
	}
	
	////////// ToString() Method
	@Override
	public String toString() {
		return "Roles [roleId=" + roleId + ", roleName=" + roleName + ", roleDescription=" + roleDescription
				+ ", accessLevel=" + accessLevel + "]";
	}
}
