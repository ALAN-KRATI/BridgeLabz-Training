import java.util.Scanner;
public class SimpleInterestCalculator {
   
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double principal = sc.nextDouble();
        double rate = sc.nextDouble();
        double time = sc.nextDouble();

        double interest = interestApplied(p, r, t);
        System.out.println("The Simple Interest is " + interest + " for Principal " + principal + ", Rate of Interest " + rate + " and Time " + time);
    }

    public static double interestApplied(double principal, double rate, double time) {
        return (principal * rate * time) / 100;
    }
}
