public class Student {
    private int id;
    private String name;
    private String course;

    public Student(int id, String name, String course){
        this.id = id;
        this.name = name;
        this.course = course;
    }

    public int getId(){
        return id;
    }

    public void setName(String newName){
        this.name = newName;
    }

    public String getName(){
        return getName();
    }

    public void setCourse(String newcourse){
        this.course = newcourse;
    }

    public String getCourse(){
        return course;
    }

}
