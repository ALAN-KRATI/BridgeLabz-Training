import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StartsWithI {
    public static void main(String[] args){
        Set<String> countryNames = Set.of("America", "India", "Japan", "Thailand", "Italy", "Iran", "Vietnam", "Indonesia");

        List<String> startsWithI = countryNames.stream().filter(s -> s.charAt(0) == 'I').collect(Collectors.toList());

        System.out.println(startsWithI);
    }
}
