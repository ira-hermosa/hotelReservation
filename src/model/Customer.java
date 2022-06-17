package model;

import java.util.regex.Pattern;

public class Customer {

    String firstName;
    String lastName;
    String email;

    private final String emailRegex = "^(.+)@(.+).com$";
    private final Pattern pattern = Pattern.compile(emailRegex);

    public Customer (String firstName, String lastName, String email){
        if (!pattern.matcher (email).matches()){
            throw new IllegalArgumentException("Error, Invalid email");
        }

        this.firstName = firstName;
        this.lastName = lastName;
        this.email= email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getEmailRegex() {
        return emailRegex;
    }

    public Pattern getPattern() {
        return pattern;
    }

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
