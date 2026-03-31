import java.util.*;

public class PerimeterRectangle{
    public static void main(String[] args){
        // taking length and breadth as inputs
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int breadth = sc.nextInt();

        System.out.println(perimeter(length, breadth));// prints the perimeter of the rectangle
    }


    // function to calculate perimeter of a rectangle
    public static double volume(int length, int breadth){
        return 2 * (length + breadth);
    }
}