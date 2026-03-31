import java.util.*;

public class Palindrome{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.next();


        boolean ans = checkPalindrome(str);
        if(ans) System.out.println("Palindrome!");
        else System.out.println("Not a Palindrome!");
    }

    public static boolean checkPalindrome(String text){
        int len = text.length();
        int start = 0, end = len-1;

        for(int i = 0; i < len/2; i++){
            if(text.charAt(start++) != text.charAt(end--)) return false;
        }

        return true;
    }
}