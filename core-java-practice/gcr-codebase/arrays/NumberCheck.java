import java.util.*;
public class NumberCheck{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = new int[5];

        for (int i = 0; i < 5; i++) {
            nums[i] = sc.nextInt();
        }

        for (int i : nums) {
            if (i > 0) {
                System.out.println(i + " is positive and " + (i % 2 == 0 ? "even" : "odd"));
            } else if (i < 0) {
                System.out.println(i + " is negative");
            } else {
                System.out.println("Zero");
            }
        }

        if (nums[0] > nums[4]) {
            System.out.println("First element is greater than last");
        } else if (nums[0] < nums[4]) {
            System.out.println("First element is less than last");
        } else {
            System.out.println("First and last elements are equal");
        }
    }
}
