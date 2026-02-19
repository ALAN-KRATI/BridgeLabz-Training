import java.time.LocalDate;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        DiscountStrategy strategy = new FestiveDiscount();
        SubscriptionManager manager = new SubscriptionManager(strategy);

        User u1 = new User("Alice", true, new Subscription(LocalDate.now().minusDays(2), 500));
        User u2 = new User("Bob", false, new Subscription(LocalDate.now().minusDays(1), 400));
        User u3 = new User("Charlie", true, new Subscription(LocalDate.now().plusDays(5), 600));

        manager.addUser(u1);
        manager.addUser(u2);
        manager.addUser(u3);

    
        manager.renewUserSubscription();
        

        System.out.println("\n--- Expired Users ---");
        List<User> expired = manager.getExpiredUsers();
        expired.forEach(u -> System.out.println(u.getUserName()));
    }
}