import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class EnrollmentManager {
    private List<Enrollment> enrolled = new ArrayList<>();

    public void addEnrollment(Enrollment en){
        enrolled.add(en);
        System.out.println("Succesfully Enrolled!");
    }

    public List<Enrollment> filterByCourse(String course){
        return enrolled.stream()
                       .filter(en -> en.getCourseName().equalsIgnoreCase(course))
                       .collect(Collectors.toList());
    }

    public List<Enrollment> filterByCategory(String category){
        return enrolled.stream()
                       .filter(en -> en.getCategory().equalsIgnoreCase(category))
                       .collect(Collectors.toList());
    }

    public Map<String, List<Enrollment>> groupByCourse(){
        return enrolled.stream()
                       .collect(Collectors.groupingBy(
                        Enrollment::getCourseName
                       ));
    }

    public Map<String, Long> countPerCategory(){
        return enrolled.stream()
                       .collect(Collectors.groupingBy(
                        Enrollment::getCategory,
                        Collectors.counting()
                       ));
    }

    public List<Enrollment> sortByDate(){
        return enrolled.stream()
                       .sorted(Comparator.comparing(Enrollment::getEnrollmentDate))
                       .toList();
    }

}
