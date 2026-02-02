public class TaxiService implements TransportService {
    public String getService(){ return "Taxi"; }
    public String getRoute(){ return "Mathura - Agra" ;}
    public double getFair(){ return 700;}
    public int getDepartureTime(){
        return 1600;
    }
}