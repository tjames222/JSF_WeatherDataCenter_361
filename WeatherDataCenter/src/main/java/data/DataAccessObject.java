package data;

import java.sql.*;

public class DataAccessObject {
	
	public static void main(String[] args){
		getData("","Sensors");
	}
	
	public static boolean getData(String qry, String table) {
		
		boolean success = false;
		try{
	      // create our mysql database connection
		  Class.forName("com.mysql.cj.jdbc.Driver");
	      String host = "jdbc:mysql://webdisk.clc361gp.heliohost.us/clc361gp_clc361_group?useSSL=false";
	      String user = "clc361gp_group";
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
	      
	      // iterate through the java resultset
	      while (rs.next())
	      {
	        int id = rs.getInt("Sensor_ID");
	        String dts = rs.getString("DTStamp");
	        String temp = rs.getString("Temperature");
	        String hum = rs.getString("Humidity");
	        String press = rs.getString("Pressure");
	        String calcAlt = rs.getString("Altitude");
	        String gpstime = rs.getString("GPSTimeStamp");
	        String gpsLat = rs.getString("GPSLat");
	        String gpsLatDir = rs.getString("GPSLatDir");
	        String gpsLon = rs.getString("GPSLong");
	        String gpsLonDir = rs.getString("GPSLongDir");
	        String gpsAlt = rs.getString("GPSAltitude");
	        String gpsNumSat = rs.getString("GPSNumSat");
	        
	        // print the results
	        System.out.format("%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s\n", id, dts, temp, hum, press, calcAlt, 
	        		gpstime, gpsLat, gpsLatDir, gpsLon, gpsLonDir, gpsAlt, gpsNumSat);
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
