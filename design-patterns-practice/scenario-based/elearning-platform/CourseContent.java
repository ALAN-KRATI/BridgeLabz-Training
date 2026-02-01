class CourseContent {
    private String videos;
    private String pdfs;
    private String quizzes;
    private String assignments;

    public CourseContent(CourseContentBuilder builder){
        this.videos = builder.videos;
        this.pdfs = builder.pdfs;
        this.quizzes = builder.quizzes;
        this.assignments = builder.assignments;
    }

    public static class CourseContentBuilder{
        private String videos;
        private String pdfs;
        private String quizzes;
        private String assignments;

        public CourseContentBuilder(String assignments){
            this.assignments = assignments;
        }

        public CourseContentBuilder pdfs(String pdfs){
            this.pdfs = pdfs;
            return this;
        }

        public CourseContentBuilder quizzes(String quizzes){
            this.quizzes = quizzes;
            return this;
        }

        public CourseContentBuilder videos(String videos){
            this.videos = videos;
            return this;
        }

        public CourseContent build(){
            return new CourseContent(this);
        }
    }

    public void showCourseContents(){
        System.out.println("Videos: " + videos);
        System.out.println("PDFs: " + pdfs);
        System.out.println("Quizzes: " + quizzes);
        System.out.println("Assignments: " + assignments);
    }
}
