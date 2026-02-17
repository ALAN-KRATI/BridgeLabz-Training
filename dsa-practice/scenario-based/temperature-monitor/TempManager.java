import java.util.HashMap;
import java.util.Map;

public class TempManager {
    private Map<String, TemperatureLog> map = new HashMap<>();
    private static final double MIN_SAFE = 2.0;
    private static final double MAX_SAFE = 8.0;

    public void addRoom(String id){
        map.put(id, new TemperatureLog(id));
    }

    public void addTemperature(String id, double temp) throws SensorFailureException{
        TemperatureLog log = map.get(id);

        if(log == null){
            System.out.println("Room not found!");
            return;
        }

        log.addReading(temp);
        
        if(temp < MIN_SAFE || temp > MAX_SAFE){
            System.out.println("Alert: Room: " + log.getRoomId() + " has unsafe temperature " + temp);
        }
    }

    public void displayAverage(String id){
        TemperatureLog log = map.get(id);

        if(log == null){
            System.out.println("Room not found!");
            return;
        }

        double average = log.calculateAverage();
        System.out.println("Average temp of room " + log.getRoomId() + " = " + String.format("%.2f", average) + "°C");
    }
    
}
