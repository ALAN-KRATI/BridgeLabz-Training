import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

public class Participant {
    private String name;
    private LocalTime submissionTime;
    private Map<String, Boolean> results = new HashMap<>();

    public Participant(String name, LocalTime time){
        this.name = name;
        this.submissionTime = time;
    }

    public String getName(){ return name; }
    public LocalTime getSubmissionTime(){ return submissionTime; }

    public void addResult(String id, boolean passes){
        results.put(id, passes);
    }

    public int calculateScore(){
        int score = 0;
        for(boolean r : results.values()){
            if(r == true){
                score++;
            }
        }

        return score;
    }

}
