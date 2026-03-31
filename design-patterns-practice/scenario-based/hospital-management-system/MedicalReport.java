public class MedicalReport {
    private String diagnosis;
    private String testResults;
    private String prescription;
    private String doctorsRemark;

    public MedicalReport(MedicalReportBuilder builder){
        this.diagnosis = builder.diagnosis;
        this.testResults = builder.testResults;
        this.prescription = builder.prescription;
        this.doctorsRemark = builder.doctorsRemark;
    }

    public String getDiagnosis(){ return diagnosis; }

    public static class MedicalReportBuilder{
        private String diagnosis;
        private String testResults;
        private String prescription;
        private String doctorsRemark;

        public MedicalReportBuilder(String diagnosis){
            this.diagnosis = diagnosis;
        }

        public MedicalReportBuilder testResults(String testResults){
            this.testResults = testResults;
            return this;
        }

        public MedicalReportBuilder prescription(String prescription){
            this.prescription = prescription;
            return this;
        }

        public MedicalReportBuilder doctorsRemark(String doctorsRemark){
            this.doctorsRemark = doctorsRemark;
            return this;
        }

        public MedicalReport build(){
            return new MedicalReport(this);
        }
    }
}
