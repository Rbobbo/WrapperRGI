package it.cg.main.dto;

import com.blog.samples.webservices.servicedetail.ServiceCallRequest;

public class RoutingDTO {
	
	private String typeOf;
	private ServiceCallRequest requestService;

	
	
	public String getTypeOf() {
		return typeOf;
	}

	public void setTypeOf(String typeOf) {
		this.typeOf = typeOf;
	}

	public ServiceCallRequest getRequestService() {
		return requestService;
	}

	public void setRequestService(ServiceCallRequest requestService) {
		this.requestService = requestService;
	}
	
	
	
	
}
