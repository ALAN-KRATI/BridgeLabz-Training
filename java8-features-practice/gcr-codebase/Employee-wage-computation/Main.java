public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Employee Wage Computation Program");

        EmpWage empWage = new EmpWageImp();

        empWage.addCompanyEmpWage("Reliance", 20, 20, 100);
        empWage.addCompanyEmpWage("TCS", 25, 22, 110);

        empWage.computeEmpWages();

        System.out.println("\n---- Total Wages ----");
        System.out.println("Reliance : " + empWage.getTotalWage("Reliance"));
        System.out.println("TCS : " + empWage.getTotalWage("TCS"));
    }
}