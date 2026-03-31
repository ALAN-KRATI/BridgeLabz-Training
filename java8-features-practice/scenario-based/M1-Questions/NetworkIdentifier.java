import java.util.*;

public class NetworkIdentifier{
    static boolean validateIdentifier(String s){
        String regex="^([0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}::([0-9A-F]{2}:){5}[0-9A-F]{2}$";
        return s.matches(regex);
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=Integer.parseInt(sc.nextLine());

        for(int i=0;i<n;i++){
            String s=sc.nextLine();
            if(validateIdentifier(s))
                System.out.println("AUTHENTIC DEVICE");
            else
                System.out.println("REJECTED DEVICE");
        }
    }
}