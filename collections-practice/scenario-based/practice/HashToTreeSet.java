import java.util.Set;
import java.util.TreeSet;

public class HashToTreeSet {
    public static void main(String[] args){
        Set<Integer> set = Set.of(3, 5, 2, 8, 1, 6, 9, 7, 4);
        Set<Integer> sorted = new TreeSet<>(set);
        System.out.println(set);
        System.out.println(sorted);
    }
}
