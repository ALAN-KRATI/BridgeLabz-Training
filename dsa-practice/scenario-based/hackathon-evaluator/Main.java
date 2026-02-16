import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        HackathonEvaluator system = new HackathonEvaluator();

        try {

            Participant p1 = new Participant("Aman", LocalTime.of(17, 30));
            p1.addResult("Q1", true);
            p1.addResult("Q2", true);
            p1.addResult("Q3", false);

            Participant p2 = new Participant("Riya", LocalTime.of(17, 50));
            p2.addResult("Q1", true);
            p2.addResult("Q2", false);
            p2.addResult("Q3", false);

            Participant p3 = new Participant("Kabir", LocalTime.of(18, 30)); // late
            p3.addResult("Q1", true);

            system.submit(p1);
            system.submit(p2);
            system.submit(p3); 

        } catch (LateSubmissionException e) {
            System.out.println(e.getMessage());
        }

        system.displayLeaderboard();
    }
}
