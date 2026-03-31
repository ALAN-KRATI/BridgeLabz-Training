public class ElearningPlatform {
    public static void main(String[] args){
        CourseRegistry instance = CourseRegistry.getInstance();

        User student = UserFactory.createUser("student", "Alice");
        User instructor = UserFactory.createUser("instructor", "Mr. Bob");
        User admin = UserFactory.createUser("administrator", "Alan");

        student.showRole();
        instructor.showRole();
        admin.showRole();

        CourseAnnoucement annoucement = new CourseAnnoucement();
        StudentObserver s1 = new StudentObserver("Alice");
        StudentObserver s2 = new StudentObserver("Claude");

        annoucement.addObserver(s1);
        annoucement.addObserver(s2);

        annoucement.setStatus("New lectures are uploaded");
        annoucement.setStatus("Assignments are posted");
        annoucement.setStatus("Deadlines change");

        CourseContent course = new CourseContent.CourseContentBuilder("Assigned")
                                                .pdfs("Included")
                                                .quizzes("Enabled")
                                                .videos("Available")
                                                .build();

        instance.addCourse(course);
        course.showCourseContents();
    }
}
