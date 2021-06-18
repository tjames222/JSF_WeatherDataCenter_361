package business;

import java.util.List;

import javax.ejb.Local;

import beans.Sensors;

@Local
public interface SensorBusinessInterface {

	public List<Sensors> getSensors();
	
	public void setSensors(List<Sensors> sensors);
	
	public void addSensor(Sensors sensors);
	
	public Sensors get(String id);
	
}
