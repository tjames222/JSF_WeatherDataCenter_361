package business;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.LocalBean;

import beans.Sensors;
import dao.DataAccessInterface;

@LocalBean
public class SensorDataService implements DataAccessInterface<Object>{
	Object t;
	
	@Override
	public List<Sensors> findAll() {
		List<Sensors> sensorData = new ArrayList<Sensors>();
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
