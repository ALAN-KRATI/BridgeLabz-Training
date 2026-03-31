class LoanApplication {
    private String details;
    private String proof;
    private String guarantor;
    private String documents;

    public LoanApplication(LoanApplicationBuilder builder){
        this.details = builder.details;
        this.proof = builder.proof;
        this.guarantor = builder.guarantor;
        this.documents = builder.documents;
    }

    public static class LoanApplicationBuilder{
        private String details;
        private String proof;
        private String guarantor;
        private String documents;

        public LoanApplicationBuilder(String details){
            this.details = details;
        }

        public LoanApplicationBuilder proof(String proof){
            this.proof = proof;
            return this;
        }

        public LoanApplicationBuilder guarantor(String guarantor){
            this.guarantor = guarantor;
            return this;
        }

        public LoanApplicationBuilder documents(String documents){
            this.documents = documents;
            return this;
        }

        public LoanApplication build(){
            return new LoanApplication(this);
        }
    }

    public void showLoanApplication(){
        System.out.println("Employeement details: " + details);
        System.out.println("Income proof: " + proof);
        System.out.println("Guarantor's detail " + guarantor);
        System.out.println("Property documents: " + documents);
    }
}
