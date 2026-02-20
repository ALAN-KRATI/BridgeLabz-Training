import java.time.LocalDate;

public abstract class Voilation {
    private LocalDate date;
    private String location;

    public Voilation(LocalDate date, String location){
        this.date = date;
        this.location = location;
    }

    public LocalDate getDate(){ return date; }
    public String getLocation(){ return location; }

    public abstract double calculateFine();
}






