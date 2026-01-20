import java.util.List;
import java.util.Map;

public class EvaluationStrategyImplementation implements EvaluationStrategy {
    
     public int evaluate(List<Question> questions, Map<Integer, String> answers) {
        int score = 0;
        for (Question q : questions) {
            if (q.getCorrectAnswer().equals(answers.get(q.getQuestionId()))) {
                score += q.getMarks();
            }
        }
        return score;
    }
}
