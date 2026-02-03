class ElectronicsProduct{
    private int productId;
    private String name;
    private double price;

    public ElectronicsProduct(int productId, String name, double price){
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public int getProductId(){ return productId; }
    public String getName(){return name; }
    public double getPrice(){ return price; }

    public double applyDiscount(double discountPercent){
        price = price - (price * discountPercent/100);
        return price;
    }

    public String toString(){
        return productId + " | " + name + " | " + price;
    }
}

class WashingMachine extends ElectronicsProduct{
    private int warranty;

    public WashingMachine(int productId, String name, double price, int warranty){
        super(productId, name, price);
        this.warranty = warranty;      
    }

    public void extendWarranty(int years){
        warranty += years;
    }

    public void display(){
        System.out.println(toString() + " | " + warranty + " years");
    }

}
public class Product {
    public static void main(String[] args){
        WashingMachine wm = new WashingMachine(101, "Samsung Smart Touch Washing Machine", 25000, 2);

        System.out.println("Washing Machine details: ");
        wm.display();

        System.out.println("Washing Machine details after discount: ");
        wm.applyDiscount(10);
        wm.display();

        System.out.println("Washing Machine details after extending warranty: ");
        wm.extendWarranty(1);
        wm.display();
    }
    
}
