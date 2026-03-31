
import java.util.*;

public class UserInterface {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of data center to be added: ");
		int n = sc.nextInt();
		sc.nextLine();
		
		String[] input = new String[n];
		System.out.println("Enter data center details: ");
		for(int i = 0; i < n; i++) {
			input[i] = sc.nextLine();
		}
		
		DataCenterUtil util = new DataCenterUtil();
		
		for(String s : input) {
			String[] details = s.split(":");
			DataCenter dc = new DataCenter(details[0], details[1], details[2], Double.parseDouble(details[3]));
			util.addDataCenter(dc);
		}
		
		System.out.println("Enter the id of the data center: ");
		String id = sc.nextLine();
		DataCenter dc = util.getDataCenterById(id);
		if(dc == null) {
			System.out.println("Data Center not found for the ID " + id);
		}
		else System.out.println(dc);
		
		System.out.println("Data Centers with maximum cooling power usage: ");
		List<DataCenter> dc2 = util.getDataCentersWithMaximumCoolingPowerUsage();
		for(DataCenter center : dc2) {
			System.out.println(center);
		}
		
		sc.close();
	}
}
