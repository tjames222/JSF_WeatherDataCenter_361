package business;

import java.util.List;

import beans.Sensors;
import dataAccess.DataWeatherService;

public class WeatherBusinessClass {

	
	DataWeatherService service;
	
	public List<Sensors> getAllSensorData(Sensors record){
		
		
		 service = new DataWeatherService(); 
		 return service.getAllSensorData(record);
		 
	
		
	}
}
