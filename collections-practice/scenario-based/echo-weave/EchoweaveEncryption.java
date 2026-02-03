package echoweave;
import java.util.*;

public class EchoweaveEncryption {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the input: ");
		String input = sc.nextLine();
		
		if(input.matches("^[A-Za-z]+$")) {
			InputProcessor processor = new InputProcessor();
			String result = processor.processInput(input);
			System.out.println("Encrypted output: " + result);
		}
		else {
			System.out.println(input + " is an invalid input");
		}
		
		sc.close();
	}
}
