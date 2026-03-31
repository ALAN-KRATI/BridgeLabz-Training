import java.util.*;

public class TemperatureLog {
    private String roomId;
    private List<Double> reading = new ArrayList<>();

    public TemperatureLog(String roomId){
        this.roomId = roomId;
    }

    public String getRoomId(){ return roomId; }
    public List<Double> getReadings(){ return reading; }

    public void addReading(double r) throws SensorFailureException{
        if(r < -50 || r > 100){
            throw new SensorFailureException("Sensor Failure! " + roomId);
        }
        reading.add(r);
    }

    public double calculateAverage(){
        double t = 0.0;
        for(double i : reading){
            t += i;
        }

        return t/reading.size();
    }
}
