import java.sql.*;

public class EmployeeManager {
    
    public int addEmployee(Employee em) throws EmployeeException, SQLException{
        String sql = "INSERT INTO employee(name, department, salary) values(?, ?, ?)";

        try(Connection connection = DBConnection.getConnection(); PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            ps.setString(1, em.getEmployeeName());
            ps.setString(2, em.getDepartment());
            ps.setDouble(3, em.getSalary());
            
            ps.executeUpdate();
            ResultSet set = ps.getGeneratedKeys();
            if(set.next()){
                return set.getInt(1);
            }

            throw new EmployeeException("Employee ID is not generated.");
        }
        catch(SQLException e){
            e.printStackTrace();
            throw new EmployeeException("Error adding employee..");
        }
    }

    public void updateEmployeeSalary(int employeeId, double salary) throws EmployeeException, SQLException{
        String sql = "UPDATE employee SET salary = ? WHERE Id = ?";

        try(Connection connection = DBConnection.getConnection(); PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setDouble(1, salary);
            ps.setInt(2, employeeId);

            if(ps.executeUpdate() > 0){
                System.out.println("Employee salary updated");
            }
            else throw new EmployeeException("Employee not found.");
        }
    }

    public void deleteEmployee(int employeeId) throws EmployeeException, SQLException{
        String sql = "DELETE FROM employee WHERE id = ?";

        try(Connection connection = DBConnection.getConnection(); PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setInt(1, employeeId);

            if(ps.executeUpdate() > 0){
                System.out.println("Employee deleted");
            }
            else throw new EmployeeException("Employee not found.");
        }
    }

    public void searchEmployeeByName(String name) throws EmployeeException, SQLException{
        String sql = "SELECT * FROM employee WHERE name = ?";

        try(Connection connection = DBConnection.getConnection(); PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setString(1, name);

            ResultSet set = ps.executeQuery();
            while(set.next()){
                System.out.println(
                    set.getInt("id") + " | " +
                    set.getString("name") + " | " +
                    set.getString("department") + " | " +
                    set.getDouble("salary")
                );
            }
        }
    }

    public void viweAllEmployees() throws EmployeeException, SQLException {

    String sql = "SELECT * FROM employee";

    try (Connection connection = DBConnection.getConnection();
         PreparedStatement ps = connection.prepareStatement(sql);
         ResultSet set = ps.executeQuery()) {

        boolean found = false;

        while (set.next()) {

            // print header only when first record is found
            if (!found) {
                System.out.println("Employee ID | Employee Name | Department | Salary");
                System.out.println("----------------------------------------------------");
            }

            found = true;

            System.out.println(
                    set.getInt("id") + " | " +
                    set.getString("name") + " | " +
                    set.getString("department") + " | " +
                    set.getDouble("salary")
            );
        }

        // if no employees
        if (!found) {
            throw new EmployeeException("No employees found in database.");
        }
    }
}
}
