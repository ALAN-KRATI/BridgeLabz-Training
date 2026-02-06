import java.util.Comparator;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

class Employee{
    private String name;
    private int salary;

    public Employee(String name, int salary){
        this.name = name;
        this.salary = salary;
    }

    public String getName(){ return name; }
    public int getSalary(){ return salary; }

    public String toString(){
        return name + " -> " + salary;
    }
}

public class HighestSalary {
    public static void main(String[] args){
        Set<Employee> employees = new HashSet<>();
        employees.add(new Employee("Alice", 25000));
        employees.add(new Employee("Bob", 30000));
        employees.add(new Employee("Olive", 20000));
        employees.add(new Employee("Jack", 45000));

        Optional<Employee> em = employees.stream().max(Comparator.comparing(Employee::getSalary));

        System.out.println("Employee with highest salary: " + em);
    }
}
