package app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

import structures.Account;
import structures.Checking;
import structures.Saving;

/**
 * The main application that provides 6 commands for a user.
 * <p> 1 - create account. 2 - deposit money. 3 - withdraw money. 
 * 4 - transfer money. 5 - print all accounts information. 6 - exit app.
 * 
 * @author      Keira Zhou <keira.qzhou@gmail.com>
 * @version     1.0
 * @since       2015-11-12
 */
public class BankApp {
	
	/** HashMap that contains all accounts that have been created.*/
	public static HashMap<Integer, Account> currentAccounts;

	public static void main(String args[]) {
		BankApp app = new BankApp();
		app.start();
	}

	private void start() {
		currentAccounts = new HashMap<Integer, Account>();
		int currentId = 0;
		int userCommand = 0;
		
		// add 2 accounts to list for testing.
		Account account0 = new Checking();
		Account account1 = new Saving();
		currentAccounts.put(currentId, account0);
		currentId++;
		currentAccounts.put(currentId, account1);
		currentId++;
		
		UserAction actions = new UserAction(); // initiate all possible commands for user
		
		userCommand = this.chooseOption(); // prompt user to choose an option

		do {
			actions.getCommands().get(userCommand).execute();
			userCommand = 0;
			userCommand = this.chooseOption();
		} while (userCommand != 0);
	}
	
	/** 
	 * Ask for user's commands. Check whether it's an integer between 1 to 6.
	 * @return return an integer indicating user's choice.
	 */
	private int chooseOption() {
		System.out.println("\n\nWelcome to MiniBank!");
		System.out.println("Please choose an option:"); // Ask for user's commands
		System.out.println("1.Create an account");
		System.out.println("2.Deposit to an account");
		System.out.println("3.Withdraw from an account");
		System.out.println("4.Transfer balance between two accounts");
		System.out.println("5.Check all accounts info");
		System.out.println("6.Quit the application\n");

		String readIn;
		int option = 0;
		int action = 0;
		do {
			System.out.println("Please type in a number between 1-6:");

			BufferedReader br = new BufferedReader(new InputStreamReader(
					System.in));
			try {
				readIn = br.readLine(); // read user input
				try {
					option = Integer.parseInt(readIn);
				} catch (Exception e) {
					action = 0;
				}
			} catch (IOException e) {
				System.out.println("Read Error, please try again.");
			}
			if (option <= 6 && option >= 1) { // check if it's between 1 to 6
				action = option;
			}
		} while (action == 0);

		return action;
	}
}
