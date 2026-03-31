public class Account {
    private int accountId;
    private String accountName;
    private double balance;

    public Account(){}

    public Account(String accountName, double balance){
        this.accountName = accountName;
        this.balance = balance;
    }

    public int getAccountId(){ return accountId; }
    public String getAccountName(){ return accountName; }
    public double getBalance(){ return balance; }

    public void setAccountId(int id){ this.accountId = id;}
    public void setAccountName(String name){this.accountName = name;}
    public void setBalance(double balance){ this.balance = balance;}
}
