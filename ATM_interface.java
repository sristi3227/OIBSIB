
package Projects;

import java.util.Scanner;


public class ATM_interface {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       
        User user = new User("123456", "1234");
        Account account = new Account("123456", 1000); 
        
        ATM atm = new ATM(user, account);
        

        System.out.println("Welcome to the ATM Interface");
        System.out.print("Enter User ID: ");
        String userId = scanner.nextLine();
        System.out.print("Enter PIN: ");
        String pin = scanner.nextLine();
        
        
        if (atm.authenticate(userId, pin)) {
            atm.showMenu();
        } else {
            System.out.println("Invalid User ID or PIN. Exiting...");
        }
    }
}

class User {
    private String userId;
    private String pin;
    
    public User(String userId, String pin) {
        this.userId = userId;
        this.pin = pin;
    }
    
    public String getUserId() {
        return userId;
    }
    
    public String getPin() {
        return pin;
    }
}

class Account {
    private String accountId;
    private double balance;
    
    public Account(String accountId, double balance) {
        this.accountId = accountId;
        this.balance = balance;
    }
    
    public String getAccountId() {
        return accountId;
    }
    
    public double getBalance() {
        return balance;
    }
    
    public void deposit(double amount) {
        balance += amount;
        System.out.println("your current balance is "+ balance);
    }
    
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("your money has been withdrawn successfully");
            System.out.println("your current balance is Rs."+ balance);
            
        } else {
            System.out.println("Insufficient balance");
        }
    }
    
        
    public void transferMoney(double amount) {
        if(balance>=amount){
        
        System.out.println("Transfer successful");
        balance-=amount;
        System.out.println("your current balance is "+ balance);}
        
        else{
        System.out.println("There is insufficient balance in your account");
                    }
    }
}

class Transaction {
    private String transactionId;
    private String accountId;
    private double amount;
    
    public Transaction(String transactionId, String accountId, double amount) {
        this.transactionId = transactionId;
        this.accountId = accountId;
        this.amount = amount;
    }
    
    // Getter methods
}

class ATM {
    private User user;
    private Account account;
    
    public ATM(User user, Account account) {
        this.user = user;
        this.account = account;
    }
    
    public boolean authenticate(String userId, String pin) {
        return user.getUserId().equals(userId) && user.getPin().equals(pin);
    }
    
    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        double withdrawAmount =0, depositAmount=0, transfer=0; 
        int accountno=0;
        do {
            System.out.println("\nATM Menu:");
            System.out.println("1. Choose 1 to view Transaction History");
            System.out.println("2. Choose 2 to Withdraw Money");
            System.out.println("3. Choose 3 to Deposit Money");
            System.out.println("4. Choose 4 to Transfer Money");
            System.out.println("5. Choose 5 to Quit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
        if(withdrawAmount!=0 ||depositAmount!=0 || transfer!=0){
            
                     System.out.println("your transaction is as follows");
            if(withdrawAmount!=0)
                     System.out.println("Rs."+ withdrawAmount +" amount was withdrawn");
                        
            if(depositAmount!=0)
                    System.out.println("Rs."+ depositAmount +" amount was deposited");
        
        
            if(transfer!=0)
                        System.out.println("Rs."+ transfer +" amount was transferred to account no." +accountno );
        }
        else{
            System.out.println("there is no transaction history yet");
        }
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    
                    
                    break;
                case 3:
                    System.out.print("Enter amount to deposit: ");
                    depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
    
        
                    break;
                case 4:
 
                    System.out.println("enter the account number");
                    accountno=scanner.nextInt();
                    System.out.println("enter the amount of money you want to transfer");
                    transfer=scanner.nextInt();
                   account.transferMoney(transfer);
                  
    
                    break;
                case 5:
                    System.out.println("Thank you for using ATM!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 5);
    }
}
