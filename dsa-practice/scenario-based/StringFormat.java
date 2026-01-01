import java.util.*;

public class StringFormat {

    public static String formatString(StringBuilder para) {

        String text = para.toString();
        text = text.trim().replaceAll("\\s+", " ");

        char[] chars = text.toCharArray();
        chars[0] = Character.toUpperCase(chars[0]);

        for (int i = 1; i < chars.length; i++) {
            if (chars[i - 1] == '.' || chars[i - 1] == '!' || chars[i - 1] == '?') {
                chars[i] = Character.toUpperCase(chars[i]);
            }
        }

        text = new String(chars);
        text = text.replaceAll("([.!?])\\s*", "$1 ");

        return text;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            if (line.isEmpty()) break;   
            sb.append(line);
        }

        System.out.println(formatString(sb));
    }
}