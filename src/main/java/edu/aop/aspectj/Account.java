package edu.aop.aspectj;

public class Account 
{
	private int balance;
	
	public static Account zero()
	{
		return new Account(0);
	}
	
	public Account(int balance)
	{
		this.balance = balance;
	}
	
	public void deposit(int amount)
	{
		if (amount <= 0)
		{
			throw new AccountException("Incorrect amount to deposit");
		}
		
		balance += amount;
	}
	
	public void withdraw(int amount)
	{
		if (amount <= 0)
		{
			throw new AccountException("Incorrect amount to withdraw");
		}
		
		if (amount > balance)
		{
			throw new AccountException("Insufficient balance to withdraw");
		}
		
		balance -= amount;
	}
	
	public int getBalance()
	{
		return balance;
	}
}
