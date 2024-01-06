package edu.aop.aspectj;

public class Transfer 
{
	public void doTransaction(Account source, Account destination, int amount)
	{
		source.withdraw(amount);
		destination.deposit(amount);
	}
}
