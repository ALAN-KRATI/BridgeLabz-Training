import java.util.*;
public class VotingAge {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] ages = new int[10];

        for (int i = 0; i < ages.length; i++) {
            ages[i] = sc.nextInt();
        }

        for (int i : ages) {
            if (i < 0) {
                System.err.println("Invalid age");
            } else if (i >= 18) {
                System.out.println("The student with age " + i + " can vote.");
            } else {
                System.out.println("The student with age " + i + " cannot vote.");
            }
        }
    }
}
