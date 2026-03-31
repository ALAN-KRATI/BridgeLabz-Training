public class ChargingSlot {
    private int SlotId;
    private boolean occupied;
    private Vehicle vehicle;

    public ChargingSlot(int SlotId){
        this.SlotId = SlotId;
        this.occupied = false;
        this.vehicle = null;
    }

    public int getSlotId(){ return SlotId;}
    public Vehicle getVehicle(){ return vehicle; }
    public boolean isOccupied(){ return occupied; }

    public void chargeVehicle(Vehicle vehicle){
        this.vehicle = vehicle;
        occupied = true;
    }

    public void vacateChargingSlot(){
        this.vehicle = null;
        occupied = false;
    }
}
