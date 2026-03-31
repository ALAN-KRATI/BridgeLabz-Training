import java.time.LocalDate;

public class SignalJumpVoilation extends Voilation{
    public SignalJumpVoilation(LocalDate date, String location){
        super(date, location);
    }

    @Override
    public double calculateFine(){
        return 1500;
    }
}