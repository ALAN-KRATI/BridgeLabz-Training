import java.util.*;

public class UserInterface {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Experiment 1 details: ");
		int id1 = sc.nextInt();
		sc.nextLine();
		String title1 = sc.nextLine();
		String researcher1 = sc.nextLine();
		double funds = sc.nextDouble();
		sc.nextLine();
		String level = sc.nextLine();
		int month = sc.nextInt();
		sc.nextLine();
		int year = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Enter Experiment 2 details: ");
		int id2 = sc.nextInt();
		sc.nextLine();
		String title2 = sc.nextLine();
		String researcher2 = sc.nextLine();
		double funds2 = sc.nextDouble();
		sc.nextLine();
		String level2 = sc.nextLine();
		int month2 = sc.nextInt();
		sc.nextLine();
		int year2 = sc.nextInt();
		sc.nextLine();
		
		ExperimentInfo e1 = new ExperimentInfo(id1, title1, researcher1, funds, level, month, year);
		ExperimentInfo e2 = new ExperimentInfo(id2, title2, researcher2, funds2, level2, month2, year2);
		
		int monthsActive1 = Experiment.getMonthsActive(month, year);
		int monthsActive2 = Experiment.getMonthsActive(month2, year2);
		
		double innovation1 = e1.calculateInnovationScore(monthsActive1);
		double innovation2 = e2.calculateInnovationScore(monthsActive2);
		
		double consumption1 = e2.calculateResourceConsumption(monthsActive1);
		double consumption2 = e2.calculateResourceConsumption(monthsActive2);
		
		Experiment service = new ExperimentInfo();
		ExperimentInfo e = service.getHigherImpactExperiment(e1, e2);
		
		if(e.getExperimentId() == e1.getExperimentId()) {
			display(e1, monthsActive1, innovation1, consumption1);
			display(e2, monthsActive2, innovation2, consumption2);
		}
		else {
			display(e2, monthsActive2, innovation2, consumption2);
			display(e1, monthsActive1, innovation1, consumption1);
		}		
		
		sc.close();
	}
	
	public static void display(ExperimentInfo e, int monthsActive, double innovation, double consumption) {
		System.out.println("Experiment Summary: ");
		System.out.println(e.getExperimentTitle() + " by " + e.getLeadResearcher());
		System.out.println("Months Active: " + monthsActive);
		System.out.println("Innovation Score: " + innovation);
		System.out.println("Resource Consumption: "+ consumption);
		System.out.println();
	}
}
