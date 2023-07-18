package service;

/*
This class contains stateful services, i.e. each request depends on the previous requests,
as we need to keep track of user-specific data. Data will be stored in Collections.

To ensure the services are stateful, we'll be using Singleton objects, i.e. there is only going to be
one instance of this class created and that this instance is accessible by all parts of the application
 */

import model.Customer;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CustomerService {
    //CREATE A SINGLETON OBJECT
    /*Create a private constructor to prevent
    other classes from creating instances of this Singleton class
    */
    private CustomerService(){
        this.customers = new HashMap<>();
    }
    /*Create a private static instance variable which
    will hold the single instance of this Singleton class
    */
    private static CustomerService instance;
    /*
    Create a public static method to access the instance variable.
    This method will create the Singleton object if it doesn't exist and return the instance variable
    */
    public static CustomerService getInstance(){
        if (instance == null){
            instance = new CustomerService();
        } return instance;

    }

    //CREATE COLLECTION TYPE 'HASH MAP' TO STORE DATA IN KEY-VALUE FORMAT
    private Map<String, Customer> customers = new HashMap<>();


    //METHODS

    /*Method to add a new customer using email, first name, last name parameters.
    Check if any of the customers in the map collection have the same e-mail as the parameter,
    and if so, throw exception. Otherwise, add the newCustomer object to the Map.
    */
    public void addCustomer (String email, String firstName, String lastName){
        Customer newCustomer = new Customer (firstName, lastName, email);
        if (customers.containsKey(email)){
            throw new IllegalArgumentException("Customer with this email has already been registered");
        }else{
            customers.put(email,newCustomer);
        }
    }
    /*Method to get a customer off the Map using email parameter.
    If any of the customers in the map collection has the same email, return e-mail
    Otherwise return null
    */
    public Customer getCustomer (String customerEmail){
        if (customers.containsKey(customerEmail)) {
            return customers.get(customerEmail);
        } else{
            return null;
        }
    }

    /* Method to get all customers in the Map collection and return all values
     */
    public Collection<Customer> getAllCustomers(){
        return customers.values();
    }

}
