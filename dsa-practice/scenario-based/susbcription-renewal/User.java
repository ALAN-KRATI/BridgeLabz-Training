public class User{
    private String userName;
    private boolean expiryStatus;
    private Subscription subscription;

    public User(String userName, boolean expiryStatus, Subscription subscription){
        this.userName = userName;
        this.expiryStatus = expiryStatus;
        this.subscription = subscription;
    }

    public String getUserName(){ return userName; }
    public boolean getExpiryStatus(){ return expiryStatus; }
    public Subscription getSubscription(){ return subscription; }

    @Override
    public String toString(){
        return userName + " | " + expiryStatus + " | " + subscription;
    }
}