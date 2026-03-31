import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class ChargingManager {
    private Map<Integer, ChargingSlot> slots = new HashMap<>();
    private Queue<Vehicle> waitingqueue = new LinkedList<>();
    private PricingStrategy strategy;

    public ChargingManager(int totalSlots, PricingStrategy type){
        this.strategy = type;
        for(int i = 1; i <= totalSlots; i++){
            slots.put(i, new ChargingSlot(i));
        }
    }

    public void addVehicle(Vehicle v){
        waitingqueue.offer(v);
    }

    public void allocateVehicle() throws NoChargingSlotAvailableException{
        if(waitingqueue.isEmpty()){
            System.out.println("No Vehicles Left!");
            return;
        }

        ChargingSlot emptySlot = null;

        for(ChargingSlot s : slots.values()){
            if(!s.isOccupied()){
                emptySlot = s;
                break;
            }
        }

        if(emptySlot == null){
            throw new NoChargingSlotAvailableException("No charging slot is available!");
        }

        Vehicle v = waitingqueue.poll();

        emptySlot.chargeVehicle(v);
        double bill = strategy.calculateBill(v.getUnitsConsumed());

        System.out.println("Vehicle " + v.getVehicleNumber() + " assigned slot -> " + emptySlot.getSlotId() + " | Bill: " + bill);

        //emptySlot.vacateChargingSlot();
    }
}
