import java.util.HashSet;
import java.util.Set;

public class MergeSet {
    public static void main(String[] args){
        Set<Integer> set1 = Set.of(1, 2, 3, 4, 5);
        Set<Integer> set2 = Set.of(3, 4, 5, 6, 7);

        Set<Integer> merge = new HashSet<>();

        for(int i : set1){
            merge.add(i);
        }

        for(int i : set2){
            merge.add(i);
        }

        System.out.println(merge);
    }
}
