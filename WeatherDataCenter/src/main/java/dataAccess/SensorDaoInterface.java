package dataAccess;

import java.util.List;

import beans.Sensors;

public interface SensorDaoInterface {

	public List<Sensors> getAllSensorData(Sensors record);
}