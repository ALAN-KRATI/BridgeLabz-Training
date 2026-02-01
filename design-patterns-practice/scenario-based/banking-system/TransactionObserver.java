interface Observer{
    void update(String status);
}

public class TransactionObserver implements Observer {
    private String name;

    public TransactionObserver(String name){
        this.name = name;
    }

    public void update(String status){
        System.out.println(name + " notification: Account - " + status);
    }
}
