package edu.aop.aspectj.crosscutting;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.aop.aspectj.domain.Account;

public class LogSession implements Session
{
	private final Logger logger = LoggerFactory.getLogger(LogSession.class);
	
	@Override
	public void start() 
	{
		logger.info("START TRANSACTION");
	}

	@Override
	public void commit() 
	{
		logger.info("COMMIT TRANSACTION");	
	}

	@Override
	public void rollback() 
	{
		logger.info("ROLLBACK TRANSACTION");
	}
}
