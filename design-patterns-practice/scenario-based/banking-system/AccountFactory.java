interface Account{
    void showAccountType();
}

class SavingsAccount implements Account{
    public void showAccountType(){
        System.out.println("A Savings Account.");
    }
}

class CurrentAccount implements Account{
    public void showAccountType(){
        System.out.println("A Current Account.");
    }
}

class LoanAccount implements Account{
    public void showAccountType(){
        System.out.println("A Loan Account.");
    }
}

public class AccountFactory {
    public static Account createAccountType(String type){
        switch (type.toLowerCase()) {
            case "savings" : return new SavingsAccount();
            case "current" : return new CurrentAccount();
            case "loan" : return new LoanAccount();
            default: throw new IllegalArgumentException("Invalid type");
        }
    }
}
