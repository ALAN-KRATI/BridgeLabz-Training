import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class ParkingManager {
    private Map<Integer, ParkingSlot> map = new TreeMap<>();
    private Queue<Vehicle> queue = new LinkedList<>();

    public ParkingManager(int totalSlots) {
        for (int i = 1; i <= totalSlots; i++) {
            map.put(i, new ParkingSlot(i));
        }
    }

    public void addVehicle(Vehicle v){
        queue.offer(v);
        System.out.println("Vehicle added to queue!");
    }

    public void allocateSlot() throws NoParkingSlotAvailableException{
        while(!queue.isEmpty()){
            Vehicle vehicle = queue.peek();
            ParkingSlot slot = findNearestSlot();

            if(slot == null){
                throw new NoParkingSlotAvailableException("Parking full!");
            }

            slot.parkVehicle(vehicle);
            queue.poll();

            System.out.println(vehicle.getVehicleNumber() + " parked at slot " + slot.getSlot());
        }
    }

    private ParkingSlot findNearestSlot(){
        for(ParkingSlot s : map.values()){
            if(!s.getOccupied()){
                return s;
            }
        }

        return null;
    }

    public void displayParkingStatus(){
        System.out.println("\n--- Parking Status ---");
        for(ParkingSlot s : map.values()){
            if(s.getOccupied()){
                System.out.println("Slot " + s.getSlot() + " -> " + s.getParkedVehicle().getVehicleNumber());
            }
            else System.out.println("Slot " + s.getSlot() + " -> Empty");
        }
    }

}
