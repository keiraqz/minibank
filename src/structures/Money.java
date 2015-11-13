package structures;

/**
 * This class tries to accomplish Rule 3 - Wrap all primitives and Strings 
 * by putting money amount into a Money object.
 * 
 * @author      Keira Zhou <keira.qzhou@gmail.com>
 * @version     1.0
 * @since       2015-11-12
 */
public class Money {
	
	/** Money amount.*/
	private int totalAmount;
	
	public Money (int totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	/** Increase Money amount.
	 * @param amount The amount of money to be added onto current amount.
	 * @return boolean Return whether the money has been added successfully.
	 */
	public boolean add (Money amount) {
		if (amount.totalAmount < 0) return false; // can't deposit negative money
		this.totalAmount += amount.totalAmount;
		return true;
	}
	
	/** Decrease Money amount.
	 * @param amount The amount of money to be subtracted from current amount.
	 * @return boolean Return whether the money has been subtracted successfully.
	 */
	public boolean subtract (Money amount) {
		if (amount.totalAmount < 0) return false; // can't withdraw negative money
		this.totalAmount -= amount.totalAmount;
		if (totalAmount < 0) { // can't subtract when money falls below 0
			this.totalAmount += amount.totalAmount;
			return false;
		}
		return true;
	}
	
	public int getAmount() {
		return this.totalAmount;
	}
}
