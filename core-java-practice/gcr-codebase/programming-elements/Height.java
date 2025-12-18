import java.util.*;

public class Height{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double h = sc.nextDouble();
        double inch = h / 2.54;
        int feet = (int) (inche / 12);
        double inches = inche % 12;
        System.out.println("Your Height in cm is " + h + " while in feet is " + feet + " and inches is " + inches);
    }
}
