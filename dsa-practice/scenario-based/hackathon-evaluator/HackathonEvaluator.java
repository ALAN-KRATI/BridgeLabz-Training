import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class HackathonEvaluator {
    private List<Participant> participants = new ArrayList<>();
    private static final LocalTime DEADLINE = LocalTime.of(18, 0);

    public void submit(Participant p) throws LateSubmissionException{
        if(p.getSubmissionTime().isAfter(DEADLINE)){
            throw new LateSubmissionException(p.getName() + " submitted after deadline!");
        }

        participants.add(p);
        System.out.println(p.getName() + " submission accepted!");
    }

    private List<Participant> sortByScore(){
        return participants.stream()
                           .sorted(Comparator.comparing(Participant::calculateScore).reversed())
                           .collect(Collectors.toList());
    }

    public void displayLeaderboard() {
        List<Participant> list = sortByScore();

        System.out.println("\n===== LEADERBOARD =====");

        int rank = 1;
        for (Participant p : list) {
            System.out.println(rank++ + ". " + p.getName() + " | Score: " + p.calculateScore());
        }
    }

}
