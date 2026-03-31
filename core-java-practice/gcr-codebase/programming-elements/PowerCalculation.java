import java.util.*;

public class PowerCalculation{
    public static void main(String[] args){
        // taking base and exponent as input
        Scanner sc = new Scanner(System.in);
        int base = sc.nextInt();
        int exponent = sc.nextInt();

        System.out.println(power(base, exponent));// print the power
    }


    // function to calculate power
    public static double power(int base, int exponent){
        int ans = 1;

        for(int i = 0; i < exponent; i++){
            ans *= base;
        }

        return ans;
    }
}