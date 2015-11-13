Test cases are under package test.

To run the application interactively in terminal:
java -jar MiniBank.jar

Options:
1.Create an account
    input 1 or 2 to create: 1. checking, 2. saving
    output: accountID
    
2.Deposit to an account
    input: accountID,amount
    output: Before Deposit: account_type, amount
            After Deposit: account_type, amount
            
3.Withdraw from an account
    input: accountID,amount
    output: Before Withdraw: account_type, amount
            After Withdraw: account_type, amount

4.Transfer balance between two accounts
    input: FromAccountID,ToAccountID,amount
    output: Before Transfer: 
             From Account 1: account_type, amount
             To Account 2: account_type, amount
            After Transfer: 
             From Account 1: account_type, amount
             To Account 2: account_type, amount

5.Check all accounts info
    input: NONE
    output: Money in all accounts:
             Account 0: account_type, amount
             Account 1: account_type, amount
             Account 2: account_type, amount
             ...

6.Quit the application
    exit