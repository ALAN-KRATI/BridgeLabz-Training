import java.time.LocalDate;
import java.util.Objects;

public class Enrollment {
    private String studentName;
    private String courseName;
    private String category;
    private LocalDate enrollmentDate;

    public Enrollment(String studentName, String courseName, String category, LocalDate enrollmentDate){
        this.studentName = studentName;
        this.courseName = courseName;
        this.category = category;
        this.enrollmentDate = enrollmentDate;
    }

    public String getStudentName(){ return studentName; }
    public String getCourseName(){ return courseName; }
    public String getCategory(){ return category; }
    public LocalDate getEnrollmentDate(){ return enrollmentDate; }

    public String toString(){
        return studentName + " | " + courseName + " | " + category + " | " + enrollmentDate;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(!(o instanceof Enrollment)) return false;
        Enrollment that = (Enrollment) o;

        return Objects.equals(studentName, that.studentName) && 
               Objects.equals(courseName, that.courseName) &&
               Objects.equals(category, that.category) &&
               Objects.equals(enrollmentDate, that.enrollmentDate);
    }

    @Override
    public int hashCode(){
        return Objects.hash(studentName, courseName, category, enrollmentDate);
    }
}
