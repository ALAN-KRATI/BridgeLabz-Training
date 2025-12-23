public class Store {
   private static double discount = 0.0;
   
   private final String productID; 
   private String productName;
   private double price;
   private int quantity;
   
   public Store(String productID, String productName, double price, int quantity) {
       this.productID = productID;
       this.productName = productName;
       this.price = price;
       this.quantity = quantity;
   }
   
   public static void updateDiscount(double updatedDiscount) {
       if (updatedDiscount >= 0.0 && newDiscount <= 100.0) {
           discount = newDiscount;
       } else {
           System.out.println("Invalid discount percentage. Please enter a value between 0 and 100.");
       }
   }

   public double getDiscountedPrice() {
       return price - (price * discount / 100);
   }
 
   public void displayProductDetails() {
       if (this instanceof Store) {
           System.out.println("Product ID: " + productID);
           System.out.println("Product Name: " + productName);
           System.out.println("Price: $" + price);
           System.out.println("Quantity: " + quantity);
           System.out.println("Discount: " + discount + "%");
           System.out.println("Price after Discount: $" + getDiscountedPrice());
       } else {
           System.out.println("The object is not an instance of the Product class.");
       }
   }
  
   public String getProductID() {
       return productID;
   }
   public String getProductName() {
       return productName;
   }
   public void setProductName(String productName) {
       this.productName = productName;
   }
   public double getPrice() {
       return price;
   }
   public void setPrice(double price) {
       this.price = price;
   }
   public int getQuantity() {
       return quantity;
   }
   public void setQuantity(int quantity) {
       this.quantity = quantity;
   }
   public static void main(String[] args) {
    
       Store.updateDiscount(10.0); // 
      
       Store product1 = new Store("p01", "Hair-Dryer", 2500, 2);
       Store product2 = new Store("P002", "I-Phone", 80000, 1);
       
       product1.displayProductDetails();
       System.out.println();
       product2.displayProductDetails();
   }
}
