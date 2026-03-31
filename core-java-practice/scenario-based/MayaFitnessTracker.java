import java.util.*;

public class MayaFitnessTracker{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your height(cm): ");
        double height = sc.nextDouble();
        System.out.println();

        System.out.println("Enter your weight(kg): ");
        double weight = sc.nextDouble();
        System.out.println();

        bmiFinder(height, weight);
    }

    public static void bmiFinder(double height, double weight){
        height = height/100;
        double bmi = (weight/ (height * height));
        System.out.println("Your BMI: " + bmi);

        if(bmi < 18.5) System.out.println("You are in underweight category.");
        else if(bmi >= 18.5 && bmi <= 24.9) System.out.println("You are in normal weight category.");
        else if(bmi >= 25 && bmi <= 29.9) System.out.println("You are in overweight category.");
        else System.out.println("You are in obese category.");
    }
}