import java.util.*;

public class RemoveDuplicates{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        StringBuilder sb = new StringBuilder();
        Set<Character> set = new HashSet<>();
        
        for(char ch : s.toCharArray()){
            if(!set.contains(ch)){
                set.add(ch);
                sb.append(ch);
            }
        }

        System.out.println(sb.toString());
    }
}