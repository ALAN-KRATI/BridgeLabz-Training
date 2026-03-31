import java.util.Scanner;
import com.mysql.cj.jdbc.AbandonedConnectionCleanupThread;

public class BankingApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        AccountManager manager = new AccountManager();

        while (true) {

            System.out.println("\n====== Banking System ======");
            System.out.println("1. Create Account");
            System.out.println("2. Check Balance");
            System.out.println("3. Transfer Money");
            System.out.println("4. Transaction History");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            try {

                switch (choice) {

                    // CREATE ACCOUNT
                    case 1:
                        sc.nextLine();
                        System.out.print("Enter Account Holder Name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter Initial Deposit: ");
                        double deposit = sc.nextDouble();

                        int id = manager.createAccount(new Account(name, deposit));
                        System.out.println("Account created successfully. Account ID: " + id);
                        break;

                    // CHECK BALANCE
                    case 2:
                        System.out.print("Enter Account ID: ");
                        int accId = sc.nextInt();

                        double balance = manager.checkBalance(accId);
                        System.out.println("Current Balance: ₹" + balance);
                        break;

                    // TRANSFER MONEY (TRANSACTION)
                    case 3:
                        System.out.print("From Account ID: ");
                        int from = sc.nextInt();

                        System.out.print("To Account ID: ");
                        int to = sc.nextInt();

                        System.out.print("Enter Amount: ");
                        double amount = sc.nextDouble();

                        manager.transfer(from, to, amount);
                        break;

                    // TRANSACTION HISTORY
                    case 4:
                        System.out.print("Enter Account ID: ");
                        int historyId = sc.nextInt();

                        manager.transactionHistory(historyId);
                        break;

                    // EXIT
                    case 5:
                        System.out.println("Thank you for using Banking System!");
                        sc.close();

                        // stops MySQL cleanup thread
                        AbandonedConnectionCleanupThread.checkedShutdown();
                        return;

                    default:
                        System.out.println("Invalid choice!");
                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}