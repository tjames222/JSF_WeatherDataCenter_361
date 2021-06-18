package beans;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.JDBCType;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@SuppressWarnings("deprecation")
@ManagedBean
@RequestScoped
public class SensorBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -769712151785853217L;
	public List<Sensor> getSensorList() throws ClassNotFoundException, SQLException{
		System.out.println("inside of get sensor list method in sensor bean.");
		Connection connect = null;
		String url = "jdbc:mysql://webdisk.clc361gp.heliohost.us/clc361gp_clc361_group?useSSL=false";
		String user = "clc361gp_java";
	    String password = "Group_CLC361";
	    
	    try {
	    	//System.out.println("inside of try portion of block in sensor bean.");
	    	//Class.forName("com.mysql.jdbc.Driver");
	    	
	    	connect = DriverManager.getConnection(url, user, password);
	    	//System.out.println("Connection Established.");
	    } catch(SQLException ex) {
	    	System.out.println("in sql exception.");
	    	System.out.println(ex.getMessage());
	    	ex.printStackTrace();
	    }
	    
	    List<Sensor> sensorList = new ArrayList<Sensor>();
	    String query = "SELECT * FROM Sensors";
		
	     // create the java statement
	     Statement st = connect.createStatement();
	      
	     // execute the query, and get a java resultset
	     ResultSet rs = st.executeQuery(query);
	      
	     // iterate through the java resultset
	     while (rs.next()) {
	    	 Sensor sensor = new Sensor();
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
	    	 sensor.setGpsLongDir(rs.getString("GPSLongDIr"));
	    	 sensor.setGpsAltitude(rs.getString("GPSAltitude"));
	    	 sensor.setGpsNumSat(rs.getString("GPSNumSat"));
	    	 sensorList.add(sensor);
	     }
//	     for(int x = 0; x < sensorList.size(); x++) {
//	    	  System.out.format("%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s\n", sensorList.get(x).getSensorId(), sensorList.get(x).getDtStamp(), 
//	    			  sensorList.get(x).getTemperature(), sensorList.get(x).getHumidity(), sensorList.get(x).getPressure(), sensorList.get(x).getAltitude(), 
//	    			  sensorList.get(x).getGpsTimeStamp(), sensorList.get(x).getGpsLat(), sensorList.get(x).getGpsLatDir(), sensorList.get(x).getGpsLong(), 
//	    			  sensorList.get(x).getGpsLongDir(), sensorList.get(x).getGpsAltitude(), sensorList.get(x).getGpsNumSat());
//	      }
	     rs.close();
	     connect.close();
	     return sensorList;
	}
}
