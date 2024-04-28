public class Checking extends Account{

    public Checking(Double InitialDeposit){
        super(InitialDeposit);
        this.accountBalance = InitialDeposit;
        this.accountNumber = numOfAccounts;
    }

    @Override
    public void withdrawal(Double amountTaken){
        if (this.getAccountBalance() < amountTaken){
            System.out.println("There is not enough money in the account.");
        }else{
            this.accountBalance -= amountTaken;
            System.out.printf("Withdrawal of $%.2f successful!\n" +
                    "New Balance = $%.2f\n", amountTaken, this.accountBalance);
        }
    }

}
