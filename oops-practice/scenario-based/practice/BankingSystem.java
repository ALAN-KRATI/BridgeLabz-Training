import java.util.ArrayList;
import java.util.List;

class Account{
    private String accountId;
    private String accountName;
    private double balance;

    public Account(String accountId, String accountName, double balance){
        this.accountId = accountId;
        this.accountName = accountName;
        this.balance = balance;
    }

    public String getAccountId(){ return accountId; }
    public String getAccountName(){ return accountName; }
    public double getBalance(){ return balance; }
    public void setBalace(double newBalance){ this.balance = newBalance; }

    public String toString(){
        return accountId + " | " + accountName + " | " + balance;
    }
}

class AccountUtil{
    private List<Account> accounts = new ArrayList<>();

    public void addAccount(Account a){
        accounts.add(a);
        System.out.println("Account saved successfully.");
    }

    public void removeAccount(Account a){
        accounts.remove(a);
        System.out.println("Account removed successfully");
    }

    public void deposit(String accountId, double amount){
        Account a = null;
        for(Account acc : accounts){
            if(acc.getAccountId().equalsIgnoreCase(accountId)){
                a = acc;
            }
        }

        if(amount > 0 && a != null){
            a.setBalace(a.getBalance() + amount);
        }
        else{
            System.out.println("Invalid Id/Amount");
        }
    }

    public void withdraw(String accountId, double amount){
        Account a = null;
        for(Account acc : accounts){
            if(acc.getAccountId().equalsIgnoreCase(accountId)){
                a = acc;
            }
        }

        if(a.getBalance() >= amount  && a != null){
            a.setBalace(a.getBalance() - amount);
        }
        else{
            System.out.println("Invalid Id/Amount");
        }
    }

    public void displayAccounts(){
        for(Account acc : accounts){
            System.out.println(acc);
        }
    }
}


public class BankingSystem {
    public static void main(String[] args){
        AccountUtil util = new AccountUtil();

        Account a1 = new Account("AC-101", "Alice", 10000);
        Account a2 = new Account("AC-102", "Bob", 8000);
        util.addAccount(a1);
        util.addAccount(a2);

        util.displayAccounts();

        util.deposit("AC-101", 500);
        util.withdraw("AC-102", 2000);

        util.displayAccounts();

        util.removeAccount(a1);
        util.displayAccounts();
    }
}
