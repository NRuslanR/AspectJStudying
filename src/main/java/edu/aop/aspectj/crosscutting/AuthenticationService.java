package edu.aop.aspectj.crosscutting;

public interface AuthenticationService 
{
	void ensureCurrentAuthenticated() throws AuthenticationException;
}
