public class BankingSystem {
    public static void main(String[] args){
        BankCore core = BankCore.getInstance();

        Account savings = AccountFactory.createAccountType("savings");
        Account current = AccountFactory.createAccountType("current");
        Account loan = AccountFactory.createAccountType("loan");

        savings.showAccountType();
        current.showAccountType();
        loan.showAccountType();

        AccountService service = new AccountService();
        service.addObserver(new TransactionObserver("Alice"));
        service.addObserver(new TransactionObserver("Bob"));

        service.credit();
        service.debit();
        service.lowBalance();

        LoanApplication app = new LoanApplication.LoanApplicationBuilder("Valid")
                                                 .proof("Verified")
                                                 .guarantor("Approved")
                                                 .documents("submitted")
                                                 .build();
                                            
        
        core.addLoan(app);
        app.showLoanApplication();
    }
}
