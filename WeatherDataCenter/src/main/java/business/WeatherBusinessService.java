package business;

import java.util.List;
import beans.Sensors;
import dao.DataWeatherService;

public class WeatherBusinessService {

	
	DataWeatherService service;
	
	public List<Sensors> getAllSensorData(Sensors record){
		
		
		 service = new DataWeatherService(); 
		 return service.getAllSensorData(record);
	}
}