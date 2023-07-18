package model;
import java.util.regex.Pattern;

/*
This class holds information about a customer: firstName, lastName and email
 */

public class Customer {
    private String firstName;
    private String lastName;
    private String email;

    private final String emailRegex = "^(.+)@(.+).com$";
    private final Pattern pattern = Pattern.compile(emailRegex);

    /*Use regex to validate the email string.
    If the email doesn't match the 'name@domain.com' format,throw an IllegalArgumentException
    */
    public Customer(String firstName, String lastName, String email) {
        if (!pattern.matcher(email).matches()){
            throw new IllegalArgumentException("Error, invalid email");
        }
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    /*
    Getters and setters
    */
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    /*
    Override the toString()method for a better description of customer's data
    */

    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", emailRegex='" + emailRegex + '\'' +
                ", pattern=" + pattern +
                '}';
    }

}
