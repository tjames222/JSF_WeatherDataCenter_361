package beans;

public class Sensor {
	private int sensorId;
	private String dtStamp;
	private String temperature;
	private String humidity;
	private String pressure;
	private String altitude;
	private String gpsTimeStamp;
	private String gpsLat;
	private String gpsLatDir;
	private String gpsLong;
	private String gpsLongDir;
	private String gpsAltitude;
	private String gpsNumSat;
	
	public Sensor() {
		
	}
	
	public Sensor(int sensorId, String dtStamp, String temperature, String humidity, String pressure, String altitude,
			String gpstime, String gpsLat, String gpsLatDir, String gpsLong, String gpsLongDir, String gpsAltitude, String gpsNumSat) {
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
}
