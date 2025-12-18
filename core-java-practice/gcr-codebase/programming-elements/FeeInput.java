import java.util.*;
public class FeeInput{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int fee =  sc.nextInt();
        int discP = sc.nextInt();
        int disct = (fee * discP) / 100;
        int paidFee = fee - disct;

        System.out.println("The discount amount is INR " + disct + " and final discounted fee is INR " + paidFee);
    }
}