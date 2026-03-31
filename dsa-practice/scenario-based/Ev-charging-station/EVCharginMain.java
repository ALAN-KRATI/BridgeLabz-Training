public class EVCharginMain {
    public static void main(String[] args){
        PricingStrategy strategy = new PeakPricing();
        ChargingManager manager = new ChargingManager(2, strategy);

        manager.addVehicle(new Vehicle("123", 12));
        manager.addVehicle(new Vehicle("234", 8));
        manager.addVehicle(new Vehicle("345", 10));

        try{
            manager.allocateVehicle();
            manager.allocateVehicle();
            manager.allocateVehicle();
        }
        catch(NoChargingSlotAvailableException e){
            System.out.println(e.getMessage());
        }
    }
}
