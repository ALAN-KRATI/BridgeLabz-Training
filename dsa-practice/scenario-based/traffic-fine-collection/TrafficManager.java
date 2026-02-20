import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class TrafficManager {
    private Map<String, List<Voilation>> records = new HashMap<>();
    private static final Pattern pattern = Pattern.compile("^[A-Z]{2}\\d{2}[A-Z]{2}\\d{4}$");

    private void validateVehicle(String vehicleNo) throws InvalidVehicleException{
        if(vehicleNo == null || !pattern.matcher(vehicleNo).matches()){
            throw new InvalidVehicleException("Invalid Vehicle No: " + vehicleNo);
        }
    }

    public void addVoilation(String vehicleNo, Voilation v) throws InvalidVehicleException{
        validateVehicle(vehicleNo);
        records.computeIfAbsent(vehicleNo, k -> new ArrayList<>()).add(v);
        System.out.println("Voilation recorded!");
    }

    public double calculateFine(String vehicleNo) throws InvalidVehicleException{
        validateVehicle(vehicleNo);
        List<Voilation> list = records.get(vehicleNo);
        if(list == null) return 0;

        double total = 0;
        for(Voilation v : list){
            total += v.calculateFine();
        }

        if(list.size() > 2){
            total += total * 0.25;
        }

        return total;
    }

    public void generateMonthlyReport(){
        Month currentMonth = LocalDate.now().getMonth();
        System.out.println("---------- Monthly Fine Report ----------");
        for(String n: records.keySet()){
            double total = 0;
            for(Voilation v: records.get(n)){
                if(v.getDate().getMonth() == currentMonth){
                    total += v.calculateFine();
                }
            }

            if(total > 0) System.out.println(n + " : " + total);
        }
    }
}
