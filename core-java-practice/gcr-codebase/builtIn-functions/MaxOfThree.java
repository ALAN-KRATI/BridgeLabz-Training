import java.util.*;

public class maxofthree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1 = getInput(sc);
        int num2 = getInput(sc);
        int num3 = getInput(sc);

        int max = findMax(num1, num2, num3);
        System.out.print(max);

    }

    public static int getInput(Scanner sc) {
        return sc.nextInt();
    }

    public static int findMax(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }
}
