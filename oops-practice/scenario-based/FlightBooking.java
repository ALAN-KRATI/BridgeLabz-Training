import java.util.*;

public class FlightBooking{

    static String[] availaibleFlights = {
        "Indigo - Delhi to Mubai",
        "Air India - Pune to Bangalore",
        "SpiceJet - Chennai to Kolkata",
        "Vistara - Delhi to Goa",
        "GoAir - Hyderabad to Jaipur"
    };

    static List<String> bookings = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args){
        System.out.println("----------Flight Booking System----------");

        while(true){
            System.out.println("\nMenu: ");
            System.out.println("1. Add a flight.");
            System.out.println("2. Search Flight.");
            System.out.println("3. Book Flight.");
            System.out.println("4. View Bookings.");
            System.out.println("5. Exit!");
            System.out.println("\nChoose an option: ");

            int choice = sc.nextInt();

            switch(choice){
                case 1;
                    System.out.println("\nEnter Flight details: ");
                    String flight = sc.nextLine();
                    addFlight(flight);
                    break;
                
                case 2: 
                    System.out.println("\n Enter flight name: ");
                    String name = sc.nextLine();
                    searchFlight(name);
                    break;
                
                case 3:
                    bookFlight();
                    break;
                
                case 4:
                    viewBookings();
                    break;
                
                case 5:
                    System.out.println("Goodbye......!!");
                    return;
                
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    public static void addFlight(String name){
        availaibleFlights.add(name);
        System.out.println("\nFlight details added succesfully!");
    }

    public static void searchFlight(String keyword){
        boolean b = false;

       for(String i: availaibleFlights){
            if(i.toLowerCase().contains(keyword.toLowerCase())){
                System.out.println(i);
                b = true;
            }
       }

       if(!b) System.out.println("No flight found!");
    } 

    public static void bookFlight(){
        System.out.println("\nList of available flights: \n");
        for(int i = 0; i < availaibleFlights.length; i++){
            System.out.println((i+1) + ". " + availaibleFlights[i]);
        }

        System.out.println("\nChoose a flight: ");
        int choice = sc.nextInt();

        if(choice > 0 && choice <= availaibleFlights.length){
            String flight = availaibleFlights[i-1];
            bookings.add(flight);
            System.out.println("\nBooked Successfully!");
        }
        else {
            System.out.println("\nInvalid flight number.");
        }
    }

    public static void viewBookings(){
        if(bookings.isEmpty()){
            System.out.println("\nNo Bookings!");
        }
        else{
            System.out.println("\nYour bookings are: ");
            for(String s: bookings){
                System.out.println("- " + s);
            }
        }
    }
}