import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ExamSystem {
    Stack<Integer> visitedQuestions = new Stack<>();
    Map<Integer, String> answers = new HashMap<>();
    Map<Integer, String> correctAnswers = new HashMap<>();

    public ExamSystem(){
        correctAnswers.put(1, "Language");
        correctAnswers.put(2, "Concept");
        correctAnswers.put(3, "Python");
        correctAnswers.put(4, "this");
        correctAnswers.put(5, "super");
    }

    void visitQuestion(int id){
        visitedQuestions.push(id);
        System.out.println("Visited question: " + id);
    }

    void sumbitAnswer(int id, String ans){
        answers.put(id, ans);
    }

    void calculateScore() {
        int score = 0;

        for (int id : correctAnswers.keySet()) {
            if (correctAnswers.get(id).equalsIgnoreCase(answers.get(id))) {
                score++;
            }
        }
        
        System.out.println(score);
    }

}
