public class CompanyEmpWage {

    public final String companyName;
    public final int wagePerHour;
    public final int maxWorkingDays;
    public final int maxWorkingHours;

    private int totalEmpWage;

    public CompanyEmpWage(String companyName, int wagePerHour, int maxWorkingDays, int maxWorkingHours) {
        this.companyName = companyName;
        this.wagePerHour = wagePerHour;
        this.maxWorkingDays = maxWorkingDays;
        this.maxWorkingHours = maxWorkingHours;
    }

    public void setTotalEmpWage(int totalEmpWage) {
        this.totalEmpWage = totalEmpWage;
    }

    public int getTotalEmpWage() {
        return totalEmpWage;
    }

    @Override
    public String toString() {
        return "Total Wage for " + companyName + " = " + totalEmpWage;
    }
}