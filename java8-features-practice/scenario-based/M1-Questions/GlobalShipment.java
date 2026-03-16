import java.util.*;
import java.time.*;

public class GlobalShipment {

    static boolean validCode(String code) {
        return code.matches("^SHIP-[1-9](?!.*(\\d)\\1{3})\\d{5}$");
    }

    static boolean validDate(String date) {
        try {
            LocalDate d = LocalDate.parse(date);
            int year = d.getYear();
            return year >= 2000 && year <= 2099;
        } catch (Exception e) {
            return false;
        }
    }

    static boolean validMode(String mode) {
        Set<String> modes = new HashSet<>(Arrays.asList(
                "AIR","SEA","ROAD","RAIL","EXPRESS","FREIGHT"));
        return modes.contains(mode);
    }

    static boolean validWeight(String weight) {
        if (!weight.matches("^(0|[1-9]\\d{0,5})(\\.\\d{1,2})?$"))
            return false;

        double w = Double.parseDouble(weight);
        return w > 0 && w <= 999999.99;
    }

    static boolean validStatus(String status) {
        return status.equals("DELIVERED") ||
               status.equals("CANCELLED") ||
               status.equals("IN_TRANSIT");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        for(int i=0;i<n;i++){

            String record = sc.nextLine();
            String[] parts = record.split("\\|");

            if(parts.length!=5){
                System.out.println("NON-COMPLIANT RECORD");
                continue;
            }

            String code = parts[0];
            String date = parts[1];
            String mode = parts[2];
            String weight = parts[3];
            String status = parts[4];

            if(validCode(code) &&
               validDate(date) &&
               validMode(mode) &&
               validWeight(weight) &&
               validStatus(status))
            {
                System.out.println("COMPLIANT RECORD");
            }
            else{
                System.out.println("NON-COMPLIANT RECORD");
            }
        }
    }
}