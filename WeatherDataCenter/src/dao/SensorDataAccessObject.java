package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.inject.Inject;

import beans.Sensors;

@Local(SensorDataAccessInterface.class)
@LocalBean
public class SensorDataAccessObject implements SensorDataAccessInterface<Sensors> {

	@Inject
	private Sensors sensor;
	
	@Override
	public Sensors get(String id) {
		 Connection con = TimDataAccessInterface.getConnection();
		 sensor = new Sensors();
			
			try {
				String query = "SELECT * FROM Sensors WHERE id = ?";
				PreparedStatement ps = con.prepareStatement(query);
				ps.setInt(1, Integer.valueOf(id));
				
				ResultSet rs = ps.executeQuery();
				System.out.println("Result Set: " + rs.toString());
				 
				while(rs.next()) {
					sensor.setSensorId(rs.getInt("Sensor_ID"));
			        sensor.setDtStamp(rs.getString("DTStamp"));
			        sensor.setTemperature(rs.getString("Temperature"));
			        sensor.setHumidity(rs.getString("Humidity"));
			        sensor.setPressure(rs.getString("Pressure"));
			        sensor.setAltitude(rs.getString("Altitude"));
			        sensor.setGpsTimeStamp(rs.getString("GPSTimeStamp"));
			        sensor.setGpsLat(rs.getString("GPSLat"));
			        sensor.setGpsLatDir(rs.getString("GPSLatDir"));
			        sensor.setGpsLong(rs.getString("GPSLong"));
			        sensor.setGpsLongDir(rs.getString("GPSLongDir"));
			        sensor.setGpsAltitude(rs.getString("GPSAltitude"));
			        sensor.setGpsNumSat(rs.getString("GPSNumSat"));
					System.out.println("Sensor: " + sensor.toString());
				}
				
				rs.close();
				ps.close();
				
				System.out.println("Finished finding sensor by id!");
			}
			catch(SQLException ex) {
				System.out.println("Error trying to get sensor by id: " + ex.getMessage());
			}
			finally {
				if(con != null) {
					try {
						con.close();
						System.out.println("Connection Closed!");
					}
					catch(SQLException ex) {
						System.out.println("Problem Closing Connection!");
					}
				}
			}
			
			return sensor;
	}

	@Override
	public List<Sensors> getAll() {
		Connection con = TimDataAccessInterface.getConnection();
		List<Sensors> sensorList = new ArrayList<Sensors>();
		
		try {
			String query = "SELECT * FROM Sensors";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(query);
			
			while(rs.next()) {			
				sensor.setSensorId(rs.getInt("Sensor_ID"));
		        sensor.setDtStamp(rs.getString("DTStamp"));
		        sensor.setTemperature(rs.getString("Temperature"));
		        sensor.setHumidity(rs.getString("Humidity"));
		        sensor.setPressure(rs.getString("Pressure"));
		        sensor.setAltitude(rs.getString("Altitude"));
		        sensor.setGpsTimeStamp(rs.getString("GPSTimeStamp"));
		        sensor.setGpsLat(rs.getString("GPSLat"));
		        sensor.setGpsLatDir(rs.getString("GPSLatDir"));
		        sensor.setGpsLong(rs.getString("GPSLong"));
		        sensor.setGpsLongDir(rs.getString("GPSLongDir"));
		        sensor.setGpsAltitude(rs.getString("GPSAltitude"));
		        sensor.setGpsNumSat(rs.getString("GPSNumSat"));
				sensorList.add(sensor);
				sensor = new Sensors(); // reset temp object properties
			}
			
			rs.close();
			statement.close();
			
			System.out.println("Finished generating sensor list!");
		}
		catch(SQLException ex) {
			System.out.println("Error trying to get sensor list: " + ex.getMessage());
		}
		finally {
			if(con != null) {
				try {
					con.close();
					System.out.println("Connection Closed!");
				}
				catch(SQLException ex) {
					System.out.println("Problem Closing Connection!");
				}
			}
		}
		
		return sensorList;
	}

	@Override
	public void save(Sensors t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(String id, Sensors t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Sensors t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteSensor(String id, Sensors t) {
		// TODO Auto-generated method stub
		
	}

}
