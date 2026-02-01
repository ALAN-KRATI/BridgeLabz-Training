public class DeliveryApp{
    public static void main(String[] args){
        OrderManager instance = OrderManager.getInstance();

        User customer = UserFactory.createUser("customer");
        User deliveryagent = UserFactory.createUser("deliveryagent");
        User owner = UserFactory.createUser("restaurantowner");
        customer.showRole();
        deliveryagent.showRole();
        owner.showRole();

        Order order = new Order();
        CustomerObserver c1 = new CustomerObserver("Alice");
        CustomerObserver c2 = new CustomerObserver("Bob");
        order.addObserver(c1);
        order.addObserver(c2);

        order.setStatus("Placed");
        order.setStatus("Preparing");
        order.setStatus("Delivered");

        instance.addOrder(order);

        Meal meal = new Meal.MealBuilder("Large")
                            .extraToppings("Cheese")
                            .spiceLevel("Medium")
                            .addOns("Cold drink")
                            .build();

        meal.showMeal();
    }
}