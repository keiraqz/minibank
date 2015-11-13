package test;

import static org.junit.Assert.*;

import org.junit.Test;

import structures.Money;

/**
 * Test cases for {@link Money} class.
 * @author      Keira Zhou <keira.qzhou@gmail.com>
 * @version     1.0
 * @since       2015-11-12
 */
public class TestMoney {
	@Test
	public void testMoney(){
		Money money = new Money(0);
		assertEquals(money.getAmount(),0);
		
		Money addAmount = new Money(10);
		assertTrue(money.add(addAmount));
		assertEquals(money.getAmount(),10);
		
		// add negative
		Money addNegAmount = new Money(-10);
		assertFalse(money.add(addNegAmount));
		
		Money subAmount = new Money(10);
		assertTrue(money.subtract(subAmount));
		assertEquals(money.getAmount(),0);
		
		// subtract more
		assertFalse(money.subtract(subAmount));
		assertEquals(money.getAmount(),0);
		
		// subtract negative
		Money subNegAmount = new Money(-10);
		assertFalse(money.subtract(subNegAmount));
	}
}
