public interface DiscountStrategy {
    double calculateDiscount(double price);    
} 

class NoDiscount implements DiscountStrategy{
    @Override
    public double calculateDiscount(double price){
        return price;
    }
}

class FestiveDiscount implements DiscountStrategy{
    @Override
    public double calculateDiscount(double price){
        return price * 0.80;
    }
}

class PremiumDiscount implements DiscountStrategy{
    @Override
    public double calculateDiscount(double price){
        return price * 0.70;
    }
}

