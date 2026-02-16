public class Employee {
    private String empId;
    private String empName;
    private String contact;

    public Employee(String empId, String empName, String contact){
        this.empId = empId;
        this.empName = empName;
        this.contact = contact;
    }

    public String getEmpId(){ return empId; }
    public String getEmpName(){ return empName; }
    public String getContact(){ return contact; }

    public String toString(){
        return empId + " - " + empName;
    }
}
