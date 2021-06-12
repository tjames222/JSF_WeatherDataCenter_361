package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@SuppressWarnings("deprecation")
@ManagedBean
@ViewScoped
public class Sensors {
	
	////////// Properties
	private int sensorId;
	private String dtStamp;
	private int temperature;
	private int humidity;
	private float pressure;
	private int altitude;
	private String gpsLocation;
	
	////////// Constructors
	public Sensors() {

	}
	
	public Sensors(int sensorId, String dtStamp, int temperature, int humidity, float pressure, int altitude,
			String gpsLocation) {

		this.sensorId = sensorId;
		this.dtStamp = dtStamp;
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		this.altitude = altitude;
		this.gpsLocation = gpsLocation;
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
	public int getTemperature() {
		return temperature;
	}
	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}
	public int getHumidity() {
		return humidity;
	}
	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}
	public float getPressure() {
		return pressure;
	}
	public void setPressure(float pressure) {
		this.pressure = pressure;
	}
	public int getAltitude() {
		return altitude;
	}
	public void setAltitude(int altitude) {
		this.altitude = altitude;
	}
	public String getGpsLocation() {
		return gpsLocation;
	}
	public void setGpsLocation(String gpsLocation) {
		this.gpsLocation = gpsLocation;
	}
	
	///////// ToString() Method
	@Override
	public String toString() {
		return "Sensors [sensorId=" + sensorId + ", dtStamp=" + dtStamp + ", temperature=" + temperature + ", humidity="
				+ humidity + ", pressure=" + pressure + ", altitude=" + altitude + ", gpsLocation=" + gpsLocation + "]";
	}
}
