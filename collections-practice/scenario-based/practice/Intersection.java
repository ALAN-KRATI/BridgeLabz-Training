import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Intersection{
    public static void main(String[] args){
        Set<String> name1 = new HashSet<>();
        Set<String> name2 = new HashSet<>();

        name1.add("Alice");
        name1.add("Bob");
        name1.add("Olive");
        name1.add("Claude");
        name1.add("Jack");

        name2.add("Anna");
        name2.add("Ayushi");
        name2.add("Alice");
        name2.add("Alan");
        name2.add("Bob");

        List<String> common = new ArrayList<>();

        for(String s : name1){
            if(name2.contains(s)){
                common.add(s);
            }
        }

        System.out.println(common);
    }
}