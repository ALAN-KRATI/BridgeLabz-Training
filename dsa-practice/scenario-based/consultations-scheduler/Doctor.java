import java.util.ArrayList;
import java.util.List;

public class Doctor {
    private String name;
    private String specialization;
    private List<String> availableSlots = new ArrayList<>();

    public Doctor(String name, String specialization){
        this.name = name;
        this.specialization = specialization;
    }

    public String getName(){ return name; }
    public String getSpecialization(){ return specialization; }
    public List<String> getAvailableSlots(){ return availableSlots; }

    public void addSlot(String s){
        availableSlots.add(s);
    }

    public void bookSlot(String s){
        availableSlots.remove(s);
    }
}
