package it.cg.main.parsing.easyway;

import it.cg.main.dto.RoutingDTO;
import net.webservicex.GetWeather;

public class ParsingOut
{
	
	public GetWeather getParsing(RoutingDTO request)
	{
		
		GetWeather getService = new GetWeather();
		
		getService.setCityName("Bologna");
		
		return getService;
	}

}
