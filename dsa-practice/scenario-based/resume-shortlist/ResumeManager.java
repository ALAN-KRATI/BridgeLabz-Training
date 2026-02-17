import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ResumeManager {
    private Set<String> requiredSkills = new HashSet<>(Arrays.asList("Java", "SQL"));
    private List<Resume> resumes = new ArrayList<>();
    
    public void addResume(Resume resume) throws InvalidResumeException{
        if(resume == null || resume.getSkills() == null || resume.getSkills().isEmpty()){
            throw new InvalidResumeException("Skill set cannot be empty!");
        }
        resumes.add(resume);
    }

    public void evaluateResumes(){
        for(Resume r : resumes){
            int count = 0;
            for(String s : requiredSkills){
                if(r.getSkills().contains(s)){
                    count++;
                }
            }
            r.setMatchScore(count);
        }
    }

    public void shortlisted(){
        evaluateResumes();
        resumes.removeIf(r -> r.getMatchScore() == 0);

        Collections.sort(resumes, new ResumeComparator());

        System.out.println("---- Shortlisted Candidates ----");
        for(Resume r : resumes){
            System.out.println(r);
        }
    }
}
