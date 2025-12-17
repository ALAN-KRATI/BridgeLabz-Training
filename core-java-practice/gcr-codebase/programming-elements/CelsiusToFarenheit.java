import java.util.*;

public class CelsiusToFarenheit{
    public static void main(String[] args){
        // taking celsius temperture as an input
        Scanner sc = new Scanner(System.in);
        double a = sc.nextDouble();

        System.out.println(convertToFarenheit(a));// prints the converted temperature here
    }


    // converts the celsius temperature to farenheit
    public static double convertToFarenheit(double celsius){
        double farenheit = (celsius * 9/5) + 32;
        return farenheit;
    }
}