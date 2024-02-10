package com.cbfacademy.apiassessment.volunteers.person;

import java.sql.Date;

/**
 * Creation of the Base Class Person to encapsulate common attributes 
 * that can be shared in the future with other entities in the system.
 * 
 * Includes common attributes of a person.
 */

public class Person {
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String contactNumber;
    private String email;

/**
 * Constructor for creating a new Person object.
 * @param firstName     The first name of the person.
 * @param lastName      The last name of the person.
 * @param dateOfBirth   The date of birth of the person.
 * @param contactNumber The contact number of the person.
 * @param email         The email address of the person.
 */

public Person(String firstName, String lastName, Date dateOfBirth, String contactNumber, String email) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.dateOfBirth = dateOfBirth;
    this.contactNumber = contactNumber;
    this.email = email;
}
    
// Getter and Setter methods for person attributes 

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
