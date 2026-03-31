import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        CircularRoundabout roundabout = new CircularRoundabout();
        VehicleQueue waitingQueue = new VehicleQueue(3);

        Scanner sc = new Scanner(System.in);
        boolean run = true;

        while (run) {
            System.out.println("\n--- Traffic Manager ---");
            System.out.println("1. Vehicle enters waiting queue");
            System.out.println("2. Allow vehicle into roundabout");
            System.out.println("3. Vehicle exits roundabout");
            System.out.println("4. Display roundabout");
            System.out.println("5. Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter vehicle number: ");
                    waitingQueue.enqueue(sc.nextLine());
                    break;

                case 2:
                    if (!waitingQueue.isEmpty()) {
                        String v = waitingQueue.dequeue();
                        roundabout.addVehicle(v);
                    }
                    break;

                case 3:
                    System.out.print("Enter vehicle number to exit: ");
                    roundabout.removeVehicle(sc.nextLine());
                    break;

                case 4:
                    roundabout.display();
                    break;

                case 5:
                    run = false;
                    break;
            }
        }
        sc.close();
    }
}
