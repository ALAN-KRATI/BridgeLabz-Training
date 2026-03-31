import java.util.*;
public class Table6to9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] res = new int[4][10];

        for (int i = 6; i <= 9; i++) {
            for (int j = 1; j <= 10; j++) {
                res[i - 6][j - 1] = num * j;
                System.out.println(i + " * " + j + " = " + (i * num));
            }
        }
    }
}
