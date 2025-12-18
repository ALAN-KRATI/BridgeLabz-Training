import java.util.*;

public class KilometerToMiles{
    public static void main(String[] args){
        // taking distance in km as input
        Scanner sc = new Scanner(System.in);
        int km = sc.nextInt();

        System.out.println(KmToM(km));// print the distance in miles
    }

    // function to covert the distance from km to miles
    public static double KmToM(int km){
      return km * 0.621371;
    }
}