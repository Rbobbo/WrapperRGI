package it.cg.main.init;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.dozer.spring.DozerBeanMapperFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.AbstractResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;

@Configuration
@ComponentScan(basePackages={"it.cg.*"})
public class ApplicationContextConfig
{
	@Value("${dozer-global-config}")
	private String pathDozerGlobConfig;
	
	private static Logger logger = Logger.getLogger("ApplicationContextConfig");
	private static final String pathMainProp = "main.properties";
	
	/**
	 * Config dozer factory bean than
	 * @return
	 */
	@Bean(name = "dozerBeanMapperFactoryBean")
    public DozerBeanMapperFactoryBean configDozer()
	{
        DozerBeanMapperFactoryBean mapper = new DozerBeanMapperFactoryBean();
        AbstractResource resources[] = new AbstractResource[] {
        		new FileSystemResource(pathDozerGlobConfig)
//        		new FileSystemResource("C:\\Users\\RiccardoEstia\\Documents\\mappingDozer")
        };
        
        
		mapper.setMappingFiles(resources);
        return mapper;
    }
	
	

	/**
	 * Load configuration external and internal
	 * @return
	 */
	@Bean
	@PostConstruct
	public static PropertySourcesPlaceholderConfigurer properties()
	{
		logger.info("Loading properties");
		PropertySourcesPlaceholderConfigurer propConf = new PropertySourcesPlaceholderConfigurer();
		String pathLog4j = getPropertyValue("log4j-conf");
		String pathEndpoint = getPropertyValue("webservice-conf");
		
        AbstractResource resources[] = new AbstractResource[] {
        		new ClassPathResource(pathMainProp),
        		new FileSystemResource(pathLog4j),
        		new FileSystemResource(pathEndpoint)
        };
		
		propConf.setLocations(resources);
		propConf.setIgnoreUnresolvablePlaceholders(true);
		
		return propConf;
	}
	
	/**
	 * main.properties contiene i path delle configurazioni esterne
	 * @param resurseRequest
	 * @return
	 */
	private static String getPropertyValue(String resurseRequest)
	{
		String paramValue = "";
		try
		{
			InputStream input =  ApplicationContextConfig.class.getClassLoader().getResourceAsStream(pathMainProp);
			Properties properties = new Properties();
			
			properties.load(input);
			
			paramValue = properties.getProperty(resurseRequest);
		}
		catch (IOException ex) {
			logger.error("GRAVE Impossibile caricare le configurazioni principali"+ex.getMessage());
			ex.printStackTrace();
		}
		
		return paramValue;
	}

	
	
	
}
