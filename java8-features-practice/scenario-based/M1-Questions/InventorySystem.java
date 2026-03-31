import java.util.*;

abstract class Product{
    String name;
    double price;
    int quantity;

    Product(String name,double price,int quantity){
        this.name=name;
        this.price=price;
        this.quantity=quantity;
    }

    abstract void display();
}

class Electronics extends Product{
    int warranty;

    Electronics(String name,double price,int quantity,int warranty){
        super(name,price,quantity);
        this.warranty=warranty;
    }

    void display(){
        System.out.println(name+" - Price: "+price+", Quantity: "+quantity+", Warranty: "+warranty+" months");
    }
}

class Clothing extends Product{
    String size;

    Clothing(String name,double price,int quantity,String size){
        super(name,price,quantity);
        this.size=size;
    }

    void display(){
        System.out.println(name+" - Price: "+price+", Quantity: "+quantity+", Size: "+size);
    }
}

public class InventorySystem{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=Integer.parseInt(sc.nextLine());

        List<Product> list=new ArrayList<>();

        for(int i=0;i<n;i++){
            String line=sc.nextLine().trim();
            if(line.isEmpty()){
                i--;
                continue;
            }

            String[] p=line.split(",\\s*");

            if(p[0].equals("Electronics")){
                Electronics e=new Electronics(p[1],Double.parseDouble(p[2]),Integer.parseInt(p[3]),Integer.parseInt(p[4]));
                list.add(e);
                System.out.println("Product added to inventory: "+p[1]);
            }
            else if(p[0].equals("Clothing")){
                Clothing c=new Clothing(p[1],Double.parseDouble(p[2]),Integer.parseInt(p[3]),p[4]);
                list.add(c);
                System.out.println("Product added to inventory: "+p[1]);
            }
        }

        System.out.println("Inventory:");

        double total=0;

        for(Product p:list){
            p.display();
            total+=p.price*p.quantity;
        }

        System.out.printf("Total value of the inventory: %.2f\n",total);
    }
}