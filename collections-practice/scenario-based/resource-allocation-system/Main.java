import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        ReliefCenter center = new ReliefCenter("Central Relief Hub");
        center.addResource("Food", 100);
        center.addResource("Water", 200);
        center.addResource("MedicalKit", 50);

        Map<String, Integer> req1 = new HashMap<>();
        req1.put("Food", 30);
        req1.put("Water", 50);

        Map<String, Integer> req2 = new HashMap<>();
        req2.put("MedicalKit", 60); 

        AreaRequest area1 = new AreaRequest("Flood Zone A", req1);
        AreaRequest area2 = new AreaRequest("Earthquake Zone B", req2);

        ReliefManager allocator = new ReliefManager();
        allocator.addReliefCenter(center);
        allocator.addRequest(area1);
        allocator.addRequest(area2);

        try {
            allocator.allocateResource("Central Relief Hub");
        } catch (InsufficientResourceException e) {
            System.out.println("Allocation Failed: " + e.getMessage());
        }
    }
}