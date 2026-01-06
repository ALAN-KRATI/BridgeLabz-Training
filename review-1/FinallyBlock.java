public class FinallyBlock{
    public static void main(String[] args) {
        try {
            System.out.println("Try block");
        } catch (Exception e) {
            System.out.println("Catch block");
        } finally {
            System.out.println("Finally block");
        }

        try {
            int x = 5 / 0;
        } catch (Exception e) {
            System.out.println("Catch block");
        } finally {
            System.out.println("Finally block");
        }

        System.out.println(test());
    }

    static String test() {
        try {
            System.out.println("Try-Block");
            int x = 5/0;
        } 
        catch(IllegalArgumentException e){
            return "IllegalArgumentException";
        }
        catch(ArithmeticException e){
            return "Don't divide with 0";
        }
        finally {
            return "Returning from finally";
        }
    }
}
