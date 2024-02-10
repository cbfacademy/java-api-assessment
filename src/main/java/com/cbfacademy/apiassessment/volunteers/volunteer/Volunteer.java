package com.cbfacademy.apiassessment.volunteers.volunteer;

import com.cbfacademy.apiassessment.volunteers.person.Person;
import java.util.UUID;
import java.util.Date;


// Volunteer specific attributes
public class Volunteer extends Person {
    private final UUID id; // Unique identifier for each volunteer
    private String role; // Role/position of the volunteer
    private String skills; // Skills or talents the volunteer possesses
    private boolean active; // Indicates whther the volunteer is currently active
    private Date dateJoined; // Date when the volunteer joined the church

    
/**
 * Constructor for creating a new Volunteer object.
 * 
 * @param firstName        The first name of the volunteer.
 * @param lastName         The last name of the volunteer.
 * @param dateOfBirth      The date of birth of the volunteer.
 * @param contactNumber    The contact number of the volunteer.
 * @param email            The email address of the volunteer.
 * @param role             The role/position of the volunteer.
 * @param skills           The skills or talents the volunteer possesses.
 * @param active           Indicates whether the volunteer is currently active.
 * @param dateJoined       The date the volunteer joined the church
 */
    public Volunteer(String firstName, String lastName, Date dateOfBirth, String contactNumber, String email, String role, String skills, boolean active, Date dateJoined) {
        super(firstName, lastName, dateOfBirth, contactNumber, email); // Call to super (Person) constructor
        this.id = UUID.randomUUID(); // Generate a unique identifier for the volunteer
        this.role = role;
        this.skills = skills;
        this.active = active;
        this.dateJoined = dateJoined;
    } 
}
