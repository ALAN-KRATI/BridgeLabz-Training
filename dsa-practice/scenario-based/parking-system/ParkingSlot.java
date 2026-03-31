public class ParkingSlot {
    private int slot;
    private boolean occupied;
    private Vehicle vehicle;

    public ParkingSlot(int slot){
        this.slot = slot;
        this.occupied = false;
    }

    public int getSlot(){ return slot; }

    public void parkVehicle(Vehicle vehicle){
        this.vehicle = vehicle;
        this.occupied = true;
    }

    public void vacateSlot(){
        this.vehicle = null;
        this.occupied = false;
    }

    public boolean getOccupied(){ return occupied; }

    public Vehicle getParkedVehicle(){
        return vehicle;
    }
}
