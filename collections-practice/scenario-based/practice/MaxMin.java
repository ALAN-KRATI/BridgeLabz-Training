import java.util.Set;

public class MaxMin {
    public static void main(String[] args){
        Set<Integer> set = Set.of(6, 2, 7, 9, 1, 4, 3, 5, 8);

        int max = set.stream().max(Integer::compareTo).get();
        int min = set.stream().min(Integer::compareTo).get();

        System.out.println(max);
        System.out.println(min);
    }
}
