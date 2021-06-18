package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import javax.ejb.Local;

@Local
public interface TimDataAccessInterface<T> {
	
	public static final String dbURL = "jdbc:mysql://webdisk.clc361gp.heliohost.us/clc361gp_clc361_group"; 
	public static final String username = "clc361gp_java"; 
	public static final String password = "Group_CLC361"; 
			
	/**
	 * retrieves a connection to the current database
	 * @return the given connection to use for the dao methods, must be closed manually outside of this method.
	 */
	public static Connection getConnection() {
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection(dbURL, username, password);
			System.out.println("Connection Made!");
		}
		catch(SQLException ex) {
			System.out.println("Failure! " + ex.getMessage());
		}
		return conn;
	}
	
	// CRUD pattern methods
	public T get(String id);
	List<T> getAll();
	void save(T t);
	void update(String id, T t);
	void delete(T t);
}
