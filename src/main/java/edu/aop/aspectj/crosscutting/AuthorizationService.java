package edu.aop.aspectj.crosscutting;

import java.util.Collection;

public interface AuthorizationService 
{
	void ensureCurrentAuthorized(Collection<String> claims) throws AuthorizationException;
}
