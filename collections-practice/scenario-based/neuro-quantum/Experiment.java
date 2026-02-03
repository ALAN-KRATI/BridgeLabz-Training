import java.time.*;

public interface Experiment {
	double calculateInnovationScore(int monthsActive);
	double calculateResourceConsumption(int monthsActive);
	public default ExperimentInfo getHigherImpactExperiment(ExperimentInfo e1, ExperimentInfo e2) {
		if(e1.getFundingAmount() > e2.getFundingAmount()) {
			return e1;
		}
		
		return e2;
	}
	
	public static int getMonthsActive(int initiationMonth, int initiationYear) {
		LocalDate currentDate = LocalDate.now();
		int monthsActive = (currentDate.getYear() - initiationYear) * 12 + (currentDate.getMonthValue() - initiationMonth);
		
		return monthsActive;
	}
}
