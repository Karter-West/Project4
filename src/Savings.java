public class Savings extends Account{
    Double goalAmount;

    public Savings(Double InitialDeposit, Double GoalAmount){
        super(InitialDeposit);
        this.accountBalance = InitialDeposit;
        this.accountNumber = numOfAccounts;
        this.goalAmount = GoalAmount;
    }

    public Double getGoalAmount() {
        return goalAmount;
    }

    public void setGoalAmount(Double goalAmount) {
        this.goalAmount = goalAmount;
    }

    @Override
    public void withdrawal(Double amountTaken){
        if (this.accountBalance < this.goalAmount){
            System.out.println("You can not withdrawal from this account until you reach your goal amount.");
        }else{
            this.accountBalance -= amountTaken;
            System.out.printf("Withdrawal of $%.2f successful!\n" +
                    "New Balance = $%.2f\n", amountTaken, this.accountBalance);
        }
    }

}
