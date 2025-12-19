import java.util.*;
public class FeeInput{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int fee =  sc.nextInt();
        int discountPercent = sc.nextInt();
        int discount = (fee * discountPercent) / 100;
        int paidFee = fee - discount;

        System.out.println("The discount amount is INR " + discount + " and final discounted fee is INR " + paidFee);
    }
}