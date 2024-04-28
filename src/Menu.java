import java.util.Scanner;
public class Menu {
    Scanner scnr = new Scanner(System.in);
    Bank bank = new Bank();

    public void runMenu(){
        int userSelection;

        while(true){

            System.out.println("-------Menu-------\n" +
                    "1. Access an account\n" +
                    "2. Open a new account\n" +
                    "3. Close all accounts\n" +
                    "4. Exit\n" +
                    "Please Select an option:");

            userSelection = Integer.parseInt(scnr.nextLine());

            if (userSelection == 1){
                accessAnAccount();
            }else if (userSelection == 2){
                System.out.println("Are you a returning customer, Y or N?");
                while(true) {
                    String newAnswer = scnr.nextLine().toUpperCase();
                    if (newAnswer.equals("Y")) {
                        createAnAccount();
                        break;
                    } else if (newAnswer.equals("N")) {
                        createNewCustomer();
                        break;
                    } else {
                        System.out.println("Please enter Y or N!");
                    }
                }
            }else if (userSelection == 3){
                closeAllAccounts();
            }else if (userSelection == 4){
                break;
            }else{
                System.out.println("Please select one of the given options!");
            }

        }

    }

    private void accessAnAccount(){
        System.out.println("Enter in your PIN");
        int pin = Integer.parseInt(scnr.nextLine());
        int accountNumber;

        if (bank.getCustomer(pin) == null){
            System.out.println("Invalid PIN.");
        }else{
            Customer customer = bank.getCustomer(pin);
            System.out.printf("Hello %s!\n", customer.getCustomerFirstName());
            System.out.println(bank.getCustomer(pin).getAllAccounts());
            while(true) {
                System.out.println("Enter desired accounts account number.");
                accountNumber = Integer.parseInt(scnr.nextLine());
                if (customer.getAccount(accountNumber) == null) {
                    System.out.println("Invalid account number.");
                } else {
                    Account account = customer.getAccount(accountNumber);
                    while (true) {
                        System.out.println("Please choose an option:\n" +
                                "1. Make a deposit\n" +
                                "2. Make a withdrawal\n" +
                                "3. Check Balance\n" +
                                "4. Close Account\n" +
                                "5. Exit");

                        int selection = Integer.parseInt(scnr.nextLine());

                        if (selection == 1) {
                            while(true) {
                                System.out.println("How much would you like to deposit?");
                                double deposit = Double.parseDouble(scnr.nextLine());
                                if (deposit < .01){
                                    System.out.println("Please enter a positive number.");
                                }else {
                                    account.deposit(deposit);
                                    break;
                                }
                            }

                        } else if (selection == 2) {
                            while(true) {
                                System.out.println("How much would you like to withdrawal?");
                                double withdrawal = Double.parseDouble(scnr.nextLine());
                                if (withdrawal > account.getAccountBalance()){
                                    System.out.println("Amount must be less than what is in your account.");
                                }else if (withdrawal < .01){
                                    System.out.println("Please enter a positive number.");
                                }else{
                                    account.withdrawal(withdrawal);
                                    break;
                                }
                            }

                        } else if (selection == 3) {
                            System.out.printf("Current balance: $%.2f\n", account.getAccountBalance());
                        } else if (selection == 4) {
                            customer.remove(account);
                            System.out.println("This account has been successfully removed.");
                            break;
                        } else if (selection == 5) {
                            break;
                        } else {
                            System.out.println("Please select one of the given options!");
                        }
                    }
                    break;
                }
            }
        }

    }

    private void createAnAccount(){
        System.out.println("Enter in your PIN:");

        while(true){
            int pin = Integer.parseInt(scnr.nextLine());

            if (bank.getCustomer(pin) == null){
                System.out.println("PIN not found");
            }else{
                Customer customer = bank.getCustomer(pin);

                System.out.printf("Hello %s.\n",customer.getCustomerFirstName());

                while (true) {
                    System.out.println("Would you like this account to be a checking or savings account?");
                    String accountType = scnr.nextLine();

                    if (accountType.equalsIgnoreCase("checking")) {
                        System.out.println("What would you like you initial deposit to be?");
                        while (true) {
                            double initialDeposit = Double.parseDouble(scnr.nextLine());

                            if (initialDeposit < .01) {
                                System.out.println("Please enter a positive number!");
                            } else {
                                Checking account = new Checking(initialDeposit);
                                customer.add(account);
                                System.out.printf("Account has been opened. Your account number is %d, Your current balance is $%.2f.\n", account.getAccountNumber(),account.getAccountBalance());
                                break;
                            }
                        }
                        break;
                    } else if (accountType.equalsIgnoreCase("savings")){
                        System.out.println("How much are you trying to save?");
                        Double saveValue = Double.parseDouble(scnr.nextLine());
                        while (true) {
                            System.out.println("How much is your initial deposit going to be?");
                            double initialDeposit = Double.parseDouble(scnr.nextLine());

                            if (initialDeposit < .01) {
                                System.out.println("Please enter a positive number!");
                            } else {
                                Savings account = new Savings(initialDeposit, saveValue);
                                customer.add(account);
                                System.out.printf("Account has been opened. Your account number is %d, Your current balance is $%.2f.\n", account.getAccountNumber(),account.getAccountBalance());
                                break;
                            }
                        }
                        break;
                    }else{
                        System.out.println("Please enter one of the two account types.");
                    }
                }

                break;
            }

        }


    }

    private void createNewCustomer(){
        System.out.println("Enter your first name:");
        String firstName = scnr.nextLine();
        System.out.println("Enter your last name:");
        String lastName = scnr.nextLine();
        System.out.println("Create Your Personal Identification Number:");
        int pin = Integer.parseInt(scnr.nextLine());

        Customer customer = new Customer(firstName,lastName,pin);
        bank.addCustomer(customer);

        System.out.printf("Hello %s %s, your account had been created\n" +
                "Your PIN is : %d \n",firstName,lastName,pin);
        while (true) {
            System.out.println("Would you like this account to be a checking or savings account?");
            String accountType = scnr.nextLine();

            if (accountType.equalsIgnoreCase("checking")) {
                System.out.println("What would you like you initial deposit to be?");
                Double initialDeposit = Double.parseDouble(scnr.nextLine());
                Checking account = new Checking(initialDeposit);
                customer.add(account);
                System.out.printf("Account has been opened. Your account number is %d, Your current balance is $%.2f.\n", account.getAccountNumber(),account.getAccountBalance());
                break;
            } else if (accountType.equalsIgnoreCase("savings")){
                System.out.println("How much are you trying to save?");
                Double saveValue = Double.parseDouble(scnr.nextLine());
                System.out.println("What is your initial deposit into this account?");
                Double initialDeposit = Double.parseDouble(scnr.nextLine());
                Savings account = new Savings(initialDeposit, saveValue);
                customer.add(account);
                System.out.printf("Account has been opened. Your account number is %d, Your current balance is $%.2f.\n", account.getAccountNumber(),account.getAccountBalance());
                break;
            }else{
                System.out.println("Please enter one of the two account types.");
            }
        }


    }

    private void closeAllAccounts(){
        System.out.println("Please enter your PIN:");

        int pin = Integer.parseInt(scnr.nextLine());
        Customer customer = bank.getCustomer(pin);

        if (bank.getCustomer(pin) == null){
            System.out.println("PIN not found, try again:");
        }else {
            bank.removeCustomer(customer);
            System.out.println("All accounts successfully deleted.");
        }

    }

}
