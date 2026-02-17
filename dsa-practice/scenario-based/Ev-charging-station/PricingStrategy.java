public interface PricingStrategy {
    double calculateBill(double units);
}

class NormalPricing implements PricingStrategy{
    public double calculateBill(double units){
        return units * 10.0;
    }
}

class PeakPricing implements PricingStrategy{
    public double calculateBill(double units){
        return units * 15.0;
    }
}
