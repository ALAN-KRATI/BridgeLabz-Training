import java.util.*;
import java.util.stream.*;

public class AppointmentManager {
    private List<Appointment> appointments;

    public AppointmentManager(List<Appointment> appointments){
        this.appointments = appointments;
    }

    public List<Appointment> filterByDoctor(String doctor){
        return appointments.stream()
                .filter(d -> d.getDoctorName().equalsIgnoreCase(doctor))
                .collect(Collectors.toList());
    }

    public List<Appointment> filterByDepartment(String department){
        return appointments.stream()
                .filter(d -> d.getDepartment().equalsIgnoreCase(department))
                .collect(Collectors.toList());
    }

    public Map<String, List<Appointment>> groupByDoctor(){
        return appointments.stream()
                .collect(Collectors.groupingBy(Appointment::getDoctorName));
    }

    public Map<String, Long> countByDepartment(){
        return appointments.stream()
                .collect(
                    Collectors.groupingBy(
                        Appointment::getDepartment,
                        Collectors.counting()
                    )
                );
    }

    public List<Appointment> sortByDate(){
        return appointments.stream()
                .sorted(Comparator.comparing(Appointment::getDate))
                .collect(Collectors.toList());
    }
}
