import java.util.ArrayList;
import java.util.List;

interface Subject{
    void addObserver(Observer o);
    void removerObserver(Observer o);
    void notfiyObserver(String status);
}

public class Order implements Subject {
    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer o){ observers.add(o); }
    public void removerObserver(Observer o){ observers.remove(o); }

    public void notfiyObserver(String status){
        for(Observer o : observers){
            o.update(status);
        }
    }

    public void setStatus(String status){
        notfiyObserver(status);
    }    
}
