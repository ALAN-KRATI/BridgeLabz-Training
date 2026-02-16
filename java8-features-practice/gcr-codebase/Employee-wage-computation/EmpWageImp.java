import java.util.*;

public class EmpWageImp implements EmpWage {

    private List<CompanyEmpWage> companyList = new ArrayList<>();
    private Map<String, CompanyEmpWage> companyMap = new HashMap<>();

    public void addCompanyEmpWage(String company, int wagePerHour, int maxDays, int maxHours) {
        CompanyEmpWage comp = new CompanyEmpWage(company, wagePerHour, maxDays, maxHours);
        companyList.add(comp);
        companyMap.put(company, comp);
    }

    private void computeCompanyWage(CompanyEmpWage company) {

        int totalHours = 0;
        int totalDays = 0;
        int totalWage = 0;

        Random random = new Random();

        while (totalHours < company.maxWorkingHours && totalDays < company.maxWorkingDays) {

            totalDays++;

            int empCheck = random.nextInt(3); 
            int empHours = 0;

            switch(empCheck) {
                case 1: empHours = 4; break; 
                case 2: empHours = 8; break; 
                default: empHours = 0;
            }

            totalHours += empHours;
            int dailyWage = empHours * company.wagePerHour;
            totalWage += dailyWage;

            System.out.println(company.companyName +
                    " Day " + totalDays +
                    " Hours: " + empHours +
                    " Daily Wage: " + dailyWage);
        }

        company.setTotalEmpWage(totalWage);
    }

    public void computeEmpWages() {
        companyList.forEach(this::computeCompanyWage);
    }
    
    public int getTotalWage(String company) {
        return companyMap.get(company).getTotalEmpWage();
    }
}