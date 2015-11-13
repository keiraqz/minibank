package test;

import static org.junit.Assert.*;

import org.junit.Test;

import app.Activities;
import structures.Account;
import structures.Money;

/**
 * Test cases for {@link Activities} class.
 * @author      Keira Zhou <keira.qzhou@gmail.com>
 * @version     1.0
 * @since       2015-11-12
 */
public class TestActivities {
	@Test
	public void testActivities(){
		Account checking = Activities.create(1);
		Account saving = Activities.create(2);
		// check account type
		assertEquals(checking.getClass().getName(), "structures.Checking");
		assertEquals(saving.getClass().getName(), "structures.Saving");
		
		// add money
		Money money = new Money(20);
		assertTrue(Activities.depositTo(checking, money));
		assertTrue(Activities.depositTo(saving, money));
		
		// withdraw money
		Money moneyTwo = new Money(10);
		assertTrue(Activities.withdrawFrom(checking, moneyTwo));
		assertTrue(Activities.withdrawFrom(saving, moneyTwo));
		
		// can't process negative money
		Money moneyThree = new Money(-10);
		assertFalse(Activities.depositTo(checking, moneyThree));
		assertFalse(Activities.depositTo(saving, moneyThree));
		assertFalse(Activities.withdrawFrom(checking, moneyThree));
		assertFalse(Activities.withdrawFrom(saving, moneyThree));

		// transfer money
		assertTrue(Activities.transfer(checking, saving, moneyTwo));
		// transfer more than checking account has
		assertFalse(Activities.transfer(checking, saving, moneyTwo));

	}
}
