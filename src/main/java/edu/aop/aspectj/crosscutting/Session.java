package edu.aop.aspectj.crosscutting;

public interface Session 
{
	void start();
	void commit();
	void rollback();
}
