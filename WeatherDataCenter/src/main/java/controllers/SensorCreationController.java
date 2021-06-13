package controllers;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import beans.Sensors;
import business.SensorBusinessInterface;

@SuppressWarnings("deprecation")
@ManagedBean
@ViewScoped
public class SensorCreationController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private SensorBusinessInterface sensorService;
	
	private List<Sensors> sensors;
	
	@PostConstruct
	public void init() {
		System.out.println("**** Ran init ****");
		sensors = sensorService.getSensors(); 
	}
	
	public List<Sensors> getSensors() {
		System.out.println("**** Ran getSensors now ***");
    	System.out.println("Sensors Content Length: " + sensors.size());
    	
    	for (Sensors s : sensors) {
    		System.out.println(s.toString());
    	}
    	return sensors;
	}
	

}
