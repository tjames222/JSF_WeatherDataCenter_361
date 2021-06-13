package business;

import java.util.List;
import beans.Sensors;
import javax.ejb.LocalBean;
import dao.DataWeatherService;

@LocalBean
public class WeatherBusinessService {

	
	DataWeatherService service;
	
	public List<Sensors> getAllSensorData(){
		 service = new DataWeatherService(); 
		 return service.getAllSensorData();
	}
}