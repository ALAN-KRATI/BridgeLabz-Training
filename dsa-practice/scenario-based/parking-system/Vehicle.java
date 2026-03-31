public abstract class Vehicle {
    protected String vehicleNumber;
    protected String owner;

    public Vehicle(String vehicleNumber, String owner){
        this.vehicleNumber = vehicleNumber;
        this.owner = owner;
    }

    public String getVehicleNumber(){ return vehicleNumber; }
    public String getOwner(){ return owner; }

    public abstract String getType();
}

class Car extends Vehicle{
    public Car(String number, String owner){
        super(number, owner);
    }

    @Override
    public String getType(){
        return "Car";
    }
}

class Bike extends Vehicle{
    public Bike(String number, String owner){
        super(number, owner);
    }

    @Override
    public String getType(){
        return "Bike";
    }
}
