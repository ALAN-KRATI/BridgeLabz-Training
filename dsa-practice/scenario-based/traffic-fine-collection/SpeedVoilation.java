import java.time.LocalDate;

public class SpeedVoilation extends Voilation{
    private int overSpeed;

    public SpeedVoilation(LocalDate date, String location, int overSpeed){
        super(date, location);
        this.overSpeed = overSpeed;
    }

    @Override
    public double calculateFine(){
        if(overSpeed <= 20) return 1000;
        else if(overSpeed <= 40) return 2000;
        else return 4000;
    }
}