public class ProfitLoss{
    public static void main(String[] args){
        int cp = 129, sp = 191, profit = 0;
        profit = sp - cp;
        int profitPercent = (profit * 100)/cp;
        System.out.println("The Cost Price is INR " + cp + " and Selling Price is INR " + sp);
        System.out.println("The Profit is INR " + profit + " and Profit Percentage is " + profitPercent + "%");
    }
}