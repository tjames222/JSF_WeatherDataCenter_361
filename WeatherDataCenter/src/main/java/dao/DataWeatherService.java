package dao;

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
		Sensors sensorData = new Sensors();
		List<Sensors> myList = new ArrayList<Sensors>();
		
		try {
			
			conn = DriverManager.getConnection(url, username, password);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()){
		        int id = rs.getInt("Sensor_ID");
		        sensorData.dtStamp = rs.getString("DTStamp");
		        sensorData.temperature = rs.getString("Temperature");
		        sensorData.humidity = rs.getString("Humidity");
		        sensorData.pressure = rs.getString("Pressure");
		        sensorData.altitude = rs.getString("Altitude");
		        sensorData.gpsTimeStamp = rs.getString("GPSTimeStamp");
		        sensorData.gpsLat = rs.getString("GPSLat");
		        sensorData.gpsLatDir = rs.getString("GPSLatDir");
		        sensorData.gpsLong = rs.getString("GPSLong");
		        sensorData.gpsLongDir = rs.getString("GPSLongDir");
		        sensorData.gpsAltitude = rs.getString("GPSAltitude");
		        sensorData.gpsNumSat = rs.getString("GPSNumSat");
			}    
			//Add Sensor Data to List
			myList.add(sensorData);
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