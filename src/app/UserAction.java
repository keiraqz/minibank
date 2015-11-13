package app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

import structures.Money;

/**
 * This class tries to accomplish Rule 2 - Don’t use the ELSE keyword,
 * and Rule 4 - First class collections.
 * <p>
 * The 6 user commands are implemented in separate classes that implements
 * {@link Command} interface. This follows Java command pattern.
 * 
 * @author      Keira Zhou <keira.qzhou@gmail.com>
 * @version     1.0
 * @since       2015-11-12
 */
public class UserAction {
	/** HashMap that contains all available {@link Command} for users. */
	private HashMap<Integer, Command> commandMap;
	
	/** Add all available commands to commandMap. */
	public UserAction() {
		commandMap = new HashMap<Integer, Command>(); 
		commandMap.put(1, new createAccount());
		commandMap.put(2, new depositMoney());
		commandMap.put(3, new withdrawMoney());
		commandMap.put(4, new transferMoney());
		commandMap.put(5, new printAccount());
		commandMap.put(6, new exit());
	}
	
	/**
	 * getter that returns the command map.
	 * @return HashMap that contains all available commands.
	 */
	public HashMap<Integer, Command> getCommands() {
		return this.commandMap;
	}
}

/**
 * Create account command that implements {@link Command} interface.
 */
class createAccount implements Command {

	/** currentId for newly created account.*/
	private int currentId;

	public createAccount() {
		this.currentId = BankApp.currentAccounts.size();
	}

	@Override
	public void execute() {
		String readIn;
		System.out.println("Please choose account type:");
		System.out.println("Type 1: Checking account");
		System.out.println("Type 2: Saving account");
		HashMap<Integer, String> accountType = new HashMap<Integer, String>();
		accountType.put(1, "Checking");
		accountType.put(2, "Saving");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			readIn = br.readLine();
			try {				
				int type = Integer.parseInt(readIn); // get account type
				BankApp.currentAccounts.put(currentId, Activities.create(type)); //create account
				System.out.printf("Create %s Account with ID: %d",
						accountType.get(type), currentId);
				currentId++;
			} catch (Exception e) {
				System.out.println("Fail to Create");
			}
		} catch (IOException e) {
			System.out.println("Read Error, please try again.");
		}
	}
}

/**
 * Deposit {@link Money} command that implements {@link Command} interface.
 */
class depositMoney implements Command {

	public depositMoney() {}

	@Override
	public void execute() {
		String readIn;
		System.out.println("Please type account ID and deposit amount:");
		System.out.println("Format: accountID,amount");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			readIn = br.readLine();
			try {
				String[] input = readIn.trim().split(","); 
				int accountID = Integer.parseInt(input[0]); // get the accountID
				int amountInt = Integer.parseInt(input[1]); // get the deposit amount
				Money amount = new Money(amountInt); // put the amount in Money object
				System.out.print("Before Deposit: ");
				BankApp.currentAccounts.get(accountID).print(); // print account info
				Activities.depositTo(BankApp.currentAccounts.get(accountID),
						amount); // make deposit
				System.out.print("After Deposit: ");
				BankApp.currentAccounts.get(accountID).print();
			} catch (Exception e) {
				System.out.println("Fail to deposit.");
			}
		} catch (IOException e) {
			System.out.println("Read Error, please try again.");
		}
	}
}

/**
 * Withdraw {@link Money} command that implements {@link Command} interface.
 */
class withdrawMoney implements Command {
	public withdrawMoney() {}

	@Override
	public void execute() {
		String readIn;
		System.out.println("Please type account ID and withdraw amount:");
		System.out.println("Format: accountID,amount");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			readIn = br.readLine();
			try {
				String[] input = readIn.trim().split(",");
				int accountID = Integer.parseInt(input[0]); // get the accountID
				int amountInt = Integer.parseInt(input[1]); // get the withdraw amount
				Money amount = new Money(amountInt); // put the amount in Money object
				System.out.print("Before Withdraw: ");
				BankApp.currentAccounts.get(accountID).print(); // print account into
				Activities.withdrawFrom(BankApp.currentAccounts.get(accountID),
						amount); // make withdraw
				System.out.print("After Withdraw: ");
				BankApp.currentAccounts.get(accountID).print();
			} catch (Exception e) {
				System.out.println("Fail to withdraw.");
			}
		} catch (IOException e) {
			System.out.println("Read Error, please try again.");
		}
	}
}

/**
 * Transfer {@link Money} command that implements {@link Command} interface.
 */
class transferMoney implements Command {
	public transferMoney() {}

	@Override
	public void execute() {
		String readIn;
		System.out.println("Please type account ID and withdraw amount:");
		System.out.println("Format: FromAccountID,ToAccountID,amount");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			readIn = br.readLine();
			try {
				String[] input = readIn.trim().split(",");
				int fromAccountID = Integer.parseInt(input[0]); // transfer from this account
				int toAccountID = Integer.parseInt(input[1]); // transfer into this account
				int amountInt = Integer.parseInt(input[2]); // get the transfer amount
				Money amount = new Money(amountInt); // put the amount in Money object
				System.out.println("Before Transfer: ");
				System.out.printf(" From Account %d: ", fromAccountID);
				BankApp.currentAccounts.get(fromAccountID).print(); // print account into
				System.out.printf(" To Account %d: ", toAccountID);
				BankApp.currentAccounts.get(toAccountID).print();
				
				if (Activities.transfer(BankApp.currentAccounts.get(fromAccountID),
						BankApp.currentAccounts.get(toAccountID), amount)) { // make transfer
					// if transfer succeed, print info
					System.out.println("After Transfer: ");
					System.out.printf(" From Account %d: ", fromAccountID);
					BankApp.currentAccounts.get(fromAccountID).print();
					System.out.printf(" To Account %d: ", toAccountID);
					BankApp.currentAccounts.get(toAccountID).print();
				}
			} catch (Exception e) {
				System.out.println("Fail to transfer.");
			}
		} catch (IOException e) {
			System.out.println("Read Error, please try again.");
		}
	}
}

/**
 * Print all accounts command that implements {@link Command} interface.
 * <p>
 * This command prints all accounts that have been created.
 * The information include the account type and {@link Money} amount.
 */
class printAccount implements Command {
	public printAccount() {}

	@Override
	public void execute() {
		try {
			System.out.println("Money in all accounts:");
			for (int i : BankApp.currentAccounts.keySet()) {
				System.out.printf(" Account %d: ", i);
				BankApp.currentAccounts.get(i).print();
			}
		} catch (Exception e) {
			System.out.println("Fail to print.");
		}
	}
}

/**
 * Exit command that implements {@link Command} interface.
 */
class exit implements Command {
	@Override
	public void execute() {
		System.exit(0);
	}
}
