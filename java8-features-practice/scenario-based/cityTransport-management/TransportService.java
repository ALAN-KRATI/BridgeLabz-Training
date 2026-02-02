public interface TransportService{
    String getService();
    double getFair();
    String getRoute();
    int getDepartureTime();

    default void printServiceDetails(){
        System.out.println("Transport Service : " + getService() + " via route - " + getRoute() + " charge : " + getFair());
    }
}