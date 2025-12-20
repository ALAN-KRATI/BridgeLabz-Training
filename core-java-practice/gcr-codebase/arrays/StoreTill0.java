import java.util.*;

public class StoreTill0 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        double[] arr = new double[10];
        double totalSum = 0.0;
        int idx = 0;

        while (true) {
            if (idx == 10) break;
            double n = sc.nextDouble();
            if (n <= 0) break;

            arr[idx++] = n;
        }

        for (int i = 0; i < idx; i++) {
            totalSum += arr[i];
            System.out.print(arr[i] + " ");
        }

        System.out.println("\nSum = " + totalSum);
    }
}
