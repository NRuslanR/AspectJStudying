package edu.aop.aspectj;

public class AccountException extends RuntimeException
{
	protected AccountException(String message, Throwable cause) 
	{
		super(message, cause);
	}

	protected AccountException(String message) 
	{
		super(message);
	}

	protected AccountException(Throwable cause) 
	{
		super(cause);
	}
}
