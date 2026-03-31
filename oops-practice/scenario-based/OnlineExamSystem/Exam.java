class Exam {
    private int examId;
    private String subject;
    private List<Question> questions;
    private int durationInMinutes;

    public Exam(int examId, String subject, int durationInMinutes) {
        this.examId = examId;
        this.subject = subject;
        this.durationInMinutes = durationInMinutes;
        this.questions = new ArrayList<>();
    }

    public int getExamId() {
        return examId;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }
}
