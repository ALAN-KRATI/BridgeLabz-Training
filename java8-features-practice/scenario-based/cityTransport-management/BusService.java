public class BusService implements TransportService {
    public String getService(){ return "Bus"; }
    public String getRoute(){ return "Agra - Delhi" ;}
    public double getFair(){ return 420;}
    public int getDepartureTime(){
        return 800;
    }
}
