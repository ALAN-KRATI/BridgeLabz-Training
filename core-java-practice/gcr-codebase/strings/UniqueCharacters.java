import java.util.*;

public class UniqueCharacters{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();

        int len = FindLength(text);
        System.out.println(len);

        System.out.println(Arrays.toString(UniqueLetters(len, text)));
    }

    public static int FindLength(String text){
        int len = 0;
        try {
            while (true) text.charAt(len++);
        } catch (Exception e) {}
        return len-1;
    }

    public static char[] UniqueLetters(int len, String text){
        char[] arr = new char[len];
        int idx = 0;

        for (int i = 0; i < len; i++) {
            char current = text.charAt(i);
            boolean b = true;

            for (int j = 0; j < idx; j++) {
                if (arr[j] == current) {
                    b = false;
                    break;
                }
            }

            if (b) {
                arr[idx++] = current;
            }
        }

        
        return arr;
    }
    
}