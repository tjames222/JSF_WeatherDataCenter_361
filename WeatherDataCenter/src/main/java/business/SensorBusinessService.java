package business;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.inject.Inject;

import beans.Sensors;
import dao.SensorDataAccessInterface;

@Local(SensorBusinessInterface.class)
@LocalBean
public class SensorBusinessService implements SensorBusinessInterface {

	@Inject
	private SensorDataAccessInterface<Sensors> dao;
	
	@Override
	public List<Sensors> getSensors() {
		return dao.getAll();
	}

	@Override
	public void setSensors(List<Sensors> sensors) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addSensor(Sensors sensors) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Sensors get(String id) {
		return dao.get(id);
	}

	
}
