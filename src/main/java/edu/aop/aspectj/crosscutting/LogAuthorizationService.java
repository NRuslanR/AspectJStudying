package edu.aop.aspectj.crosscutting;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogAuthorizationService implements AuthorizationService
{
	private final Logger logger = LoggerFactory.getLogger(LogAuthorizationService.class);
	
	@Override
	public void ensureCurrentAuthorized(Collection<String> claims) throws AuthorizationException 
	{
		logger.info(
			"Validate authorization with claims: " + 
			claims.stream().reduce((f, s) -> f + ", " + s).orElse("")
		);
	}

}
