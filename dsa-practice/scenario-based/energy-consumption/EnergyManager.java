import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EnergyManager {
    private Map<String, List<Double>> energyReadings = new HashMap<>();

    public void addEnergyReading(String date, double reading) throws InvalidEnergyReadingException{
        if(reading < 0 || reading > 10000){
            throw new InvalidEnergyReadingException("Invalid energy units consumed!");
        }
        energyReadings.computeIfAbsent(date, k -> new ArrayList<>()).add(reading);
    }

    Map<String, Double> dailyAverage = new HashMap<>();
    public void calculateDailyAverage(){
        for(String s : energyReadings.keySet()){
            double count = 0;
            for(double i : energyReadings.get(s)){
                count += i;
            }
            dailyAverage.put(s, count/energyReadings.get(s).size());
        }

        dailyAverage.forEach((k, v) -> System.out.println(k + " -> " + v));
    }

    public double calculateMontlyReading(){
        double total = 0;
        double size = 0;
        for(double i : dailyAverage.values()){
            total += i;
        }

        return total/dailyAverage.size();
    }
}
