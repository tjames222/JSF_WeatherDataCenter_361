package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import beans.Sensor;

public class DataAccessObject {
	
	public static void main(String[] args){
		getData("","Sensors");
	}
	
	public static boolean getData(String qry, String table) {
		
		boolean success = false;
		try{
	      // create our mysql database connection
		  Class.forName("com.mysql.jdbc.Driver").newInstance();
	      String host = "jdbc:mysql://webdisk.clc361gp.heliohost.us/clc361gp_clc361_group?useSSL=false";
	      String user = "clc361gp_java";
	      String password = "Group_CLC361";
	      String db = "clc361gp_clc361_group";
	      Connection conn = DriverManager.getConnection(host, user, password);
	      
	      // our SQL SELECT query for testing. 
	      // if you only need a few columns, specify them by name instead of using "*"
	      String query = "SELECT * FROM Sensors";
	
	      // create the java statement
	      Statement st = conn.createStatement();
	      
	      // execute the query, and get a java resultset
	      ResultSet rs = st.executeQuery(query);
	      
	      List<Sensor> sensorList = new ArrayList<Sensor>();
	      
	      // iterate through the java resultset
	      while (rs.next())
	      {
//	        int id = rs.getInt("Sensor_ID");
//	        String dts = rs.getString("DTStamp");
//	        String temp = rs.getString("Temperature");
//	        String hum = rs.getString("Humidity");
//	        String press = rs.getString("Pressure");
//	        String calcAlt = rs.getString("Altitude");
//	        String gpstime = rs.getString("GPSTimeStamp");
//	        String gpsLat = rs.getString("GPSLat");
//	        String gpsLatDir = rs.getString("GPSLatDir");
//	        String gpsLon = rs.getString("GPSLong");
//	        String gpsLonDir = rs.getString("GPSLongDir");
//	        String gpsAlt = rs.getString("GPSAltitude");
//	        String gpsNumSat = rs.getString("GPSNumSat");
	    	  
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
	        
	        // print the results
	       // System.out.format("%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s\n", id, dts, temp, hum, press, calcAlt, 
	        //		gpstime, gpsLat, gpsLatDir, gpsLon, gpsLonDir, gpsAlt, gpsNumSat);
	      }
	      for(int x = 0; x < sensorList.size(); x++) {
	    	  System.out.format("%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s\n", sensorList.get(x).getSensorId(), sensorList.get(x).getDtStamp(), 
	    			  sensorList.get(x).getTemperature(), sensorList.get(x).getHumidity(), sensorList.get(x).getPressure(), sensorList.get(x).getAltitude(), 
	    			  sensorList.get(x).getGpsTimeStamp(), sensorList.get(x).getGpsLat(), sensorList.get(x).getGpsLatDir(), sensorList.get(x).getGpsLong(), 
	    			  sensorList.get(x).getGpsLongDir(), sensorList.get(x).getGpsAltitude(), sensorList.get(x).getGpsNumSat());
	      }
	      st.close();
	      success = true;
	    }
	    catch (Exception e){
	      System.err.println("Got an exception! ");
	      System.err.println(e.getMessage());
	      success = false;
	    }
		return success;
	}
}
