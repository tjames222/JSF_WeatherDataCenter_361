package controllers;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import beans.Sensors;
import business.WeatherBusinessService;


@ManagedBean
@ViewScoped
public class DataController{

	

	WeatherBusinessService service;
	
	public String handleSearch(){
		System.out.println("You have not reach try.");
		try 
		{
			System.out.println("There is no try.");
			service = new WeatherBusinessService();
			
			List<Sensors> results = service.getAllSensorData();
			if (results.size() > 0)
			{
				//LineChartBean lineChartBean = new LineChartBean(result);
				FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("results", results);
				
				return "data.xhtml";
			}
			else 
			{
				return "Error.xhtml";
			}
		}
		catch (Exception e)
		{
			return "ExceptionError.xhtml";
		}
	}
}