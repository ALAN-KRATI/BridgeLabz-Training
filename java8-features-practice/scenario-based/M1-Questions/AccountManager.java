import java.util.*;

class Account {
    String accountNumber;
    String holderName;
    double balance;

    Account(String a, String h, double b) {
        accountNumber = a;
        holderName = h;
        balance = b;
    }

    void deposit(int amt) {
        balance += amt;
    }

    boolean withdraw(int amt) {
        return false;
    }
}

class SavingsAccount extends Account {
    SavingsAccount(String a, String h, double b) {
        super(a, h, b);
    }

    boolean withdraw(int amt) {
        double total = amt + 2;
        if (balance - total < 0)
            return false;
        balance -= total;
        return true;
    }
}

class CurrentAccount extends Account {
    CurrentAccount(String a, String h, double b) {
        super(a, h, b);
    }

    boolean withdraw(int amt) {
        double total = amt + 5;
        if (balance - total < -10000)
            return false;
        balance -= total;
        return true;
    }
}

class BusinessAccount extends Account {
    BusinessAccount(String a, String h, double b) {
        super(a, h, b);
    }

    boolean withdraw(int amt) {
        double charge = amt * 0.01;
        double total = amt + charge;
        if (balance - total < -50000)
            return false;
        balance -= total;
        return true;
    }
}

public class AccountManager {

    static List<Account> list = new ArrayList<>();

    static Account find(String id) {
        for (Account a : list)
            if (a.accountNumber.equals(id))
                return a;
        return null;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            String[] p = sc.nextLine().split(" ");

            if (p[0].equals("Create")) {

                String id = p[1];
                String name = p[2];
                String type = p[3];
                double bal = Double.parseDouble(p[4]);

                if (type.equals("SavingsAccount"))
                    list.add(new SavingsAccount(id, name, bal));
                else if (type.equals("CurrentAccount"))
                    list.add(new CurrentAccount(id, name, bal));
                else
                    list.add(new BusinessAccount(id, name, bal));

                System.out.println("Account Created: " + id);
            }

            else if (p[0].equals("Deposit")) {
                Account a = find(p[1]);
                if (a == null)
                    System.out.println("Account Not Found");
                else {
                    a.deposit(Integer.parseInt(p[2]));
                    System.out.println("Deposited Successfully");
                }
            }

            else if (p[0].equals("Withdraw")) {
                Account a = find(p[1]);
                if (a == null) {
                    System.out.println("Account Not Found");
                } else {
                    boolean ok = a.withdraw(Integer.parseInt(p[2]));
                    if (ok)
                        System.out.println("Withdrawal Successful");
                    else
                        System.out.println("Insufficient Funds");
                }
            }
        }
    }
}