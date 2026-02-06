import java.util.Scanner;

class InvalidStringException extends Exception{
    public InvalidStringException(String message){
        super(message);
    }
}

public class Regex {

    public static boolean validate(String input) throws InvalidStringException{
        if(input.matches("^TASK@[1-9][0-9]{3}$")){
            return true;
        }
        else{
            throw new InvalidStringException("Input is Invalid");
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        try{
            validate(input);
            System.out.println("Input is valid.");
        }
        catch(InvalidStringException e){
            System.out.println(e.getMessage());
        }

        sc.close();
    }
}
