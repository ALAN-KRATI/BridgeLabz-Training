import java.util.HashSet;
import java.util.Set;

public class Resume {
    private String name;
    private Set<String> skills = new HashSet<>();
    private int matchScore;

    public Resume(String name){
        this.name = name;
    }

    public String getName(){ return name; }
    public Set<String> getSkills(){ return skills; }
    public int getMatchScore(){ return matchScore; }

    public void addSkill(String skill){
        skills.add(skill);
    }

    public void setMatchScore(int score){ this.matchScore = score; }

    public String toString(){
        return name + " -> " + skills + " | Score: " + matchScore;
    }
}
