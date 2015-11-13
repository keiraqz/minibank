package structures;

/**
 * Null account that inherits {@link Account}. This class tries to 
 * accomplish Rule 2 - Don’t use the ELSE keyword.
 * <p>
 * The implementation follows Null Object pattern.
 *
 *  
 * @author      Keira Zhou <keira.qzhou@gmail.com>
 * @version     1.0
 * @since       2015-11-12
 */
public class NullAccount extends Account {

	public NullAccount(String type) {
		super("null");
	}
	
	public NullAccount() {
		super("null");
	}
	
	@Override
	public boolean deposit(Money amount) {
		System.out.println("Account ID does not exist");
		return false;
	}
	
	@Override
	public boolean withdraw(Money amount) {
		System.out.println("Account ID does not exist");
		return false;
	}
	
	@Override
	public void print() {
		System.out.println("Account ID does not exist");
	}

}
