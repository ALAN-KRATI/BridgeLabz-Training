import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TankManager {
    private List<Tank> tankList = new ArrayList<>();

    public void addTank(Tank tank){
        tankList.add(tank);
    }

    public double usagePercentage(Tank t){
        return (t.getCurrentLevel()/t.getCapacity()) * 100;
    }

    public void AlertTrigger(){
        for(Tank t : tankList){
            if(usagePercentage(t) < 20){
                System.out.println("Alert: Tank" + t.getTankId() + " below 20%!");
            }
        }
    }

    public List<Tank> sortByLevel(){
        return tankList.stream()
                        .sorted(Comparator.comparing(Tank::getCurrentLevel))
                        .collect(Collectors.toList());
    }
}
