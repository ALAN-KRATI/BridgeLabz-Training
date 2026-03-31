import java.util.ArrayList;
import java.util.List;

public class BankCore{
    private static BankCore instance;
    private List<LoanApplication> applications = new ArrayList<>();

    private BankCore(){ 
        System.out.println("Bank Core"); 
        System.out.println();
    }

    public static synchronized BankCore getInstance(){
        if(instance == null) instance = new BankCore();
        return instance;
    }

    public void addLoan(LoanApplication l){
        applications.add(l);
    }

}