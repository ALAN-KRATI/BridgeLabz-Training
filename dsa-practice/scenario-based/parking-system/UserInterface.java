public class UserInterface {
    public static void main(String[] args) {
        ParkingManager manager = new ParkingManager(3);

        manager.addVehicle(new Car("UP32AB1234", "Riya"));
        manager.addVehicle(new Bike("UP32XY9876", "Aman"));
        manager.addVehicle(new Car("UP32CD4567", "Kunal"));
        manager.addVehicle(new Bike("UP32GH2222", "Sneha")); // extra

        try {
            manager.allocateSlot();
        } catch (NoParkingSlotAvailableException e) {
            System.out.println(e.getMessage());
        }

        manager.displayParkingStatus();
    }
}