import java.util.*;

public class FirstNonRepeatingCharacter{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.next().toLowerCase();

        System.out.println(FirstUniqueLetter(str));
    }

    public static char FirstUniqueLetter(String str){
        int len = str.length();
        int[] freqArr = new int[26];

        for(int i = 0; i < len; i++){
            freqArr[str.charAt(i) - 'a']++;
        }

        for(int i = 0; i < len; i++){
            if(freqArr[str.charAt(i) - 'a'] == 1){
                return str.charAt(i);
            }
        }

        return '0';
    }
}