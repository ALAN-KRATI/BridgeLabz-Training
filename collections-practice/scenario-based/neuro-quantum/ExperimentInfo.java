public class ExperimentInfo  implements Experiment{
	private int experimentId;
	private String experimentTitle;
	private String leadResearcher;
	private double fundingAmount;
	private String complexityLevel;
	private int initiationMonth;
	private int initiationYear;
	
	public ExperimentInfo() {}
	
	public ExperimentInfo(int experimentId, String experimentTitle, String leadResearcher, double fundingAmount, String complexityLevel, int initiationMonth, int initiationYear) {
		this.experimentId = experimentId;
		this.experimentTitle = experimentTitle;
		this.leadResearcher = leadResearcher;
		this.fundingAmount = fundingAmount;
		this.complexityLevel = complexityLevel;
		this.initiationMonth = initiationMonth;
		this.initiationYear = initiationYear;
	}
	
	public int getExperimentId() { return experimentId; }
	public String getExperimentTitle() { return experimentTitle; }
	public String getLeadResearcher() { return leadResearcher; }
	public double getFundingAmount() { return fundingAmount; }
	public String getComplexityLevel() { return complexityLevel; }
	public int getInitiationMonth() { return initiationMonth; }
	public int getInitiationYear() { return initiationYear; }
	
	@Override
	public String toString() {
		return experimentId + " | " + experimentTitle + " | " + leadResearcher + " | " + fundingAmount + " | " + complexityLevel + " | " +  initiationMonth + " | " + initiationYear;
	}
	
	public double calculateInnovationScore(int monthsActive) {
		double complexityMultiplier = getComplexityMulitplier(complexityLevel);
		double innovationScore = (complexityMultiplier * monthsActive * fundingAmount) / 1000;
		
		return innovationScore;
	}
	
	private double getComplexityMulitplier(String complexityLevel) {
		if(complexityLevel.equalsIgnoreCase("qubitopt")) {
			return 1.5;
		}
		else if(complexityLevel.equalsIgnoreCase("entanglement")) {
			return 2.5;
		}
		else {
			return 3.5;
		}
	}
	
	public double calculateResourceConsumption(int monthsActive) {
		double consumption = getConsumptionRate(complexityLevel);
		double resourceConsumption = (consumption * monthsActive * fundingAmount) / 100;
		
		return Double.parseDouble(String.format("%.1f", resourceConsumption));
	}
	
	private double getConsumptionRate(String complexityLevel) {
		if(complexityLevel.equalsIgnoreCase("qubitopt")) {
			return 0.8;
		}
		else if(complexityLevel.equalsIgnoreCase("entanglement")) {
			return 1.2;
		}
		else {
			return 1.8;
		}
	}
}
