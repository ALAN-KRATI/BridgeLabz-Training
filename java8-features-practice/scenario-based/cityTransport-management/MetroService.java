public class MetroService implements TransportService {
    public String getService(){ return "Metro"; }
    public String getRoute(){ return "Pari chowk - Capgemini" ;}
    public double getFair(){ return 80;}
    public int getDepartureTime(){
        return 1200;
    }
}