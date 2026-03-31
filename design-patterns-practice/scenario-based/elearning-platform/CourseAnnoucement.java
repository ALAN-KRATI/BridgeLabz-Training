import java.util.ArrayList;
import java.util.List;

interface Subject{
    void addObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers(String message);
}

public class CourseAnnoucement implements Subject{
    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer o){ observers.add(o); }
    public void removeObserver(Observer o){ observers.remove(o); }

    public void notifyObservers(String message){
        for(Observer o : observers){
            o.update(message);
        }
    }

    public void setStatus(String message){
        notifyObservers(message);
    }
}
