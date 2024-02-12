package com.cbfacademy.apiassessment.volunteers.volunteer;

import com.cbfacademy.apiassessment.volunteers.person.Person;
import java.util.UUID;
import java.sql.Date;


// Volunteer specific attributes
public class Volunteer extends Person {
    private final UUID id; // Unique identifier for each volunteer
    private String role; // Role/position of the volunteer
    private String skills; // Skills or talents the volunteer possesses
    private boolean isActive; // Indicates whther the volunteer is currently active
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
 * @param isActive         Indicates whether the volunteer is currently active.
 * @param dateJoined       The date the volunteer joined the church
 */
    
    public Volunteer(String firstName, String lastName, Date dateOfBirth, String contactNumber, String email, String role, String skills, boolean isActive, Date dateJoined) {
        super(firstName, lastName, dateOfBirth, contactNumber, email); // Call to super (Person) constructor
        this.id = UUID.randomUUID(); // Generate a unique identifier for the volunteer
        this.role = role;
        this.skills = skills;
        this.isActive = isActive;
        this.dateJoined = dateJoined;
    } 

     /**
     * Getter for the unique identifier of the volunteer.
     *
     * @return The UUID of the volunteer.
     */
    public UUID getId() {
        return id;
    }

    // Getter and Setter methods for volunteer-specific attributes

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public Date getDateJoined() {
        return dateJoined;
    }

    public void setDateJoined(Date dateJoined) {
        this.dateJoined = dateJoined;
    }

}
