import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Bank {
    Map<Integer, Customer> customers = new HashMap<>();

    public void addCustomer(Customer newCustomer){
        customers.put(newCustomer.getCustomerPIN(), newCustomer);
    }

    public void removeCustomer(Customer oldCustomer){
        customers.remove(oldCustomer.getCustomerPIN());
    }

    public Customer getCustomer(int PIN){
        return customers.get(PIN);
    }

    public StringBuilder getAllCustomers(){
        StringBuilder str = new StringBuilder();

        customers.forEach((allCustomer, customer) -> {
            str.append(customer);
        });

        return str;
    }

}
