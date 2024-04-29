class InsufficientBalanceException extends Exception{
    public InsufficientBalanceException(String message){
        super(message);
    }
}

class BankAccount{
    private double balance;
    public BankAccount(double initialBalance){
        this.balance = initialBalance;
    }
    public void witdraw(double amount) throws InsufficientBalanceException{
        if(amount > balance){
            throw new InsufficientBalanceException("Insufficient balance. Available balance: "+balance);
        }
        balance -= amount;
        System.out.println("Withdrawal of"+amount+" successful. Remaining balance "+balance);
    }
}

public class CustomException {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(50);
        try{
            account.witdraw(50000);
        }catch(InsufficientBalanceException insufficientBalanceException){
            insufficientBalanceException.printStackTrace();
        }
    }
}
