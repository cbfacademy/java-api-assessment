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
}
