public class Bid implements Comparable<Bid>{

    private double amount;

    public Bid(double amount){
        this.amount = amount;
    }

    public double getAmount(){
        return amount;
    }

    @Override
    public int compareTo(Bid other){
        return Double.compare(this.amount, other.amount);
    }

    @Override
    public String toString(){
        return "₹" + amount;
    }
}