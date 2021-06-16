package controllers;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import beans.Sensors;
import business.WeatherBusinessService;

@SuppressWarnings("deprecation")
@ManagedBean(name="weatherBean2")
public class WeatherDataControllerUpgraded {
	
	WeatherBusinessService service;
	
	public void WeatherDataControllerUpgraded() {
		
	}
	
	public String onSubmit() {
		System.out.println("You have not reach try.");
		try 
		{
			System.out.println("Inside the TRY block");
			service = new WeatherBusinessService();
			
			List<Sensors> results = service.getAllSensorData();
			
			System.out.println("Past the SQL Query");
			
			System.out.println("Total Results: " + results.size());
			
			if (results.size() > 0)
			{
				//LineChartBean lineChartBean = new LineChartBean(result);
				FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("results", results);
				
				return "ShowWeatherUpgraded.xhtml";
			}
			else 
			{
				return "Error.xhtml";
			}
		}
		catch (Exception e)
		{
			return "Error.xhtml";
		}
	}
	
}
