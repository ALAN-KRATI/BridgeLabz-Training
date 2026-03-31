import java.util.*;

public class Anagrams{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String text1 = sc.nextLine();
        String text2 = sc.nextLine();

        boolean b = checkAnagram(text1, text2);
        if(b) System.out.println("Anagrams!");
        else System.out.println("Not Anagrams!");
    }

    public static boolean checkAnagram(String text1, String text2){
        if(text1.length() != text2.length()) return false;

        char[] arr1 = text1.toCharArray();
        char[] arr2 = text2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        for(int i = 0; i < arr1.length; i++){
            if(arr1[i] != arr2[i]) return false;
        }

        return true;
    }
}