import java.util.*;

public class UserInterface {
    public static void main(String[] args) throws InvalidPizzaOrderException{
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter pizza order details: ");
        String input = sc.nextLine();
        String[] details = input.split(":");

        PizzaUtil util = new PizzaUtil();

        try{
            util.validateOrderId(details[0]);
            util.validatePizzaType(details[1]);
            util.validateQuantity(Integer.parseInt(details[3]));

            double bill = util.calculateFinalBill(details[1], Double.parseDouble(details[2]), Integer.parseInt(details[3]));
            System.out.println("Total bill for " + details[1] + " pizzas: " + bill);
        }
        catch(InvalidPizzaOrderException e){
            System.out.println(e.getMessage());
        }
    }
}
