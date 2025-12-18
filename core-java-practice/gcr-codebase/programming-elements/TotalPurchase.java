import java.util.*;
public class TotalPurchase {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int unitPri = sc.nextInt();
        int quan = sc.nextInt();
        int totalp = unitPrice * quantity;

        System.out.println("The total purchase price is INR " + totalp + " if the quantity " + quan + " and unit price is INR " + unitPri);
    }
}