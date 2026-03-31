import java.util.*; 

public class AddTwoNumbers{
    public static void main(String[] args){
        // taking input from the user
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.println(add(a, b)); // prints the sum of two numbers
    }

    // function to add two numbers
    public static int add(int a, int b){
        return a + b;
    }
}
