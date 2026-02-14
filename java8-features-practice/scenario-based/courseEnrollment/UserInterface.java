import java.time.LocalDate;
import java.util.Scanner;

public class UserInterface {
    public static void displayMenu(){
        System.out.println("---------- ONLINE COURSE ENROLLMENT SYSTEM ----------");
        System.out.println("1. Add Enrollment");
        System.out.println("2. Filter by course name");
        System.out.println("3. Filter by course category.");
        System.out.println("4. Group By course Name");
        System.out.println("5. Count enrollment per category");
        System.out.println("6. Sort by enrollment date");
        System.out.println("7. Exit");
        System.out.println("Enter your choice: ");
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        boolean b = true;
        EnrollmentManager manager = new EnrollmentManager();

        while(b){
            displayMenu();
            int choice = sc.nextInt();
            sc.nextLine();

            switch(choice){
                case 1:
                    System.out.println("Enter Student name: ");
                    String studentName = sc.nextLine();
                    System.out.println("Enter course name: ");
                    String courseName = sc.nextLine();
                    System.out.println("Enter course category: ");
                    String category = sc.nextLine();
                    System.out.println("Enter enrollment date: ");
                    LocalDate date = LocalDate.parse(sc.nextLine());

                    manager.addEnrollment(new Enrollment(studentName, courseName, category, date));
                    break;
                
                case 2:
                    System.out.println("Enter course name to filter: ");
                    String course = sc.nextLine();
                    manager.filterByCourse(course).forEach(System.out::println);
                    break;
                
                case 3:
                    System.out.println("Enter course category to filter: ");
                    String cat = sc.nextLine();
                    manager.filterByCategory(cat).forEach(System.out::println);
                    break;

                case 4:
                    System.out.println("Enrollments grouped by course names: ");
                    manager.groupByCourse().forEach((s, en) -> System.out.println(s + " -> " + en));
                    break;
                
                case 5:
                    System.out.println("Count of enrollment per category: ");
                    manager.countPerCategory().forEach((s, i) -> System.out.println(s + " -> " + i));
                    break;
                
                case 6:
                    System.out.println("Sorted by enrollment date: ");
                    manager.sortByDate().forEach(System.out::println);
                    break;
                
                case 7: 
                    b = false;
                    break;
            }
        }
    }
}
