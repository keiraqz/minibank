package structures;

import java.util.HashMap;
import java.util.Set;

/**
 * The AccountCollection class that wraps around a HashSet but return
 * a null account object when the account ID does not exit.
 * <p>
 * The implementation follows Null Object pattern.
 *
 * 
 * @author      Keira Zhou <keira.qzhou@gmail.com>
 * @version     1.0
 * @since       2015-11-12
 */
public class AccountCollection {
	/** HashMap that contains all accounts that have been created.*/
	private static HashMap<Integer, Account> accountCollection;
	
	public AccountCollection() {
		accountCollection = new HashMap<Integer,Account>();
	}
	
	public Account put(Integer accoundID, Account account) {
		return accountCollection.put(accoundID, account);
	}
	
	public Account get(int accoundID) {
		if (accountCollection.containsKey(accoundID)) {
			return accountCollection.get(accoundID);
		}
		return new NullAccount();
	}
	
	public int size() {
		return accountCollection.size();
	}
	
	public Set<Integer> keySet() {
		return accountCollection.keySet();
	}
}
