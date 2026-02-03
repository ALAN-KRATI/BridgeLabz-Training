package cooltrack;

public class DataCenter {
	private String dataCenterId;
	private String location;
	private String supervisorName;
	private double coolingPowerUsage;
	
	public DataCenter(String dataCenterId, String location, String supervisorName, double coolingPowerUsage) {
		this.dataCenterId = dataCenterId;
		this.location = location;
		this.supervisorName = supervisorName;
		this.coolingPowerUsage = coolingPowerUsage;
	}
	
	public String getDataCenterID() { return dataCenterId;}
	public String getLocation() { return location;}
	public String getSupervisorName() { return supervisorName;}
	public double getCoolingPowerUsage() { return coolingPowerUsage;}
	
	public String toString() {
		return dataCenterId + "|" + location + "|" + supervisorName + "|" + coolingPowerUsage;
	}
}
