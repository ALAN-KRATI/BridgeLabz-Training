import java.util.Set;

public class SpecificId {
    public static void main(String[] args){
        Set<Integer> ids = Set.of(101, 102, 103, 104, 105, 106);
        System.out.println("Specific id 105 exists: " + ids.contains(105));
    }
}
