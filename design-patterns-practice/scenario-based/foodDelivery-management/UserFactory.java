interface User{
    void showRole();
}

class Customer implements User{
    public void showRole(){
        System.out.println(" Customer");
    }
}

class DeliveryAgent implements User{
    public void showRole(){
        System.out.println("Delivery Agent.");
    }
}

class RestaurentOwner implements User{
    public void showRole(){
        System.out.println("Restaurant Owner.");
    }
}

public class UserFactory{
    public static User createUser(String type){
        switch(type.toLowerCase()){
            case "customer" : return new Customer();
            case "deliveryagent": return new DeliveryAgent();
            case "restaurantowner": return new RestaurentOwner();
            default: throw new IllegalArgumentException("Invalid type.");
        }
    }
}