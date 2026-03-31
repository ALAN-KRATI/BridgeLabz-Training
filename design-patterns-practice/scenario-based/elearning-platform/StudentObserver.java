interface Observer{
    void update(String message);
}

public class StudentObserver implements Observer{
    private String name;

    public StudentObserver(String name){
        this.name = name;
    }

    public void update(String message){
        System.out.println(name + " notification: " + message);
    }
}
