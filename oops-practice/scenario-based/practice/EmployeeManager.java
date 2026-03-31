class Employee{
    private String name;
    private String jobTitle;
    private int salary;

    public Employee(String name, String jobTitle, int salary){
        this.name = name;
        this.jobTitle = jobTitle;
        this.salary = salary;
    }

    public String getName(){ return name; }
    public String getJobTitle(){ return jobTitle; }
    public int getSalary(){ return salary; }

    public void setSalary(int newSalary){
        this.salary = newSalary;
    }

    public void calculateSalary(int workingDays){
        int newSalary = 500*workingDays;
        setSalary(newSalary);
    }

    public String toString(){
        return name + " | " + jobTitle + " | " + salary;
    }
}
public class EmployeeManager{
    public static void main(String[] args){
        Employee e1 = new Employee("Alice", "engineer", 40000);
        Employee e2 = new Employee("Bob", "Sales", 25000);

        System.out.println(e1);
        System.out.println(e2);

        e2.setSalary(3000);
        System.out.println("\nAfter setting the salary");
        System.out.println(e2);

        System.out.println("\nCalculating salary for 27 working days: ");
        e1.calculateSalary(27);
        System.out.println(e1);
    }
}
