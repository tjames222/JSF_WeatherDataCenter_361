package dataAccess;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.Sensors;

public class DataWeatherService implements SensorDaoInterface{

	// Connect
	
	
	public DataWeatherService() {
	
	}

	@Override
	public List<Sensors> getAllSensorData(Sensors record) {
		
		Connection conn = null;
		String url = "jdbc:mysql://webdisk.clc361gp.heliohost.us/clc361gp_clc361_group";
		String username = "clc361gp_group";
		String password = "Group_CLC361";
		
		String sql = "SELECT * FROM Sensors";
		
		List<Sensors> myList = new ArrayList<Sensors>();
		
		try {
			
			conn = DriverManager.getConnection(url, username, password);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				myList.add(new Sensors(rs.getInt("Sensor_ID"),
						rs.getString("DTStamp"), rs.getInt("Temperature"),
						rs.getInt("Humidity"), rs.getFloat("Pressure"), 
						rs.getInt("Altitude"), rs.getString("GPSLat")));
			}
			
			rs.close();
		}
		catch (SQLException e){
			System.out.println("FAILED TO EXECUTE QUERY");
			System.out.println(e);
			e.printStackTrace();
		}
		finally {
			if(conn != null) {
				try {
					conn.close();
					return myList;
				}
				catch (SQLException e){
					e.printStackTrace();
					return null;
				}
			}
		}
		return null;
		
	}
	
	
	
}


