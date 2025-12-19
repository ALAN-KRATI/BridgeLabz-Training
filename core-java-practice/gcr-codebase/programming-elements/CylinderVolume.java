import java.util.*;

public class CylinderVolume{
    public static void main(String[] args){
        // taking height and radius as input
        Scanner sc = new Scanner(System.in);
        int radius = sc.nextInt();
        int height = sc.nextInt();

        System.out.println(volume(radius, height));// print the volume of the cylinder
    }


    // function to calculate volume of the cylinder
    public static double volume(int radius, int height){
        return 3.14*radius*radius*height;
    }
}