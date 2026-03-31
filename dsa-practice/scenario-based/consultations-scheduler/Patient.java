public class Patient {
    private String name;
    private int age;

    public Patient(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName(){ return name; }
}

class Appointment{
    private Doctor doctor;
    private Patient patient;
    private String slot;

    public Appointment(Doctor doctor, Patient patient, String slot){
        this.doctor = doctor;
        this.patient = patient;
        this.slot = slot;
    }

    public String toString(){
        return patient.getName() + " consulted Dr. " + doctor.getName() + "(" + doctor.getSpecialization() + ")" + " at " + slot;
    }
}
