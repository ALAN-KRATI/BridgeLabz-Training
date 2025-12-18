import java.util.*;

public class AverageOfThreeNumbers{
    public static void main(String[] args){
        // taking the three numbers as input
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        System.out.println(average(a, b, c));// prints the average of the three numbers
    }


    

    // function to calculate the average of three numbers
    public static double power(int a, int b, int c){
       return (a+b+c)/3;
    }
}