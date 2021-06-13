package business;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.LocalBean;

import beans.Sensors;

@Local(SensorCreationInterface.class)
@LocalBean
public class SensorCreationService implements SensorCreationInterface {

	private List<Sensors> sensors = new ArrayList<>();
	
	@Override
	public List<Sensors> getSensors() {
		return sensors;
	}

	@Override
	public void setSensors(List<Sensors> sensors) {
		this.sensors = sensors;
	}

	@Override
	public void addSensor(Sensors sensor) {
		sensors.add(sensor);
	}

}
