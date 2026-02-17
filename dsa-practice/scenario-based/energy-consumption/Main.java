public class Main {
    public static void main(String[] args){
        EnergyManager m = new EnergyManager();

        try{
            m.addEnergyReading("1 Feb", 25);
            m.addEnergyReading("1 Feb", 60);

            m.addEnergyReading("2 Feb", 77);
            m.addEnergyReading("2 Feb", 98);
            m.addEnergyReading("2 Feb", 56);

            m.addEnergyReading("3 Feb", 102);
            m.addEnergyReading("3 Feb", 67);
            m.addEnergyReading("3 Feb", -5);
            m.addEnergyReading("3 Feb", 34);
        }
        catch(InvalidEnergyReadingException e){
            System.out.println(e.getMessage());
        }

        System.out.println("----- Daily Average Reading ----");
        m.calculateDailyAverage();

        System.out.println("----- Monthly Average Rating -----");
        System.out.println(m.calculateMontlyReading());
    }
    
}
