import java.util.HashMap;
import java.util.Map;

public abstract class Account {
    Double accountBalance;
    Integer accountNumber;
    static Integer numOfAccounts = 1000;

    public Account(Double InitialDeposit){
        this.accountBalance = InitialDeposit;
        numOfAccounts += 1;
        this.accountNumber = numOfAccounts;
    }

    public Double getAccountBalance() {
        return accountBalance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void deposit(Double amountDeposited){
        this.accountBalance += amountDeposited;
        System.out.printf("Amount of $%.2f deposited!\n" +
                "New Balance = $%.2f\n", amountDeposited, this.accountBalance);
    }

    public abstract void withdrawal(Double amountTaken);

    @Override
    public String toString(){
        return String.format("Account Balance: $%.2f ; Account Number: %d\n",accountBalance,accountNumber);
    }

}