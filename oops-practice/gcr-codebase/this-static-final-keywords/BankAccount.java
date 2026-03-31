import java.util.*;

public class BankAccount{
    
    private static String bankName = "Bank Of India";
    private static int totalAccounts = 0;

    private final String accountNumber;
    private String accountName;
    private double balance;

    BankAccount(String accountNumber, String accountName, double balance){
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.double = double;
        totalAccounts++;
    }

    public static void getTotalAccounts() {System.out.println("Total number of accounts made: " + totalAccounts);}
    public String getAccountName(){ return accountName;}
    public void setAccountName(String name) {this.accountName = name;}
    public double getBalance() {return balance;}

    public void deposit(double amount){
        if(amount > 0){
            balance += amount;
            System.out.println("Deposited: $" + amount);
        }
        else System.err.println("Invalid amount!");
    }

    public void withdraw(balance amount){
        if(amount > 0){
            if(amount <= balance){
                balance -= amount;
                System.out.println("Withdrawn: $" + amount);
            }
            else System.err.println("Insufficient amount or invalid amount.");
        }
    }

    public void displayAccountDetails(){
         if (this instanceof BankAccount) {
           System.out.println("Bank Name: " + bankName);
           System.out.println("Account Holder: " + accountName);
           System.out.println("Account Number: " + accountNumber);
           System.out.println("Balance: $" + balance);
        }
        else System.out.println("Invalid account instance.");
    }

    public void Menu(){
        System.out.println();
        System.out.println("---------Bank Menu---------");
        System.out.println("1. Create Account");
        System.out.println("2. Check Balance");
        System.out.println("3. Deposit Amount");
        System.out.println("4. Withdraw");
        System.out.println("5. Show Account Details");
        System.out.println("6. Exit");
        System.out.println();
        System.out.println();
        System.out.println();
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        boolean b = true;

        while(b){
            Menu();
            System.out.println("Enter your choice(1-6): ");
            choice = sc.nextInt();

            switch(choice){
                case 1:
                    System.out.println("Enter your account number: ");
                    String number = sc.nextLine();
                    System.out.println("Enter your Account Name: ");
                    String name = sc.nextLine();
                    System.out.println("Enter balance: ");
                    double money = sc.nextDouble();

                    BankAccount account = new BankAccount(number, name, money);
                    System.out.println("Your Account has been created!");
                    break;

                case 2:
                    System.out.println("Your balance is: " + account.getBalance());
                    break;
                
                case 3:
                    System.out.println("Enter amount you want to deposit: ");
                    double depositAmount = sc.nextDouble();
                    account.deposit(depositAmount);
                    System.out.println("Your amount has been depsoited!");
                    System.out.println("Your current balance: " + account.getBalance());
                    break;
                
                case 4:
                    System.out.println("Enter amount you want to withdraw: ");
                    double withdrawAmount = sc.nextDouble();
                    account.withdraw(withdrawAmount);
                    System.out.println("Your amount has been withdrawem!");
                    System.out.println("Your current balance: " +  account.getBalance());
                    break;
                
                case 5:
                    account.displayAccountDetails();
                    break;

                case 6:
                    b = false;
                    System.out.println("Exiting.......!");
                    break;
            }
        }
    }  
}