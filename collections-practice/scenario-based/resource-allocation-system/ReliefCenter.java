import java.util.HashMap;
import java.util.Map;

public class ReliefCenter {
    private String center;
    private Map<String, Integer> resources = new HashMap<>();

    public ReliefCenter(String center){
        this.center = center;
    }

    public void addResource(String item, int quantity){
        resources.put(item, resources.getOrDefault(item, 0) + quantity);
    }

    public String getCenter(){ return center; }
    public Map<String, Integer> getResources(){ return resources; }
}
