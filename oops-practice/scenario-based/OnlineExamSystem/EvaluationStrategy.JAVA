interface EvaluationStrategy{
   int evaluate(
        List<Question> questions,
        Map<Integer, String> submittedAnswers
    );
    //public String evaluateExam(List<String> answers);

}