package service;

import model.Customer;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CustomerService {

    //private field that refers to the object
    private static CustomerService customerObject = new CustomerService();

    //Constructor for the Singleton Class
    private CustomerService(){};

    //Method that allows us to create only one object
    //and access the object as needed

    public static CustomerService getCustomer(){
        return customerObject;
    }

    //Collections to store, retrieve and process data
    private final Map<String, Customer> customers = new HashMap<>();

    public void addCustomer(final String email, final String firstName, final String lastName){
        customers.put(email, new Customer(firstName, lastName, email));
    }

    public Customer getCustomer(final String customerEmail){
        return customers.get(customerEmail);
    }

    public Collection<Customer> getAllCustomers(){
        return customers.values();
    }

}
