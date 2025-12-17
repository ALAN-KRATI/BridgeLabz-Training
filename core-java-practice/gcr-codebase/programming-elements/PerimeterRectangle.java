import java.util.*;

public class PerimeterRectangle{
    public static void main(String[] args){
        // taking length and breadth as inputs
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        int b = sc.nextInt();

        System.out.println(perimeter(l, b));// prints the perimeter of the rectangle
    }

    // function to calculate perimeter of a rectangle
    public static double volume(int l, int b){
        return 2 * (l + b);
    }
}