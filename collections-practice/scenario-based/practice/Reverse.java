import java.util.Scanner;

public class Reverse {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int num = sc.nextInt();
        int temp = num;

        String reversed = "";
        for(int i = input.length() - 1; i >= 0; i--){
            reversed += input.charAt(i);
        }

        int reverse = 0;

        while (temp != 0) {
            int d = temp % 10;
            reverse = reverse * 10 + d;
            temp = temp / 10;
        }

        if(input.equals(reversed) && num == reverse){
            System.out.println("Both are equal");
        }
        else if(input.equals(reversed)){
            System.out.println("Only the word is equal");
        }
        else if(num == reverse){
            System.out.println("Only the number is equal.");
        }
        else {
            System.out.println("None of them is equal.");
        }

        sc.close();
        
    }
}
