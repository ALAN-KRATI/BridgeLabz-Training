import java.util.*;

public class FrequencyCharacters {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next().toLowerCase();

        char[] unique = UniqueLetters(str.length(), str);
        System.out.println(Arrays.toString(FindFrequency(unique, str)));
    }

    public static char[] UniqueLetters(int len, String text) {
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

       
        return Arrays.copyOf(arr, idx);
    }

    public static String[] FindFrequency(char[] unique, String str) {
        int[] freqArr = new int[26];
        String[] frequencies = new String[unique.length];

        
        for (int i = 0; i < str.length(); i++) {
            freqArr[str.charAt(i) - 'a']++;
        }

        for (int i = 0; i < unique.length; i++) {
            frequencies[i] = unique[i] + ":" + freqArr[unique[i] - 'a'];
        }

        return frequencies;
    }
}
