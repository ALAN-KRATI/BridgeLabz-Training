import java.time.LocalDate;

class Appointment{
    private String patientName;
    private String doctorName;
    private String department;
    LocalDate date;

    public Appointment(String patientName, String doctorName, String department, LocalDate date){
        this.patientName = patientName;
        this.doctorName = doctorName;
        this.department = department;
        this.date = date;
    }

    public String getPatientName(){ return patientName; }
    public String getDoctorName(){ return doctorName; }
    public String getDepartment(){ return department; }
    public LocalDate getDate(){ return date; }

    @Override
    public String toString(){
        return patientName + " -> " + doctorName + " -> " + department + " -> " + date;
    }
}