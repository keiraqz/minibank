package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import structures.Account;
import structures.Checking;
import structures.Money;
import structures.NullAccount;
import structures.Saving;

/**
 * Test cases for {@link Account} class.
 * @author      Keira Zhou <keira.qzhou@gmail.com>
 * @version     1.0
 * @since       2015-11-12
 */
public class TestAccount {
	@Test
	public void testAccount(){
		Account checking = new Checking();
		Account saving = new Saving();
		Account nullAccount = new NullAccount();
		
		Money addAmount = new Money(10);
		assertTrue(checking.deposit(addAmount));
		assertTrue(saving.deposit(addAmount));
		assertFalse(nullAccount.deposit(addAmount));
		
		// deposit negative
		Money addNegAmount = new Money(-10);
		assertFalse(checking.deposit(addNegAmount));
		assertFalse(saving.deposit(addNegAmount));
		assertFalse(nullAccount.deposit(addNegAmount));

		// withdraw money
		Money subAmount = new Money(10);
		assertTrue(checking.withdraw(subAmount));
		assertTrue(saving.withdraw(subAmount));
		assertFalse(nullAccount.withdraw(subAmount));
		
		// withdraw more
		assertFalse(checking.withdraw(subAmount));
		assertFalse(saving.withdraw(subAmount));
		assertFalse(nullAccount.withdraw(subAmount));

		// withdraw negative
		Money subNegAmount = new Money(-10);
		assertFalse(checking.withdraw(subNegAmount));
		assertFalse(saving.withdraw(subNegAmount));
		assertFalse(nullAccount.withdraw(subNegAmount));
	}
}
