import java.util.Scanner;
public class TotalHandshakes {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int students = sc.nextInt();

        System.out.println(MaximumHandshakes(students));
    }

    public static int MaximumHandshakes(int n) {
        return n * (n - 1) / 2;
    }
}
