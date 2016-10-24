package it.cg.main.integration.gateway.impl;

import org.apache.log4j.Logger;
import org.springframework.integration.annotation.Gateway;
import org.springframework.messaging.MessagingException;
import org.springframework.stereotype.Service;

import com.blog.samples.webservices.DetailService;
import com.blog.samples.webservices.servicedetail.ServiceCallRequest;
import com.blog.samples.webservices.servicedetail.ServiceCallResponse;

import it.cg.main.dto.RoutingDTO;
import it.cg.main.integration.interfaces.ActivatorHandler;


@Service
public class ActivatorInboundGatewayImpl implements ActivatorHandler
{
	
	private final Logger logger = Logger.getLogger(getClass());
	
	/**
	 * TODO da implementare con la response finale
	 * 
	 * @param response
	 * @return ServiceCallResponse
	 */
	@Gateway
	public ServiceCallResponse getReplyMetod(ServiceCallResponse response)
	{
		logger.info("getReplyMetod with parameters : " + response);
		
		ServiceCallResponse serviceCallResponse = new ServiceCallResponse();
		DetailService detail = new DetailService();
		
		detail.setServiceType("fake response");
		
		serviceCallResponse.setDetailService(detail );
		
		logger.info("getReplyMetod reply : " + detail);
		return serviceCallResponse;
	}

	/**
	 * Setto che tipo di routing è da fare e l'oggetto di request intero per trasportarlo tra
	 * gli elementi di integration
	 * @param request
	 * @return
	 * @throws MessagingException
	 */
	@Gateway
	public RoutingDTO handleRequestRoutingMessage(ServiceCallRequest request) throws MessagingException
	{
		logger.info("for ActivatorInboundGatewayImpl handleRequestRoutingMessage with : "+request);
		
		RoutingDTO routingDto = new RoutingDTO();
		routingDto.setTypeOf(request.getServiceType());
		routingDto.setRequestService(request);
		
		logger.info("for ActivatorInboundGatewayImpl handleRequestRoutingMessage response : "+routingDto);
		return routingDto;
	}
	
	

}
