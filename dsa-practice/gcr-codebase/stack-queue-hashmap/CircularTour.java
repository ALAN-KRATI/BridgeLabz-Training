import java.util.*;

public class CircularTour {
    static class PetrolPump {
        int petrol;
        int distance;
        PetrolPump(int petrol, int distance) {
            this.petrol = petrol;
            this.distance = distance;
        }
    }

    public static int findStartPoint(PetrolPump[] pumps, int n) {
        int start = 0, surplus = 0, balance = 0;
        for (int i = 0; i < n; i++) {
            balance += pumps[i].petrol - pumps[i].distance;
            if (balance < 0) {
                start = i + 1;
                surplus += balance;
                balance = 0;
            }
        }
        return (balance + surplus) >= 0 ? start : -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        PetrolPump[] pumps = new PetrolPump[n];

        for (int i = 0; i < n; i++) {
            int petrol = sc.nextInt();
            int distance = sc.nextInt();
            pumps[i] = new PetrolPump(petrol, distance);
        }
        
        System.out.println(findStartPoint(pumps, n));
    }
}
