import java.time.LocalDate;

public class NoHelmetVoilation extends Voilation{
    public NoHelmetVoilation(LocalDate date, String location){
        super(date, location);
    }

    @Override
    public double calculateFine(){
        return 500;
    }
}