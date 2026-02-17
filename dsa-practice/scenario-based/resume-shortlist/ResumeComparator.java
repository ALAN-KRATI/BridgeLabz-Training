import java.util.Comparator;

public class ResumeComparator implements Comparator<Resume> {
    @Override
    public int compare(Resume r1, Resume r2){
        return r2.getMatchScore() - r1.getMatchScore();
    }
}
