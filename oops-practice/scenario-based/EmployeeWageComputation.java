import java.util.*;

public class EmployeeWageComputation{

    // Displays Program's name
    public static void display(){
        System.out.println("\n\nWelcome to Employee Wage Computation Program!");
    }

    // Checks if an employee is present or not.
    public static void employeeAttendance(){
        Random random = new Random();
        // will randomly generate either 0 or 1.
        int attendance = random.nextInt(2);

        // 1 means the employee is present.
        if(attendance == 1){
            System.out.println("Present!");
        }
        else {
            System.out.println("Absent!");
        }
    }

    // Calculates a employee's day wage.
    public static void employeeDailyWage(){
        Random random = new Random();
        int present = random.nextInt(2);
        int rate = 20;
        int employeehrs = 0, employeeWage = 0;

        if(present == 1){
            employeehrs = 8;
        }
        
        employeeWage = employeehrs * rate;

        System.out.println("Employee Today's Wage: " + employeeWage);
    }

    // Calculate wages based on if employee is partime or fulltime.
    public static void employeePartWage(){
        Random random = new Random();
        // will randomly generate either 0, 1 or 2.
        int present = random.nextInt(3);
        int empHrs = 0, empWage = 0, rate = 20;

        // 1 is for fulltime employees.
        if(present == 1){
            empHrs = 8;
        }
        // 2 is for partime employees.
        else if(present == 2){
            empHrs = 4;
        } 
        else {
            empHrs = 0;
        }

        empWage = empHrs * rate;

        System.out.println("Employee Wage: " + empWage);
    }

    // Calculates employee's wages based on switch case.
    public static void employeeWageSwitch(){
        Random random = new Random();
        int present = random.nextInt(3);
        int empHrs = 0, empWage = 0;
        int rate = 20;

        switch(present){
            case 1:
                empHrs = 8;
                break;
            case 2: 
                empHrs = 4;
                break;
            default:
                empHrs = 0;
                break;
        }

        empWage = empHrs * rate;
        System.out.println("Employee Wage through switch case: " + empWage);
    }

    // Calculates employee's monthly wage.
    public static void employeeWageMonthly(){
        Random random = new Random();
        int empHrs;
        int rate = 20, empWage = 0, totalWage = 0;

        for(int i = 0; i < 20; i++){
            int present = random.nextInt(3);
            switch(present){
                case 1:
                    empHrs = 8;
                    break;
                case 2:
                    empHrs = 4;
                    break;
                default:
                    empHrs = 0;
                    break;
            }

            empWage = rate * empHrs;
            totalWage += empWage;
        }

        System.out.println("Employee's Month Wage: " + totalWage);
    }

    // Calculated employee wage if he/she has worked either 100hrs or 20 days.
    public static void employeeWageCondition(){
        Random random = new Random();
        int empHrs = 0;
        int rate = 20;
        int empWage = 0;
        int totalWage = 0;
        int totatlDays = 0; 
        int totalHrs = 0;

        while(totatlDays != 20 && totalHrs != 100){
            int present = random.nextInt(3);
            switch(present){
                case 1:
                    empHrs = 8;
                    totatlDays++;
                    break;
                case 2:
                    empHrs = 4;
                    totatlDays++;
                    break;
                default:
                    empHrs = 0;
                    break;
            }

            totalHrs += empHrs;
            empWage = rate * empHrs;
            if(empWage != 0) {
                System.out.println("Employees' Wage on day " + totatlDays + " is " + empWage);
            }
            
            totalWage += empWage;
        }

        System.out.println("Employee's Wage till 100 hrs or 20 days are reached: " + totalWage);
    }

    // Main method
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        boolean stop = false;

        while(!stop){
            display();
            // Menu to access any way of computing a Employee's Wage.
            System.out.println("\n---------- Your Options ----------");
            System.out.println("1. Check Employee's Attendance.");
            System.out.println("2. Check Employees today's salary.");
            System.out.println("3. Check Employees salary if part time.");
            System.out.println("4. Check Employee salary through switch case.");
            System.out.println("5. Check Employee's month salary.");
            System.out.println("6. Check Employee's salary if reached condition.");
            System.out.println("7. Exit.");

            int choice = sc.nextInt();

            switch(choice){
                case 1:
                    employeeAttendance();
                    break;
                case 2: 
                    employeeDailyWage();
                    break;
                case 3:
                    employeePartWage();
                    break;
                case 4:
                    employeeWageSwitch();
                    break;
                case 5:
                    employeeWageMonthly();
                    break;
                case 6:
                    employeeWageCondition();
                    break;
                default:
                    System.out.println("Exiting...");
                    stop = true;
            }
        }
    }
}