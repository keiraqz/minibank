package structures;

/**
 * The Account class which support 2 functions for a given account: 
 * 1 - deposit into this account, 2 - withdraw from this account.
 * 
 * @author      Keira Zhou <keira.qzhou@gmail.com>
 * @version     1.0
 * @since       2015-11-12
 */
public class Account {
	private final String type;

	private Money total;
		
	public Account(String type) {
		this.type = type;
		this.total = new Money(0);
	}
	
	public boolean deposit(Money amount) {
		if (this.total.add(amount) == false) {
			System.out.println("Fail to deposit");
			return false;
		}
		return true;
	}
	
	public boolean withdraw(Money amount) {
		if (this.total.subtract(amount) == false) {
			System.out.println("Fail to withdraw");
			return false;
		}
		return true;
	}
	
	public void print() {
		System.out.print("type_" + this.type + ", ");
		System.out.println("amount_" + total.getAmount());
	}
}
