package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import beans.Sensors;

@SuppressWarnings("deprecation")
@ManagedBean
@ViewScoped
public class DataWeatherUpgraded implements SensorDaoInterface{

	// Connect
	
	
	public DataWeatherUpgraded() {
	
	}
	
	List<Sensors> myList = new ArrayList<Sensors>();

	@Override
	public List<Sensors> getAllSensorData() {
		
		System.out.println("Starting the get all sensor data method");
		
		Connection conn = null;
		String url = "jdbc:mysql://webdisk.clc361gp.heliohost.us/clc361gp_clc361_group";
		String username = "clc361gp_group";
		String password = "Group_CLC361";
		
		String sql = "SELECT * FROM Sensors";
			
		try {
			System.out.println("In the try block the get all sensor data method");
			
			
			conn = DriverManager.getConnection(url, username, password);
			
			System.out.println("Connect has been made with DB");
			
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()){
				Sensors sensorData = new Sensors();
		        //int id = rs.getInt("Sensor_ID");
		        sensorData.sensorId=rs.getInt("Sensor_ID");
		        sensorData.dtStamp=rs.getString("DTStamp");
		        sensorData.temperature=rs.getString("Temperature");
		        sensorData.humidity=rs.getString("Humidity");
		        sensorData.pressure=rs.getString("Pressure");
		        sensorData.altitude=rs.getString("Altitude");
		        sensorData.gpsTimeStamp=rs.getString("GPSTimeStamp");
		        sensorData.gpsLat=rs.getString("GPSLat");
		        sensorData.gpsLatDir=rs.getString("GPSLatDir");
		        sensorData.gpsLong=rs.getString("GPSLong");
		        sensorData.gpsLongDir=rs.getString("GPSLongDir");
		        sensorData.gpsAltitude=rs.getString("GPSAltitude");
		        sensorData.gpsNumSat=rs.getString("GPSNumSat");
		        //sensorData.sensorData.add(sensorData);
		        myList.add(sensorData);
		        
			}    
			//Add Sensor Data to List
			
			
			rs.close();
			return myList;
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
		return myList;
	}
}