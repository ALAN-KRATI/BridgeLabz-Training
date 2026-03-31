import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import javax.naming.InsufficientResourcesException;

public class ReliefManager {
    private Map<String, ReliefCenter> centers = new HashMap<>();
    private Queue<AreaRequest> requests = new LinkedList<>();

    public void addReliefCenter(ReliefCenter center){
        centers.put(center.getCenter(), center);
    }

    public void addRequest(AreaRequest request){
        requests.offer(request);
    }

    public void allocateResource(String center) throws InsufficientResourceException{
        ReliefCenter center1 = centers.get(center);

        if(center1 ==  null){
            System.out.println("Relief Center not found!");
            return;
        }

        while(!requests.isEmpty()){
            AreaRequest r = requests.poll();
            Map<String, Integer> stock = center1.getResources();

            for(Map.Entry<String, Integer> entry : r.getRequestedResource().entrySet()){
                String item = entry.getKey();
                int need = entry.getValue();

                if(stock.getOrDefault(item, 0) < need){
                    throw new InsufficientResourceException("Not enough " + item + " for area: " + r.getArea());
                }
            }

            for(Map.Entry<String, Integer> entry : r.getRequestedResource().entrySet()){
                String item = entry.getKey();
                int need = entry.getValue();

                stock.put(item, stock.get(item) - need);
            }

            System.out.println("Resources allocated to " + r.getArea());
        }
    }

}
