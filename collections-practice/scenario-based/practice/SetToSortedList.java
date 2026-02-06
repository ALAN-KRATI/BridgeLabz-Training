import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class SetToSortedList {
    public static void main(String[] args){
        Set<Integer> set = Set.of(2, 5, 3, 8, 1, 7, 6, 4);

        List<Integer> sorted = set.stream().sorted().collect(Collectors.toList());

        System.out.println(sorted);
    }
}
