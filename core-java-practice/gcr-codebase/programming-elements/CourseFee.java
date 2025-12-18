public class CourseFee{
    public static void main(String[] args){
        int fee =  125000;
        int discper = 10;
        int disct = (fee * discountPercent) / 100;
        int paidFee = fee - disct;

        System.out.println("The discount amount is INR " + disct + " and final discounted fee is INR " + paidFee);
    }
}