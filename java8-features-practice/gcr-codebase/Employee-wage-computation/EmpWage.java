public interface EmpWage {
    void addCompanyEmpWage(String company, int wagePerHour, int maxDays, int maxHours);
    void computeEmpWages();
    int getTotalWage(String companyName);
}