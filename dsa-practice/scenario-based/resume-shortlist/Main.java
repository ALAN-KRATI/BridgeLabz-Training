public class Main {
    public static void main(String[] args){
        ResumeManager manager = new ResumeManager();
        Resume r1 = new Resume("Alice");
        Resume r2 = new Resume("Bob");
        Resume r3 = new Resume("Jack");

        r1.addSkill("HTML");
        r1.addSkill("SQL");
        r1.addSkill("Java");

        r2.addSkill("Java");
        r2.addSkill("CSS");

        r3.addSkill("AIML");

        try{
            manager.addResume(r1);
            manager.addResume(r2);
            manager.addResume(r3);
        }
        catch(InvalidResumeException e){
            System.out.println(e.getMessage());
        }

        manager.shortlisted();
    }
    
}
