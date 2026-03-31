import java.util.ArrayList;
import java.util.List;

public class AccountService {
    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer o){
        observers.add(o);
    }

    public void credit(){
        Transaction t = new Transaction("Money creditied");
        observers.forEach(t::addObserver);
        t.process();
    }

    public void debit(){
        Transaction t = new Transaction("Money debited");
        observers.forEach(t::addObserver);
        t.process();
    }

    public void lowBalance(){
        Transaction t = new Transaction("Balance below threshold.");
        observers.forEach(t::addObserver);
        t.process();
    }
}
