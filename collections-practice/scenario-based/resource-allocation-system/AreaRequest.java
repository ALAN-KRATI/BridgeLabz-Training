import java.util.Map;

public class AreaRequest {
    private String area;
    private Map<String, Integer> requestedResource;

    public AreaRequest(String area, Map<String, Integer> requestedResource){
        this.area = area;
        this.requestedResource = requestedResource;
    }

    public String getArea(){ return area; }
    public Map<String, Integer> getRequestedResource(){ return requestedResource; }
}
