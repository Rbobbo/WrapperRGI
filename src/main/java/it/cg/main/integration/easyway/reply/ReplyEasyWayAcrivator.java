package it.cg.main.integration.easyway.reply;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.integration.annotation.Gateway;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessagingException;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.support.MessageBuilder;

import com.blog.samples.webservices.DetailService;
import com.blog.samples.webservices.servicedetail.ServiceCallResponse;

import it.cg.main.integration.interfaces.ActivatorHandler;
import net.webservicex.GetWeatherResponse;

public class ReplyEasyWayAcrivator implements ActivatorHandler {

	private Logger logger = Logger.getLogger(getClass());
	
	
	@Gateway(requestChannel="easyChainActivatorResultChannel")
	public Message<ServiceCallResponse> gotoEasyWay(GetWeatherResponse routingDTO, @Headers Map<String, Object> headerMap)
	{
		logger.info("gotoEasyWay input DTO "+routingDTO);
		GetWeatherResponse responseMeteo = new GetWeatherResponse();
		responseMeteo.setGetWeatherResult("bah");
		
		ServiceCallResponse callResp = new ServiceCallResponse();
		DetailService detailServ = new DetailService();
		
		
		detailServ.setServiceType("Easy way");
		
		
		callResp.setDetailService(detailServ );
		Message<ServiceCallResponse> message = MessageBuilder.withPayload(callResp).build();
		
		logger.info("gotoEasyWay response DTO "+message);
		return message;
	}


}
