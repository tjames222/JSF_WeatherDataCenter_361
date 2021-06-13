package beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@SuppressWarnings("deprecation")
@ManagedBean(name="sensor")
@ViewScoped
public class Sensors {
	
	////////// Properties
	public int sensorId;
	public String dtStamp;
	public String temperature;
	public String humidity;
	public String pressure;
	public String altitude;
	public String gpsTimeStamp;
	public String gpsLat;
	public String gpsLatDir;
	public String gpsLong;
	public String gpsLongDir;
	public String gpsAltitude;
	public String gpsNumSat;
	// public List<Sensors> sensorData;

	////////// Constructors
	public Sensors() {
		super();
	}
	
	public Sensors(int sensorId, String dtStamp, String temperature, String humidity, String pressure, String altitude,
			String gpstime, String gpsLat, String gpsLatDir, String gpsLong, String gpsLongDir, String gpsAltitude, String gpsNumSat) {
		super();
		this.sensorId = sensorId;
		this.dtStamp = dtStamp;
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		this.altitude = altitude;
		this.gpsTimeStamp = gpstime;
		this.gpsLat = gpsLat;
		this.gpsLatDir = gpsLatDir;
		this.gpsLong = gpsLong;
		this.gpsLongDir = gpsLongDir;
		this.gpsAltitude = gpsAltitude;
		this.gpsNumSat = gpsNumSat;
	}

	////////// Getters and Setters
	public int getSensorId() {
		return sensorId;
	}
	
	public void setSensorId(int sensorId) {
		this.sensorId = sensorId;
	}
	public String getDtStamp() {
		return dtStamp;
	}
	public void setDtStamp(String dtStamp) {
		this.dtStamp = dtStamp;
	}
	public String getTemperature() {
		return temperature;
	}
	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}
	public String getHumidity() {
		return humidity;
	}
	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}
	public String getPressure() {
		return pressure;
	}
	public void setPressure(String pressure) {
		this.pressure = pressure;
	}
	public String getAltitude() {
		return altitude;
	}
	public void setAltitude(String altitude) {
		this.altitude = altitude;
	}
	public String getGpsTimeStamp() {
		return gpsTimeStamp;
	}

	public void setGpsTimeStamp(String gpsTimeStamp) {
		this.gpsTimeStamp = gpsTimeStamp;
	}

	public String getGpsLat() {
		return gpsLat;
	}
	public void setGpsLat(String gpsLat) {
		this.gpsLat = gpsLat;
	}
	public String getGpsLatDir() {
		return gpsLatDir;
	}
	public void setGpsLatDir(String gpsLatDir) {
		this.gpsLatDir = gpsLatDir;
	}
	public String getGpsLong() {
		return gpsLong;
	}
	public void setGpsLong(String gpsLong) {
		this.gpsLong = gpsLong;
	}
	public String getGpsLongDir() {
		return gpsLongDir;
	}
	public void setGpsLongDir(String gpsLongDir) {
		this.gpsLongDir = gpsLongDir;
	}
	public String getGpsAltitude() {
		return gpsAltitude;
	}
	public void setGpsAltitude(String gpsAltitude) {
		this.gpsAltitude = gpsAltitude;
	}
	public String getGpsNumSat() {
		return gpsNumSat;
	}
	public void setGpsNumSat(String gpsNumSat) {
		this.gpsNumSat = gpsNumSat;
	}
	/*public List<Sensors> getSensorData() {
		return sensorData;
	}
	public void setSensorData(List<Sensors> sensorData) {
		this.sensorData = sensorData;
	}
	*/

	///////// ToString() Method
	@Override
	public String toString() {
		return "Sensors [sensorId=" + sensorId + ", dtStamp=" + dtStamp + ", temperature=" + temperature + ", humidity="
				+ humidity + ", pressure=" + pressure + ", altitude=" + altitude + ", gpsLocation=" + gpsLat + "]";
	}
}
