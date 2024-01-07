package edu.aop.aspectj;

import edu.aop.aspectj.domain.Account;
import edu.aop.aspectj.domain.Transfer;

public class AspectJProgram 
{
    public static void main(String[] args)
    {
    	var source = new Account(30);
		var destination = Account.zero();
		
		var transfer = new Transfer();
		
		transfer.doTransaction(source, destination, 15);
    }
}
