package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import structures.Account;
import structures.AccountCollection;
import app.Activities;

public class TestCollection {
	@Test
	public void testAccountCollection() {
		AccountCollection testAccounts = new AccountCollection();
		Account checking = Activities.create(1);
		Account saving = Activities.create(2);
		testAccounts.put(1, checking);
		testAccounts.put(2, saving);

		// check account type
		assertEquals(testAccounts.get(1).getClass().getName(),
				"structures.Checking");
		assertEquals(testAccounts.get(2).getClass().getName(),
				"structures.Saving");
		assertEquals(testAccounts.get(3).getClass().getName(),
				"structures.NullAccount");

	}
}
