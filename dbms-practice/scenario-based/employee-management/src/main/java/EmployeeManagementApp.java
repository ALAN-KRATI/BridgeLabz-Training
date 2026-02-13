import java.sql.SQLException;
import com.mysql.cj.jdbc.AbandonedConnectionCleanupThread;
import java.util.Scanner;

public class EmployeeManagementApp {

    public static void displayMenu(){
        System.out.println("---------- Employee Management Database ----------");
        System.out.println("1. Add Employee");
        System.out.println("2. Update Employee Salary");
        System.out.println("3. Delete Employee");
        System.out.println("4. Search Employee by name");
        System.out.println("5. View All Employees");
        System.out.println("6. Exit");
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        EmployeeManager manager = new EmployeeManager();
        boolean b = true;

        try{
            while(b){
                displayMenu();

                System.out.println("Enter your choice: ");
                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1:
                        System.out.println("Enter Employee Name: ");
                        String name = sc.nextLine();
                        System.out.println("Enter Employee department: ");
                        String department = sc.nextLine();
                        System.out.println("Enter employee Salary: ");
                        double salary = sc.nextDouble();
                        int id = manager.addEmployee(new Employee(name, department, salary));
                        System.out.println("Employee registered with ID : " + id);
                        break;
                
                    case 2:
                        System.out.println("Enter employee ID to update: ");
                        int id1 = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Enter new salary: ");
                        double newSalary = sc.nextDouble();
                        manager.updateEmployeeSalary(id1, newSalary);
                        break;
                    
                    case 3:
                        System.out.println("Enter employee id to delete: ");
                        int id2 = sc.nextInt();
                        sc.nextLine();
                        manager.deleteEmployee(id2);
                        break;
                    
                    case 4:
                        System.out.println("Enter employee name to search: ");
                        String name1 = sc.nextLine();
                        manager.searchEmployeeByName(name1);
                        break;
                    
                    case 5:
                        manager.viweAllEmployees();
                        break;
                    
                    case 6:
                        System.out.println("Thank you!");
                        AbandonedConnectionCleanupThread.checkedShutdown();
                        b = false;
                        break;
                }
            }
        }
        catch(EmployeeException e){
            System.out.println(e.getMessage());
        }
        catch(SQLException e){

        }
    }
}
