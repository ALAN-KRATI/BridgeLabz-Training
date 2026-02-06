import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ListToSetPrint {
    public static void main(String[] args){
        List<String> names = Arrays.asList("Alice", "Bob", "Claude", "Olive", "Alice", "Anna", "Jack", "Bob", "Olive", "Kitty");

        Set<String> uniqueNames = new HashSet<>(names);

        System.out.println(uniqueNames);
    }
}
