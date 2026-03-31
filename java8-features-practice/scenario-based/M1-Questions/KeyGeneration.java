import java.util.*;

public class KeyGeneration {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();

            if (s.length() == 0) {
                System.out.println("Invalid Input (empty string)");
                continue;
            }

            if (s.contains(" ")) {
                System.out.println("Invalid Input (contains space)");
                continue;
            }

            if (s.length() < 6) {
                System.out.println("Invalid Input (length < 6)");
                continue;
            }

            if (s.matches(".*\\d.*")) {
                System.out.println("Invalid Input (contains digits)");
                continue;
            }

            if (!s.matches("[a-zA-Z]+")) {
                System.out.println("Invalid Input (contains special character)");
                continue;
            }

            s = s.toLowerCase();
            StringBuilder temp = new StringBuilder();

            for (char c : s.toCharArray()) {
                if ((int)c % 2 != 0) {
                    temp.append(c);
                }
            }

            temp.reverse();

            StringBuilder result = new StringBuilder();

            for (int j = 0; j < temp.length(); j++) {
                char c = temp.charAt(j);
                if (j % 2 == 0) {
                    result.append(Character.toUpperCase(c));
                } else {
                    result.append(c);
                }
            }

            System.out.println("The generated key is - " + result.toString());
        }
    }
}