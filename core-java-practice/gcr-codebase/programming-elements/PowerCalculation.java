import java.util.*;

public class PowerCalculation{
    public static void main(String[] args){
        // taking base and exponent as input
        Scanner sc = new Scanner(System.in);
        int b = sc.nextInt();
        int e = sc.nextInt();

        System.out.println(power(b, e));// print the power
    }


    // function to calculate power
    public static double power(int b, int e){
        int ans = 1;

        for(int i = 0; i < e; i++){
            ans *= b;
        }

        return ans;
    }
}