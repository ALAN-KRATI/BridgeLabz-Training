import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShiftScheduler {
    private List<Employee> employees = new ArrayList<>();
    private Map<ShiftTime, List<Employee>> shifts = new HashMap<>();

    public ShiftScheduler(){
        for(ShiftTime shift : ShiftTime.values()){
            shifts.put(shift, new ArrayList<>());
        }
    }

    public void addEmployee(Employee em){
        employees.add(em);
    }

    private boolean isAlreadyAssigned(Employee em){
        for(List<Employee> l : shifts.values()){
            if(l.contains(em)) return true;
        }

        return false;
    }

    public void assignShift(Employee em, ShiftTime shift) throws ShiftAlreadyAssignedException{
        if(isAlreadyAssigned(em)){
            throw new ShiftAlreadyAssignedException("Employee " + em.getEmpName() + " already assigned a shift!");
        }

        shifts.get(shift).add(em);
        System.out.println(em.getEmpName() + " assigned to " + shift + " shift");
    }

    public void displaySchedule(){
        System.out.println("\n------ Shift Schedule ------");
        for(ShiftTime shift : shifts.keySet()){
            System.out.println("\n" + shift + " SHIFT: ");
            List<Employee> l = shifts.get(shift);
            if(l.isEmpty()){
                System.out.println("No employee assigned.");
            }
            else{
                for(Employee e : l){
                    System.out.println(e);
                }
            }
        }
    }
}
