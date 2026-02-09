import java.util.Scanner;

public class UserInterface {

    public static void displayMenu(){
        System.out.println("---------- ONLINE ATTENDANCE MANAGER ----------");
        System.out.println("1. Add Student ID");
        System.out.println("2. Mark Attendance");
        System.out.println("3. Remove Attendance");
        System.out.println("4. Display Attendance");
        System.out.println("5. Exit");
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        AttendanceManager manager = new AttendanceManager();
        boolean b = true;

        try{
            while(b){
                displayMenu();
                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1:
                        String studentId1 = sc.nextLine();
                        manager.addStudentId(studentId1);
                        break;
                    case 2:
                        String sessionId1 = sc.nextLine();
                        String studentId2 = sc.nextLine();
                        manager.markAttendance(sessionId1, studentId2);
                        break;
                    case 3:
                        String sessionId2 = sc.nextLine();
                        String studentId3 = sc.nextLine();
                        manager.removeAttendance(sessionId2, studentId3);
                        break;
                    case 4:
                        manager.displayAttendance();
                        break;
                    case 5:
                        b = false;
                        break;
                    default:
                        System.out.println("Invalid choice");
                }
            }
        }
        catch(DuplicateAttendanceException e){
            System.out.println(e.getMessage());
        }
    }
}
