import java.util.Arrays;
import java.util.List;

public class SmartCityManagement {
    // List<TransportService> services = Arrays.asList(
    //     new BusService(),
    //     new MetroService(),
    //     new TaxiService(),
    //     new FireService()
    // );

    List<Passenger> passengers = Arrays.asList(
        new Passenger("Alice", 700.0, "Mathura-agra", new TaxiService()),
        new Passenger("Bob", 420.0, "Agra - Delhi", new BusService()),
        new Passenger("Claude", 80.0, "Pari chowk - capgemini", new MetroService()),
        new Passenger("Olive", 0.0, "Emergency Route", new FireService())
    );

    public static void main(String[] args){

    }

}
