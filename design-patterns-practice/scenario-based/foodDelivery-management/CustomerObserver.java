interface Observer{
    void update(String status);
}

public class CustomerObserver implements Observer {
    private String name;

    public CustomerObserver(String name){
        this.name = name;
    }

    public void update(String status){
        System.out.println(name + " notified: Order: "+ status);
    }
}
