interface Observer{
    void update(String message);
}

interface User extends Observer{
    void showRole();
}

class Patients implements User{
    private String name;
    public Patients(String name){ this.name = name; }
    public void showRole(){ System.out.println(name + " is a Patient."); }
    public void update(String message){ System.out.println( name + " notification: " + message); }
}

class Doctors implements User {
    private String name;
    public Doctors(String name){ this.name = name; }
    public void showRole(){ System.out.println(name + " is a Doctor."); }
    public void update(String message){ System.out.println( name + " notification: " + message); }
}

class Admins implements User{
    private String name;
    public Admins(String name){ this.name = name; }
    public void showRole(){ System.out.println(name + " is a Admin."); }
    public void update(String message){ System.out.println( name + " notification: " + message); }
}

public class UserFactory {
    public static User createUser(String type, String name){
        switch(type.toLowerCase()){
            case "patient": return new Patients(name);
            case "doctor": return new Doctors(name);
            case "admin": return new Admins(name);
            default: throw new IllegalArgumentException("Invalid type.");
        }
    }
}
