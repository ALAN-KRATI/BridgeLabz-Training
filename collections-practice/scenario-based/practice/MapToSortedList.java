import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapToSortedList {    
    public static void main(String[] args){
        Map<String, Integer> scores = new HashMap<>();
        scores.put("Alice", 78);
        scores.put("Bob", 67);
        scores.put("Olive", 82);
        scores.put("Jack", 65);

        List<Integer> scoresOnly = new ArrayList<>();
        for(String name: scores.keySet()){
            scoresOnly.add(scores.get(name));
        }

        Collections.sort(scoresOnly);

        List<String> sorted = new ArrayList<>();

       
        for(int i = 0; i < scoresOnly.size(); i++){
            for(String name : scores.keySet()){
                if(scoresOnly.get(i) == scores.get(name)){
                    sorted.add(name + ":" + scoresOnly.get(i));
                }
            }
        }

        System.out.println(sorted);

    }
}


