public class Main {

    public static void main(String[] args) {

        // HashMap: examId -> Exam
        Map<Integer, Exam> examMap = new HashMap<>();

        // Create Exam
        Exam exam = new Exam(1, 60);
        exam.addQuestion(new Question(1, "What is Java?", "Language", 5));
        exam.addQuestion(new Question(2, "What is OOP?", "Concept", 5));

        examMap.put(exam.getExamId(), exam);

        // Student
        Student student = new Student(101, "Alankrati");

        // Answers
        Map<Integer, String> answers = new HashMap<>();
        answers.put(1, "Language");
        answers.put(2, "Concept");

        // Time taken (minutes)
        int timeTaken = 55;

        try {
            if (timeTaken > exam.getDuration()) {
                throw new ExamTimeExpiredException("Exam time expired!");
            }

            EvaluationStrategy evaluator = new ObjectiveEvaluation();
            int score = evaluator.evaluate(exam.getQuestions(), answers);

            System.out.println("Student ID: " + student.getId());
            System.out.println("Score: " + score);

        } catch (ExamTimeExpiredException e) {
            System.out.println(e.getMessage());
        }
    }
}
