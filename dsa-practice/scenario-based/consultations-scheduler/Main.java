public class Main {
    public static void main(String[] args){
        ConsultManager manager = new ConsultManager();

        Doctor d1 = new Doctor("Sharma", "Cardiology");
        d1.addSlot("10:00 A.M");
        d1.addSlot("11:00 A.M");

        Doctor d2 = new Doctor("Mehta", "Dermatology");
        d2.addSlot("12:00 P.M");

        manager.addDoctor(d1);
        manager.addDoctor(d2);

        Patient p1 = new Patient("Alice", 23);
        Patient p2 = new Patient("Bob", 25);

        try{
            manager.bookAppointment("Cardiology", p1, "10:00 A.M");
            manager.bookAppointment("Dermatology", p2, "12:00 P.M");
            manager.bookAppointment("Dermatology", p1, "10:00 A.M");
        }
        catch(SlotUnavailableException e){
            System.out.println(e.getMessage());
        }

        manager.displayHistory();
    }
}
