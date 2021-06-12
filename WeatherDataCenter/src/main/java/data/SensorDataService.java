package data;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import model.Sensor;

public class SensorDataService implements DataAccessInterface{
	Object t;
	
	@Override
	public List<Sensor> findAll() {
		List<Sensor> sensorData = new ArrayList<Sensor>();
		return sensorData;
	}

	@Override
	public Object findByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean create(Object t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Object t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Object t) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
