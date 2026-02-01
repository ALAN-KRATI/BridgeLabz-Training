import java.util.ArrayList;
import java.util.List;

public class HospitalManager{
    private static HospitalManager instance;
    private List<MedicalReport> appointments = new ArrayList<>();
    private List<Observer> patients = new ArrayList<>();

    private HospitalManager(){ System.out.println("Database connected."); }

    public static synchronized HospitalManager getInstance(){
        if(instance == null){
            instance = new HospitalManager();
        }

        return instance;
    }

    public void addPatient(Observer p){ patients.add(p); }
    public void removePatient(Observer p){ patients.remove(p); }

    public void addAppointment(MedicalReport a){
        appointments.add(a);
        notifyAllPatients(a);
    }

    public void notifyAllPatients(MedicalReport a){
        for(Observer p: patients){
            p.update("Appointment diagnosis result: " + a.getDiagnosis());
        }
    }
}