import java.util.*;
import java.time.*;

public class HospitalAppointmentManager {
    public static void main(String[] args){
        List<Appointment> appointments = List.of(
            new Appointment("Amit", "Dr. Sharma", "Cardiology",
                    LocalDate.of(2026, 2, 10)),
            new Appointment("Neha", "Dr. Sharma", "Cardiology",
                    LocalDate.of(2026, 2, 11)),
            new Appointment("Rahul", "Dr. Mehta", "Orthopedics",
                    LocalDate.of(2026, 2, 10)),
            new Appointment("Priya", "Dr. Singh", "Neurology",
                    LocalDate.of(2026, 2, 12)),
            new Appointment("Karan", "Dr. Mehta", "Orthopedics",
                    LocalDate.of(2026, 2, 13))
        );

        AppointmentManager manager = new AppointmentManager(appointments);

        System.out.println("Appointments for Dr. Sharma:");
        manager.filterByDoctor("Dr. Sharma").forEach(System.out::println);

        System.out.println("\nOrthopedics Appointments:");
        manager.filterByDepartment("Orthopedics").forEach(System.out::println);

        System.out.println("\nAppointments Grouped by Doctor:");
        Map<String, List<Appointment>> grouped = manager.groupByDoctor();
        grouped.forEach((doctor, list) -> {
            System.out.println(doctor);
            list.forEach(a -> System.out.println("  " + a));
        });

        System.out.println("\nAppointment Count per Department:");
        manager.countByDepartment().forEach((dept, count) ->
                System.out.println(dept + " : " + count)
            );
        
        System.out.println("Appointments sorted by dates:");
        manager.sortByDate().forEach(System.out::println);

    }
}
