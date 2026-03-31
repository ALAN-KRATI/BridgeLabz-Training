import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AttendanceManager {
    private Set<String> ids = new HashSet<>();
    private Map<String, Set<String>> attendance = new HashMap<>();

    public void addStudentId(String id){
        ids.add(id);
        System.out.println("Student ID added succesfully.");
    }

    public void markAttendance(String sessionId, String studentId) throws DuplicateAttendanceException{
        attendance.putIfAbsent(sessionId, new HashSet<>());

        Set<String> studentIds = attendance.get(sessionId);
        if(studentIds.contains(studentId)){
            throw new DuplicateAttendanceException("\nAttendance already marked for this Student ID.");
        }

        studentIds.add(studentId);
        System.out.println("\nAttendance has been marked.");
    }

    public void removeAttendance(String sessionId, String studentId) throws DuplicateAttendanceException{
        if(attendance.containsKey(sessionId)){
            if(attendance.get(sessionId).remove(studentId)){
                System.out.println("\nAttendance has been removed.");
            }
            else{
                System.out.println("\nStudent ID not found.");
            }
        }
        else{
            System.out.println("\nSession does not exist.");
        }
    }

    public void displayAttendance(){
        for(String session : attendance.keySet()){
            System.out.println("\nSession Id: " + session);
            for(String id : attendance.get(session)){
                System.out.print(id + " ");
            }
            System.out.println();
        }
    }
}
