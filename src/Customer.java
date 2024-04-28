import java.util.*;

public class Customer {
    private String customerFirstName;
    private String customerLastName;
    private int customerPIN;

    Map<Integer, Account> customerAccounts = new HashMap<>();


    public Customer (String FirstName, String LastName, int PIN){
        this.customerFirstName = FirstName;
        this.customerLastName = LastName;
        this.customerPIN = PIN;
    }

    public String getCustomerFirstName() {
        return customerFirstName;
    }

    public void setCustomerFirstName(String customerFirstName) {
        this.customerFirstName = customerFirstName;
    }

    public String getCustomerLastName() {
        return customerLastName;
    }

    public void setCustomerLastName(String customerLastName) {
        this.customerLastName = customerLastName;
    }

    public int getCustomerPIN() {
        return customerPIN;
    }

    public void setCustomerPIN(int customerPIN) {
        this.customerPIN = customerPIN;
    }

    public void add(Checking account){
        customerAccounts.put(account.getAccountNumber(), account);
    }
    public void add(Savings account){
        customerAccounts.put(account.getAccountNumber(), account);
    }

    public void remove(Checking account){
        customerAccounts.remove(account.getAccountNumber());
    }
    public void remove(Savings account){
        customerAccounts.remove(account.getAccountNumber());
    }
    public void remove(Account account){
        customerAccounts.remove(account.getAccountNumber());
    }

    public Account getAccount(int accountNumber){
        return customerAccounts.get(accountNumber);
    }

    public StringBuilder getAllAccounts(){
        StringBuilder str = new StringBuilder();

        customerAccounts.forEach((allAccounts, accounts) ->{
            str.append(accounts);
        });

        return str;
    }

    @Override
    public String toString(){
        return String.format("Customer Name: %s %s ; Customer PIN: %s", customerFirstName,customerLastName,customerPIN);
    }

}

