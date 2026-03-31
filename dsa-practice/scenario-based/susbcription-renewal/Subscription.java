import java.time.LocalDate;

public class Subscription {
    private LocalDate endDate;
    private double price;

    public Subscription(LocalDate endDate, double price){
        this.endDate = endDate;
        this.price = price;
    }

    public LocalDate getEndDate(){ return endDate; }
    public double getPrice(){ return price;}
    public void renew(){ endDate = endDate.plusMonths(1);}

    @Override
    public String toString(){
        return "Subscription details: " + endDate + " | " + price;
    }
}
