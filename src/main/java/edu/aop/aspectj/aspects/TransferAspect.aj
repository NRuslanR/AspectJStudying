package edu.aop.aspectj.aspects;

import java.util.Arrays;

import edu.aop.aspectj.crosscutting.AuthenticationService;
import edu.aop.aspectj.crosscutting.AuthorizationService;
import edu.aop.aspectj.crosscutting.LogAuthenticationService;
import edu.aop.aspectj.crosscutting.LogAuthorizationService;
import edu.aop.aspectj.crosscutting.LogSession;
import edu.aop.aspectj.crosscutting.Session;
import edu.aop.aspectj.domain.Account;
import edu.aop.aspectj.domain.Transfer;

public aspect TransferAspect 
{
	private final AuthenticationService authenticationService = new LogAuthenticationService();
	private final AuthorizationService authorizationService = new LogAuthorizationService();
	
	private final Session session = new LogSession();
	
	pointcut callDoTransaction(Account destination, int amount, Account source, Transfer transfer) : 
		call(void Transfer.doTransaction(Account, Account, int)) && 
		args(source, destination, amount) &&
		target(transfer);
		
	before(Account destination, int amount, Account source, Transfer transfer) : 
		callDoTransaction(destination, amount, source, transfer) 
	{
		authenticationService.ensureCurrentAuthenticated();
		authorizationService.ensureCurrentAuthorized(Arrays.asList("user", "admin"));
	}
	
	void around(Account destination, int amount, Account source, Transfer transfer) : 
		callDoTransaction(destination, amount, source, transfer) 
	{
		session.start();
		
		try
		{
			proceed(destination, amount, source, transfer);
			
			session.commit();
		}
		
		catch(Exception exception)
		{
			session.rollback();
		}
	}
	
	after(Account destination, int amount, Account source, Transfer transfer) : 
		callDoTransaction(destination, amount, source, transfer) 
	{
		
	}
}
