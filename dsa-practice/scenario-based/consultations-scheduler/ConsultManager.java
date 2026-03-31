import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConsultManager {
    private Map<String, List<Doctor>> map = new HashMap<>();
    private List<Appointment> history = new ArrayList<>();

    public void addDoctor(Doctor doctor){
        map.computeIfAbsent(doctor.getSpecialization(), k -> new ArrayList<>()).add(doctor);
    }

    public void bookAppointment(String specialty, Patient patient, String slot) throws SlotUnavailableException{
        List<Doctor> list = map.get(specialty);

        if(list == null || list.isEmpty()) {
            throw new SlotUnavailableException("No doctor found in this speciality!");
        }

        for(Doctor d : list){
            if(d.getAvailableSlots().contains(slot)){
                d.bookSlot(slot);
                Appointment app = new Appointment(d, patient, slot);
                history.add(app);
                System.out.println("Appointment confirmed with Dr. " + d.getName());
                return;
            }
        }

        throw new SlotUnavailableException("Selected slot not available!");
    }

    public void displayHistory(){
        System.out.println("------ Consultation History ------");
        for(Appointment a : history){
            System.out.println(a);
        }
    }
    
}
