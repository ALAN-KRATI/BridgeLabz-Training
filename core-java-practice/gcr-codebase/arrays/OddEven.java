import java.util.*;
public class OddEven{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if (n <= 0) {
            System.err.println("Not a natural number.");
            return;
        }

        int[] even = new int[n / 2 + 1];
        int[] odd = new int[n / 2 + 1];
        int evenIdx = 0, oddIdx = 0;

        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) {
                even[evenIdx++] = i;
            } else {
                odd[oddIdx++] = i;
            }
        }

        System.out.print("Even numbers: ");
        for (int i = 0; i < evenIdx; i++) {
            System.out.print(even[i] + " ");
        }

        System.out.print("\nOdd numbers: ");
        for (int i = 0; i < oddIdx; i++) {
            System.out.print(odd[i] + " ");
        }
    }
}
