package business;

import java.util.List;
import beans.Sensors;
import javax.ejb.LocalBean;
import dao.DataWeatherUpgraded;

@LocalBean
public class WeatherBusinessUpgraded {

	
	DataWeatherUpgraded service;
	
	public List<Sensors> getAllSensorData(){
		 service = new DataWeatherUpgraded(); 
		 return service.getAllSensorData();
	}
}