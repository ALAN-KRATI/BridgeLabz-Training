import java.util.*;

public class CoffeCounter{
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        boolean b = true;
        int price = 0, quantity = 0;


        while(b){

            System.out.println("---------- MENU ----------");
            System.out.println("Coffe Type          Price ");
            System.out.println("Americano             130 ");
            System.out.println("Cappuccino            100 ");
            System.out.println("HazelNut              170 ");
            System.out.println("Latte                  90 ");
            System.out.println("Mocha                 150 ");
            System.out.println();
            System.out.println();

            System.out.println("Enter the coffee type you like to order from the menu: ");
            String coffeType = sc.nextLine().toLowerCase();
            System.out.println();
            System.out.println();

            if(!coffeType.equals("exit")){
                System.out.println("Enter the quantity you'd like: ");
                quantity = sc.nextInt();
                sc.nextLine();
                System.out.println();
                System.out.println();
            }

        
            switch(coffeType){

                case "americano":
                    price = 130;
                    System.out.println("Your total amount with gst: " + totalAmount(quantity, price));
                    System.out.println();
                    System.out.println();
                    break;

                case "cappuccino":
                    price = 100;
                    System.out.println("Your total amount with gst: " + totalAmount(quantity, price));
                    System.out.println();
                    System.out.println();
                    break;
                
                case "hazelnut":
                    price = 170;
                    System.out.println("Your total amount with gst: " + totalAmount(quantity, price));
                    System.out.println();
                    System.out.println();
                    break;
                
                case "mocha":
                    price = 150;
                    System.out.println("Your total amount with gst: " + totalAmount(quantity, price));
                    System.out.println();
                    System.out.println();
                    break;
                
                case "latte":
                    price = 90;
                    System.out.println("Your total amount with gst: " + totalAmount(quantity, price));
                    System.out.println();
                    System.out.println();
                    break;

                default:
                    b = false;
                    System.out.println("Bye.......");
            }
        }
    }

    public static double totalAmount(int quantity, int price){

        double amount = (double) (quantity * price);
        System.out.println("Your amount is: " + amount);

        double gst = 0.05 * amount;
        System.out.println("5% gst amount: " + gst);

        double totalPayment = amount + gst;

        return totalPayment;
    }


}