import java.util.*;
public class FindFactors {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        int maxFactors = 10;
        int[] factors = new int[maxFactors];
        int idx = 0;

        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                if (idx == maxFactors) {
                    maxFactors *= 2;
                    int[] temp = new int[maxFactors];
                    System.arraycopy(factors, 0, temp, 0, factors.length);
                    factors = temp;
                }
                factors[idx++] = i;
            }
        }
    }
}
