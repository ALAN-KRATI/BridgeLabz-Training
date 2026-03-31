import java.util.ArrayList;
import java.util.List;

interface Subject{
    void addObserver(Observer o);
    void removerObserver(Observer o);
    void notifyObserver();
}

public class Transaction implements Subject {
    private String status;
    List<Observer> observers = new ArrayList<>();
    
    public Transaction(String status){
        this.status = status;
    }

    public void addObserver(Observer o ){ observers.add(o); }
    public void removerObserver(Observer o){ observers.remove(o); }

    public void notifyObserver(){
        for(Observer o : observers){
            o.update(status);
        }
    }

    public void process(){
        notifyObserver();
    }
}
