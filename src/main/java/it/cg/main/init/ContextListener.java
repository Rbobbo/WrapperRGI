package it.cg.main.init;

import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

@WebListener
public class ContextListener implements ServletContextListener
{

	private static Logger logger = Logger.getLogger("ApplicationContextConfig");
	
	
	/**
	 * Inizializza le configurazioni del log4j esterne
	 */
	@Override
	public void contextInitialized(ServletContextEvent event)
	{
		ServletContext context = event.getServletContext();
		Properties properties = new Properties();
		try
		{
			properties.load(context.getResourceAsStream("/WEB-INF/classes/main.properties"));
		}
		catch (IOException e)
		{
			
			e.printStackTrace();
		}
		String log4jConfigFile = properties.getProperty("log4j-conf");
				
		PropertyConfigurator.configureAndWatch(log4jConfigFile);
		
		logger.info("contextLoaded");
	}

	@Override
	public void contextDestroyed(ServletContextEvent event)
	{
		
	}
	
}
