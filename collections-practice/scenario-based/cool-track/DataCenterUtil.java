package cooltrack;
import java.util.*;

public class DataCenterUtil {
	private Set<DataCenter> dataCenterSet = new LinkedHashSet<>();
	
	public void addDataCenter(DataCenter dataCenter) {
		dataCenterSet.add(dataCenter);
	}
	
	public DataCenter getDataCenterById(String dataCenterId) {
		for(DataCenter dc : dataCenterSet) {
			if(dc.getDataCenterID().equalsIgnoreCase(dataCenterId)) {
				return dc;
			}
		}
		
		return null;
	}
	
	public List<DataCenter> getDataCentersWithMaximumCoolingPowerUsage(){
		List<DataCenter> list = new ArrayList<>();
		double max = Double.MIN_VALUE;
		
		for(DataCenter dc : dataCenterSet) {
			if(dc.getCoolingPowerUsage() > max) {
				max = dc.getCoolingPowerUsage();
			}
		}
		
		for(DataCenter dc : dataCenterSet) {
			if(dc.getCoolingPowerUsage() == max) {
				list.add(dc);
			}
		}
		
		return list;
	}
}
