public class Main {
    public static void main(String[] args){
        TempManager manager = new TempManager();
        manager.addRoom("R1");
        manager.addRoom("R2");

        try{
            manager.addTemperature("R1", 4.5);
            manager.addTemperature("R1", 5.2);
            manager.addTemperature("R1", 9.0);  

            manager.addTemperature("R2", 3.0);
            manager.addTemperature("R2", -80); 
        }
        catch(SensorFailureException e){
            System.out.println(e.getMessage());
        }

        manager.displayAverage("R1");
        manager.displayAverage("R2");
    }    
}
