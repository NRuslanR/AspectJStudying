package edu.aop.aspectj.crosscutting;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogAuthenticationService implements AuthenticationService 
{
	private final Logger logger = LoggerFactory.getLogger(LogAuthenticationService.class);
	
	@Override
	public void ensureCurrentAuthenticated() throws AuthenticationException 
	{
		logger.info("Validate authentication...");
	}
}
