import java.util.ArrayList;
import java.util.List;

public class CourseRegistry {
    private static CourseRegistry instance;
    private List<CourseContent> courses = new ArrayList<>();
    
    private CourseRegistry(){
        System.out.println("Course Registry initialized...");
    }

    public static synchronized CourseRegistry getInstance(){
        if(instance == null) instance = new CourseRegistry();
        return instance;
    }

    public void addCourse(CourseContent c){
        courses.add(c);
    }
}
