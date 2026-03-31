public class PizzaUtil {
    public boolean validateOrderId(String orderId) throws InvalidPizzaOrderException{
        if(orderId.matches("^PZ-[0-9]{3}$")){
            return true;
        }
        else{
            throw new InvalidPizzaOrderException("The order ID " + orderId + " is invalid");
        }
    }

    public boolean validatePizzaType(String pizzaType) throws InvalidPizzaOrderException{
        if(pizzaType.equalsIgnoreCase("margherita") ||
           pizzaType.equalsIgnoreCase("pepperoni") ||
           pizzaType.equalsIgnoreCase("veggie") || 
           pizzaType.equalsIgnoreCase("bbq chicken")){

            return true;
        }
        else{
            throw new InvalidPizzaOrderException("The pizza type " + pizzaType + " is invalid");
        }
    }

    public boolean validateQuantity(int quantity) throws InvalidPizzaOrderException{
        if(quantity > 0 && quantity <= 50){
            return true;
        }
        else throw new InvalidPizzaOrderException("The quantity " + quantity + " is invalid");
    }

    public double calculateFinalBill(String pizzaType, double basePrice, int quantity) throws InvalidPizzaOrderException{
        double baseCost =  basePrice * quantity;
        double toppingCharge = (baseCost * getToppingPercent(pizzaType))/100;
        double deliveryFee = 100.0;

        if(basePrice < 200){
            throw new InvalidPizzaOrderException("Invalid base price for " + pizzaType);
        }

        double finalBill = baseCost + toppingCharge + deliveryFee;

        return finalBill;
    }

    private int getToppingPercent(String pizzaType){
        if(pizzaType.equalsIgnoreCase("margherita")){
            return 10;
        }
        else if(pizzaType.equalsIgnoreCase("pepperoni")){
            return 20;
        } 
        else if(pizzaType.equalsIgnoreCase("veggie")){
            return 15;
        }
        else return 25;
    }
}
