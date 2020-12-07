package com.atmecs.archetype.utils;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.atmecs.archetype.constant.FilePathConstants;

public class Logging 
{
	Logger log = null;
		
	public Logging()
	{
		getLogger();
		log = Logger.getLogger(Logging.class);
	}
	
	public void getLogger()
	{
		PropertyConfigurator.configure(FilePathConstants.LOG4J_FILE_PATH);
	}
	
	public void warn(String message)
	{
		log.warn(message);
	}
	
	public  void info(String message)
	{
		log.info(message);
	}

	public  void debug(String message)
	{
		log.debug(message);
	}
	
	public void error(String message)
	{
		log.error(message);
	}
	
	public void fatal(String message)
	{
		log.fatal(message);
	}
}
