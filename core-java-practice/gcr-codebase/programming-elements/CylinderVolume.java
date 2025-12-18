import java.util.*;

public class CylinderVolume{
    public static void main(String[] args){
        // taking height and radius as input
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int h = sc.nextInt();

        System.out.println(volume(r, h));// print the volume of the cylinder
    }


    // function to calculate volume of the cylinder
    public static double volume(int r, int h){
        return 3.14*r*r*h;
    }
}