public class Main {
    public static void main(String[] args) {
        ShiftScheduler scheduler = new ShiftScheduler();

        Employee e1 = new Employee("101", "Aman", "9876543210");
        Employee e2 = new Employee("102", "Riya", "9123456780");
        Employee e3 = new Employee("103", "Kabir", "9012345678");

        scheduler.addEmployee(e1);
        scheduler.addEmployee(e2);
        scheduler.addEmployee(e3);

        try {
            scheduler.assignShift(e1, ShiftTime.MORNING);
            scheduler.assignShift(e2, ShiftTime.AFTERNOON);
            scheduler.assignShift(e3, ShiftTime.NIGHT);

            scheduler.assignShift(e1, ShiftTime.NIGHT);

        } catch (ShiftAlreadyAssignedException e) {
            System.out.println(e.getMessage());
        }

        scheduler.displaySchedule();
    }
}