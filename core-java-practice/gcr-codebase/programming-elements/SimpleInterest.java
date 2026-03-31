import java.util.*;

public class SimpleInterest{
    public static void main(String[] args){
        // taking pricipal amount, rate and time as input
        Scanner sc = new Scanner(System.in);
        int principle = sc.nextInt();
        int rate = sc.nextInt();
        int time = sc.nextInt();

        System.out.println(interest(principle, rate, time));// prints the simple interest
    }


    // function to calculate simple interest
    public static double interest(int principle , int rate, int time){
        return principle*rate*time/100;
    }
}