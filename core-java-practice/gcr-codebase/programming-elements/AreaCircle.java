import java.util.*;

public class AreaCircle{
    public static void main(String[] args){
        // takes the radius of the circle as input
        Scanner sc = new Scanner(System.in);
        double radius = sc.nextDouble();

        System.out.println(area(radius));// prints the area of the circle
    }
    

    // calculates the area of the circle using the formula
    public static double area(double r){
        return 3.14 * r * r;
    }
}