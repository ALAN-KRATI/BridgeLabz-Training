import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        TrafficManager system = new TrafficManager();

        try {
            system.addVoilation("UP32AB1234", new SpeedVoilation(LocalDate.now(), "Hazratganj", 25));
            system.addVoilation("UP32AB1234", new NoHelmetVoilation(LocalDate.now(), "Aliganj"));
            system.addVoilation("UP32AB1234", new SignalJumpVoilation(LocalDate.now(), "Charbagh"));
            system.addVoilation("DL01XY9999", new SignalJumpVoilation(LocalDate.now(), "Airport Road"));

            double fine = system.calculateFine("UP32AB1234");
            System.out.println("Total Fine: ₹" + fine);

     
            system.generateMonthlyReport();

        } catch (InvalidVehicleException e) {
            System.out.println(e.getMessage());
        }
    }
}