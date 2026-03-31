import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class AccountManager {
    
    public int createAccount(Account account) throws Exception{
        String sql = "INSERT INTO account(holder_name, balance) values(?, ?)";

        try(Connection connection = DBConnection.getConnection(); PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            ps.setString(1, account.getAccountName());
            ps.setDouble(2, account.getBalance());

            ps.executeUpdate();
            ResultSet set = ps.getGeneratedKeys();
            if(set.next()){
                int id = set.getInt(1);
                return id;
            }
            throw new Exception("Account id not generated");
        }
        catch(Exception e){
            throw new Exception("Error adding account");
        }
    }

    public double checkBalance(int id) throws Exception{
        String sql = "Select balance FROM account WHERE account_id = ?";

        try(Connection connection = DBConnection.getConnection(); PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setInt(1, id);

            ResultSet set = ps.executeQuery();
            if(set.next()){
                double balance = set.getDouble(1);
                return balance;
            }

            throw new Exception("Account not found");
        }
    }

    public void transfer(int from, int to, double amount) throws Exception{
        Connection connection = null;

        try{
            connection = DBConnection.getConnection();
            connection.setAutoCommit(false);

            String sql = "SELECT balance FROM account WHERE account_id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, from);
            ResultSet set = ps.executeQuery();

            if(!set.next() || set.getDouble(1) < amount){
                throw new Exception("Insufficient balance");
            }

            String sql2 = "UPDATE account SET balance = balance - ? WHERE account_id = ?";
            PreparedStatement ps2 = connection.prepareStatement(sql2);
            ps2.setDouble(1, amount);
            ps2.setInt(2, from);
            ps2.executeUpdate();

            String sql3 = "UPDATE account SET balance = balance + ? WHERE account_id = ?";
            PreparedStatement ps3 = connection.prepareStatement(sql3);
            ps3.setDouble(1, amount);
            ps3.setInt(2, to);
            ps3.executeUpdate();

            String sql4 = "INSERT INTO transactions(from_account, to_account, amount) values(?, ?, ?)";
            PreparedStatement ps4 = connection.prepareStatement(sql4);
            ps4.setInt(1, from);
            ps4.setInt(2, to);
            ps4.setDouble(3, amount);
            ps4.executeUpdate();

            connection.commit();
            System.out.println("Transfer successfull");
        }
        catch(Exception e){
            if(connection != null) connection.rollback();
            System.out.println("Transfer failed: " + e.getMessage());
        }
        finally{
            if(connection != null) connection.setAutoCommit(true);
        }
    }    

    public void transactionHistory(int id) throws Exception{
        String sql = "SELECT * FROM transactions";

        try(Connection connection = DBConnection.getConnection(); PreparedStatement ps = connection.prepareStatement(sql)){
            ResultSet set = ps.executeQuery();
            boolean found = false;

            while (set.next()) {

                // print header only when first record is found
                if (!found) {
                    System.out.println("Transaction ID | From_Account | To_Account | Amount | transaction_date");
                    System.out.println("-----------------------------------------------------------------------");
                }

                found = true;

                System.out.println(
                        set.getInt("txn_id") + " | " +
                        set.getInt("from_account") + " | " +
                        set.getInt("to_account") + " | " +
                        set.getDouble("amount") + " | " +
                        set.getDate("txn_date")
                );
            }

            // if no employees
            if (!found) {
                throw new Exception("No logs found in database.");
            }
        }
    }
}
