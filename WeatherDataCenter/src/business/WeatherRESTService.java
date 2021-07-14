package business;

import javax.faces.bean.SessionScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.*;

import beans.Sensor;
import beans.ResponseDataModel;

@SuppressWarnings("deprecation")
@SessionScoped
//@RequestScoped
@Path("/music")
@Produces({ "application/xml", "application/json" })
@Consumes({ "application/xml", "application/json" })

public class WeatherRESTService {
	
	@GET
	@Path("/getsensorj/{sensorId}")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseDataModel getSensorj(@PathParam("sensorId") String sensorId) {
		Sensor snsr = new Sensor();
		snsr.getSensorId();
		SensorBusinessService sbs = new SensorBusinessService();
		sbs.get(sensorId);
		ResponseDataModel rspdm= new ResponseDataModel(0, "");
		
		return rspdm;
		
	}
	
	@GET
	@Path("/getsensorx/{sensorId}")
	@Produces(MediaType.APPLICATION_XML)
	public ResponseDataModel getSensorx(@PathParam("sensorId") String sensorId) {
		Sensor snsr = new Sensor();
		snsr.getSensorId();
		SensorBusinessService sbs = new SensorBusinessService();
		sbs.get(sensorId);
		ResponseDataModel rspdm= new ResponseDataModel(0, "");
		
		return rspdm;
		
	}
	
}
