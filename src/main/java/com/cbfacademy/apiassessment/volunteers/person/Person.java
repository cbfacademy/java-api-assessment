package com.cbfacademy.apiassessment.volunteers.person;

import java.sql.Date;

/**
 * Represents a person with basic personal information. This class serves as a base
 * to encapsulate common attributes that can be shared with other entities in the system.
 * Attributes include first name, last name, date of birth, contact number, and email address.
 */
public class Person {
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String contactNumber;
    private String email;

/**
 * Constructs a new Person object with the specified details.
 * 
 * @param firstName     The first name of the person, not null.
 * @param lastName      The last name of the person, not null.
 * @param dateOfBirth   The date of birth of the person , not null.
 * @param contactNumber The contact number of the person..
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

     /**
     * Returns the first name of this person.
     * 
     * @return the first name of this person.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name of this person.
     * 
     * @param firstName A String representing the person's first name, not null.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Returns the last name of this person.
     * 
     * @return the last name of this person.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name of this person.
     * 
     * @param lastName A String representing the person's last name, not null.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Returns the date of birth of this person.
     * 
     * @return the date of birth of this person.
     */
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Sets the date of birth of this person.
     * 
     * @param dateOfBirth A Date object representing the person's date of birth, not null.
     */
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Returns the contact number of this person.
     * 
     * @return the contact number of this person.
     */
    public String getContactNumber() {
        return contactNumber;
    }

    /**
     * Sets the contact number of this person.
     * 
     * @param contactNumber A String representing the person's contact number, may include digits and hyphens.
     */
    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    /**
     * Returns the email address of this person.
     * 
     * @return the email address of this person.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email address of this person.
     * 
     * @param email A String representing the person's email address, should be in a valid email format.
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
}
