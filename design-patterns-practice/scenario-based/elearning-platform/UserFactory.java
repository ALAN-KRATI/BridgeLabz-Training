interface User{
    void showRole();
}

class Student implements User{
    private String name;
    public Student(String name){
        this.name = name;
    }
    public void showRole(){
        System.out.println(name + " is a Student.");
    }
}

class Instructor implements User{
    private String name;
    public Instructor(String name){
        this.name = name;
    }
    public void showRole(){
        System.out.println(name + " is a Instructor.");
    }
}

class Adminstrator implements User{
    private String name;
    public Adminstrator(String name){
        this.name = name;
    }
    public void showRole(){
        System.out.println(name + " is a Administrator.");
    }
}

public class UserFactory {
    public static User createUser(String type, String name){
        switch(type.toLowerCase()){
            case "student": return new Student(name);
            case "instructor": return new Instructor(name);
            case "administrator": return new Adminstrator(name);
            default: throw new IllegalArgumentException("Invalid type");
        }
    }
}
