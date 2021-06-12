package controllers;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import beans.Sensors;
import business.WeatherBusinessClass;

@ManagedBean
@ViewScoped
public class DataController implements Serializable{

	
	private static final long serialVersionUID = 1L;
	WeatherBusinessClass service;
	
	public String handleSearch(Sensors record)
	{
		System.out.println("Handle Search Method is running =========================================");
		
		try 
		{
			
			service = new WeatherBusinessClass();
			
			List<Sensors> results = service.searchForSensors(record);
			if (results.size() > 0)
			{
				//LineChartBean lineChartBean = new LineChartBean(result);
				FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("results", results);
				
				return "index.xhtml";
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
