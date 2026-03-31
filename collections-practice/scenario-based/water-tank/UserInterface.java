public class UserInterface {
    public static void main(String[] args){
        TankManager manager = new TankManager();

        try{
            manager.addTank(new Tank("t1", 1000, 600));
            manager.addTank(new Tank("t2", 1200, 150));
            manager.addTank(new Tank("t3", 900, 850));
            manager.addTank(new Tank("t4", 800, 100));
            manager.addTank(new Tank("t5", 1000, 1200));
        }
        catch(InvalidWaterLevelException e){
            System.out.println(e.getMessage());
        }

        System.out.println("\n------ Water Tank Status ------");
        manager.AlertTrigger();

        System.out.println("------ Sorted by Lowest First ------");
        manager.sortByLevel().forEach(System.out::println);
    }
}
