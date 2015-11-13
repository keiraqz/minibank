package app;

import structures.Account;
import structures.Checking;
import structures.Money;
import structures.Saving;

/**
 * This class provides 4 possible activities for accounts: 1 - create an account, 
 * 2 - deposit, 3 - withdraw, 4 - transfer between accounts.
 * 
 * @author      Keira Zhou <keira.qzhou@gmail.com>
 * @version     1.0
 * @since       2015-11-12
 */
public class Activities {

	/**
	 * Create an account.
	 * <p>
	 * This method creates either a checking account
	 * or a saving account.
	 * <p>
	 * @param  type Integer indicating whether 1-{@link Checking} or 2-{@link Saving}.
	 * @return an {@link Account} object.
	 */
	public static Account create(int type) {
		if (type == 1) return new Checking();
		return new Saving();
	}

	/**
	 * Deposit {@link Money} to a given account.
	 * @param  account Account where money will be deposited.
	 * @param  amount Deposit amount.
	 * @return boolean indicates whether deposit is successful.
	 */
	public static boolean depositTo(Account account, Money amount) {
		return account.deposit(amount);
	}

	/**
	 * Withdraw {@link Money} to a given account.
	 * @param  account Account where money will be withdrew.
	 * @param  amount Withdraw amount.
	 * @return boolean indicates whether withdraw is successful.
	 */
	public static boolean withdrawFrom(Account account, Money amount) {
		return account.withdraw(amount);
	}

	/**
	 * Transfer {@link Money} between two accounts.
	 * @param  from Account where money will be transfered from.
	 * @param  to Account where money will be transfered to.
	 * @param  amount Transfer amount.
	 * @return boolean indicates whether transfer is successful.
	 */
	public static boolean transfer(Account from, Account to, Money amount) {
		if (from.withdraw(amount)) { // check if there's enough money in fromAccount
			to.deposit(amount); // then transfer
			return true;
		}
		return false;
	}
}
