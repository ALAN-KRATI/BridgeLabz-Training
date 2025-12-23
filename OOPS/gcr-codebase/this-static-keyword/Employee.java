import java.util.*;

public class Employee{
    private static String companyName;
    private static int totalEmployees = 0;

    private String employeeName;
    private final int employeeId;
    private String position;

    public Employee(String employeeName, int employeeId, String position){
        this.employeeName = employeeName;
        this.employeeId = employeeId;
        this.position = position;
        totalEmployees++;
    } 

    public static void setCompanyName(String name) { companyName = name; }
    public static void displayCompanyName() { System.out.println("Company Name: " + companyName); }
    public static void displayTotalEmployees() { System.out.println("Total Employees: " + totalEmployees); }

    public String getEmployeeName() { return employeeName; }
    public int getEmployeeId() { return employeeId; }
    public String getPosition() { return position; }

    public void displayEmployeeDetails(){
        if(this instanceof Employee){
            System.out.println("Employee ID: " + employeeId);
            System.out.println("Employee Name: " + employeeName);
            System.out.println("Employee Designation: " + position);
        }
        else {
            System.out.println("Invalid instance!");
        }
    }

    public static void main(String[] args){
        Employee.setCompanyName("Capgemini");

        System.out.println();
        Employee.displayCompanyName();
        System.out.println();
        System.out.println();

        Employee employee1 = new Employee("Alankrati", 21346, "Software Engineer");
        Employee employee2 = new Employee("Ayushi", 34261, "Software Engineer");

        Employee.displayTotalEmployees();
        System.out.println();
        System.out.println();
        

        employee1.displayEmployeeDetails();
        System.out.println();
        System.out.println();
        employee2.displayEmployeeDetails();
    }


}