import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class SubscriptionManager {
    private List<User> users = new ArrayList<>();
    private DiscountStrategy discountStrategy;

    public SubscriptionManager(DiscountStrategy strategy){
        this.discountStrategy = strategy;
    }

    public void addUser(User user){
        users.add(user);
    }

    public void renewUserSubscription(){
        for(User u : users){
            Subscription sub = u.getSubscription();
            if(LocalDate.now().isAfter(sub.getEndDate())){
                if(u.getExpiryStatus()){
                    try{
                        renewNow(u);
                    }
                    catch(PaymentDeclinedException e){
                        System.out.println(e.getMessage());
                    }
                }
            }
        }
    }

    private void renewNow(User u) throws PaymentDeclinedException{
        Subscription sub = u.getSubscription();
        double discount = discountStrategy.calculateDiscount(sub.getPrice());

        Random random = new Random();
        boolean paymentstatus = random.nextBoolean();

        if(!paymentstatus){
            throw new PaymentDeclinedException("Payment declined for user " + u.getUserName());
        }

        sub.renew();
        System.out.println("Subscription renewed for " + u.getUserName() + " | Paid: " + discount);
    } 

    public List<User> getExpiredUsers(){
        return users.stream().filter(u -> LocalDate.now().isAfter(u.getSubscription().getEndDate())).collect(Collectors.toList());
    }
}
