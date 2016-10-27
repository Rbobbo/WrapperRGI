package it.cg.main.integration.easyway.parsing;


import org.apache.log4j.Logger;
import org.dozer.Mapper;
import org.dozer.spring.DozerBeanMapperFactoryBean;
import org.springframework.stereotype.Service;

import com.blog.samples.webservices.DetailService;
import com.pass.global.WSPassProHelloWorldOperationResponse;

@Service
public class ParsingIn
{
	private Logger logger = Logger.getLogger(getClass());
	
	private DozerBeanMapperFactoryBean dozerMapperFactory;
	
	/**
	 * Costruttore che necessita del mapper factory :<br>
	 * <i>@Autowired <br> DozerBeanMapperFactoryBean dozerFactory;</i>
	 * @param mapper
	 */
	public ParsingIn(DozerBeanMapperFactoryBean mapperFactory)
	{
		this.dozerMapperFactory = mapperFactory;
	}

	
	/**
	 * Ritorna il Mapper di dozer se non � null la variabile
	 * <b>DozerBeanMapperFactoryBean</b>
	 * @return Mapper
	 * @throws NullPointerException nel caso dozerMapper sia null
	 */
	private Mapper getMapper() throws NullPointerException
	{
		Mapper map = null ;
		if(dozerMapperFactory != null)
		{
			try
			{
				map = dozerMapperFactory.getObject();
			}
			catch(Exception ex)
			{
				logger.error("Errore durante il getObject dozer mapper:"+ex.getMessage());
				ex.printStackTrace();
			}
		}
		else
		{
			throw new NullPointerException("dozerMapper null from super implementation");
		}
		
		return map;
	}
	
	/**
	 * 
	 * @param routingDTO
	 * @return
	 */
	public DetailService parse(WSPassProHelloWorldOperationResponse routingDTO)
	{
		logger.info("parse input DTO "+routingDTO);
		
		String test = routingDTO.getReturn();
		routingDTO.setReturn("DOZER---"+test+"---TEST");
		DetailService response = parsingIn(routingDTO);
		
		logger.info("parse output DTO "+response);
		return response;
	}
	
	
	/**
	 * Classe finale per il dozer mapper
	 * 
	 * @param routingDTO
	 * @return
	 */
	private DetailService parsingIn(WSPassProHelloWorldOperationResponse routingDTO)
	{
		logger.info("isParsed input DTO "+routingDTO+" begin parser");

		DetailService response = new DetailService();
		try
		{
			getMapper().map(routingDTO, response);
		}
		catch(NullPointerException ex)
		{
			logger.error("mapper config non presente o errato ? : "+ex.getMessage());
			return new DetailService();
		}
		
		logger.info("isParsed => "+response);
		return response;
	}



	
	

}
