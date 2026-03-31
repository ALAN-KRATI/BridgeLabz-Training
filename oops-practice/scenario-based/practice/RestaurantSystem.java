import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Restaurant{
    private String name;
    private HashMap<String, Integer> map;
    private List<Double> ratings;

    public Restaurant(String name){
        this.name = name;
        map = new HashMap<>();
        ratings = new ArrayList<>();
    }

    public void addItem(String dish, int price){
        map.put(dish, price);
    }

    public void removeItem(String dish){
        map.remove(dish);
    }

    public void addRating(double rating){
        ratings.add(rating);
    }

    public double averageRating(){
        double  sum = 0.0;
        if(ratings.isEmpty()){
            return sum;
        }

        for(Double rating: ratings){
            sum += rating;
        }

        return sum / ratings.size();
    }

    public void display(){
        System.out.println("Menu by " + name + ": ");
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

}
public class RestaurantSystem {
    public static void main(String[] args){
        Restaurant r = new Restaurant("Food Tales");

        r.addItem("Pizza", 80);
        r.addItem("Noodles", 50);
        r.addItem("Coffe", 90);

        r.display();

        r.addRating(4.0);
        r.addRating(3.0);
        r.addRating(4.2);

        System.out.println("Average rating of the restaurant: " + r.averageRating());
    }
}
