import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventManager {
    private Map<String, List<Integer>> ratings = new HashMap<>();
    private Map<String, Double> averageRatings = new HashMap<>();

    public void addRating(String eventId, int rating) throws InvalidRatingException{
        if(rating < 1 || rating > 5) {
            throw new InvalidRatingException("Invalid rating should be between(1-5)");
        }

        ratings.computeIfAbsent(eventId, k -> new ArrayList<>()).add(rating);
    }

    public void averageEventRating(){
        for(String id : ratings.keySet()){
            double total = 0;
            for(int i : ratings.get(id)){
                total += i;
            }
            averageRatings.put(id, total/ratings.get(id).size());
            System.out.println("Average rating for the event: " + id + " is " + total/ratings.get(id).size());
        }
    }

    public void topRatedEvents(){
        averageRatings.entrySet()
                      .stream()
                      .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                      .forEach(entry -> System.out.println(entry.getKey() + " -> " + entry.getValue()));
    }
}
