package edu.aop.aspectj.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class TransferTests 
{
	private static Transfer transfer;
	
	@BeforeAll
	public static void setupSuite()
	{
		transfer = new Transfer();
	}
	
	@Test
	public void should_TransferFunds_When_Source_And_Destination_AccountsHaveSufficientFunds()
	{
		var source = new Account(30);
		var destination = Account.zero();
		
		transfer.doTransaction(source, destination, 15);
		
		assertEquals(source.getBalance(), 15);
		assertEquals(destination.getBalance(), 15);
	}
	
	@Test
	public void should_ThrowException_When_TryingTransferFunds_And_SourceAccountHasNotSufficientFunds()
	{
		var source = Account.zero();
		var destination = Account.zero();
		
		assertThrows(AccountException.class, () -> {
			
			transfer.doTransaction(source, destination, 50);
			
		});
	}
}
