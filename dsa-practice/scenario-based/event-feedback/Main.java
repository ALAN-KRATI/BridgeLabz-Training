public class Main {
    public static void main(String[] args){
        EventManager manager = new EventManager();

        try{
            manager.addRating("TechTalk", 5);
            manager.addRating("TechTalk", 4);
            manager.addRating("TechTalk", 3);

            manager.addRating("Hackathon", 5);
            manager.addRating("Hackathon", 5);
            manager.addRating("Hackathon", 4);

            manager.addRating("Workshop", 2);
            manager.addRating("Workshop", 3);
            manager.addRating("Workshop", 4);

            manager.addRating("Seminar", 7);
        }
        catch(InvalidRatingException e){
            System.out.println(e.getMessage());
        }

        System.out.println("\n--- Average Ratings ---");
        manager.averageEventRating();

        System.out.println("\n--- Top Rated Events ---");
        manager.topRatedEvents();
    }
}
