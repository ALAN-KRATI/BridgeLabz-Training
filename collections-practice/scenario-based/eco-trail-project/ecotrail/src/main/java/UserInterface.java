import java.util.Scanner;

public class UserInterface{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        TrailUtil util = new TrailUtil();

        System.out.println("Enter number of trails: ");
        int n = sc.nextInt();
        sc.nextLine();
        
        System.out.println("Enter Trail details: ");
        for(int i = 0; i < n; i++){
            String[] p = sc.nextLine().split(":");
            util.addTrailRecord(new Trail(p[0], p[1], p[2], p[3], Integer.parseInt(p[4])));
        }

        System.out.println("Enter the Trail Id to check hike status: ");
        String id = sc.nextLine();
        Trail t = util.getTrailById(id);
        System.out.println(t != null ? t : "Trail not found");


        System.out.println("\nMost hiked trails are: ");
        util.getMostHikedTrails().forEach(System.out::println);

        System.out.println("\nRegion-wise hike counts: ");
        util.getHikeCountByRegion().forEach((k, v) -> System.out.println(k + ": " + v));

        System.out.println("\nTrails grouped by difficulty: ");
        util.groupTrailsByDifficulty().forEach((k, v) -> System.out.println(k + " -> " + v.size()));
        
        
        System.out.println("\nEnter Trail Id to update hikes and additional hikes:");
        String trailId = sc.next();
        int additionalHikes = sc.nextInt();
        boolean b = util.updateHikeCount(trailId, additionalHikes);
       

        System.out.println("\nEnter to Filter trails by region and difficulty:");
        String region = sc.next();
        String diff = sc.next();
        util.filterTrails(region, diff).forEach(System.out::println);

        System.out.println("Enter k for top k trails per region: ");
        int k = sc.nextInt();
        util.getTopTrailsByRegion(k).forEach((k1, v) -> System.out.println(k1 + ": " + v));

        System.out.println("Difficulty statistics: ");
        util.getDifficultyStats().forEach((k2, v) -> System.out.println(k + ":" + v));

        sc.close();

    } 
}