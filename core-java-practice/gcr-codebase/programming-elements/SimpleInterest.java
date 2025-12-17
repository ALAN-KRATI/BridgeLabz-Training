import java.util.*;

public class SimpleInterest{
    public static void main(String[] args){
        // taking pricipal amount, rate and time as input
        Scanner sc = new Scanner(System.in);
        int p = sc.nextInt();
        int r = sc.nextInt();
        int t = sc.nextInt();

        System.out.println(interest(p, r, t));// prints the simple interest
    }

    // function to calculate simple interest
    public static double interestint p , int r, int t){
        return p*r*t/100;
    }
}