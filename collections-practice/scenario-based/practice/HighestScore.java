import java.util.HashMap;
import java.util.Map;

public class HighestScore {
    public static void main(String[] args){
        Map<String, Integer> scores = new HashMap<>();
        scores.put("Alice", 78);
        scores.put("Bob", 67);
        scores.put("Olive", 82);
        scores.put("Jack", 65);

        int max = 0;
        String names = "";
        for(String name : scores.keySet()){
            if(scores.get(name) > max){
                max = scores.get(name);
                names = name;
            }
        }

        System.out.println("Student with highest score: " + names + " -> " + max);
    }
}
