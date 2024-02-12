package com.cbfacademy.apiassessment.volunteers.volunteer;

import com.cbfacademy.apiassessment.volunteers.person.Person;
import java.util.UUID;
import java.time.LocalDate;


/**
 * Represents a Volunteer, extending the Person class with additional attributes
 * specific to the volunteer's role and activities within the organization.
 * Each volunteer is assigned a unique identifier and can have a specific role, skills,
 * activity status, and a record of their joining date.
 */
public class Volunteer extends Person {
    // Unique identifier for each volunteer, automatically generated to ensure uniqueness
    private final UUID id; 
    
    // The volunteers role or position within the organisation
    private String role; 

    // Descriptive list of skills or expertise the volunteer brings to the organization
    private String skills;
    
    // Indicates whether the volunteer is currently active within the organization
    private boolean isActive;

    // Records the date when the volunteer first joined the organization
    private LocalDate dateJoined;


    /**
     * Constructs a new Volunteer with specified personal and volunteer-specific details.
     * A unique UUID is generated for each new volunteer to ensure distinct identification..
     * 
     * @param firstName        The first name of the volunteer.
     * @param lastName         The last name of the volunteer.
     * @param dateOfBirth      The date of birth of the volunteer.
     * @param contactNumber    The contact number of the volunteer.
     * @param email            The email address of the volunteer.
     * @param role             The designated role or position of the volunteer within the organization.
     * @param skills           The skills or expertise the volunteer contributes to their role.
     * @param isActive         A flag indicating whether the volunteer is currently active.
     * @param dateJoined       The date on which the volunteer joined the organization, marking the start of their involvement.
     */
    public Volunteer(String firstName, String lastName, LocalDate dateOfBirth, String contactNumber, String email, String role, String skills, boolean isActive, LocalDate dateJoined) {
        super(firstName, lastName, dateOfBirth, contactNumber, email); // Initialize Person attributes
        this.id = UUID.randomUUID(); // Generate a unique identifier
        this.role = role;
        this.skills = skills;
        this.isActive = isActive;
        this.dateJoined = dateJoined;
    } 

    // Getters and Setters

     /**
     * Returns the unique identifier of the volunteer.
     * The UUID is generated at the time of object creation and remains constant throughout the lifecycle of the volunteer.
     *
     * @return UUID representing the unique identifier of the volunteer.
     */
    public UUID getId() {
        return id;
    }

    // Getter and Setter methods for volunteer-specific attributes

    /**
     * Returns the role or position of the volunteer within the organization.
     * 
     * @return the role or position of the volunteer within the organization.
     */
    public String getRole() {
        return role;
    }

    /**
     * Sets the role or position of the volunteer within the organization.
     * 
     * @param role A String representing the volunteer's role or position within the organization.
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * Returns the skills or expertise the volunteer contributes to their role.
     * 
     * @return the skills or expertise the volunteer contributes to their role.
     */
    public String getSkills() {
        return skills;
    }

    /**
     * Sets the skills or expertise the volunteer contributes to their role
     * 
     * @param skills A String representing the skills or expertise the volunteer contributes to their role.
     */
    public void setSkills(String skills) {
        this.skills = skills;
    }

    /**
     * Returns a flag indicating whether the volunteer is currently active.
     * 
     * @return A flag indicating whether the volunteer is currently active.
     */
    public boolean isActive() {
        return isActive;
    }

    /**
     * Sets a flag indicating whether the volunteer is currently active.
     * 
     * @param isActive A boolean representing whether the volunteer is currently active
     */
    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }


    /**
     * Returns the date on which the volunteer joined the organization.
     * 
     * @return the date on which the volunteer joined the organization.
     */
    public LocalDate getDateJoined() {
        return dateJoined;
    }

    /**
     * Sets the date on which the volunteer joined the organization.
     * 
     * @param dateJoined A Date object representing the date on which the volunteer joined the organization.
     */
    public void setDateJoined(LocalDate dateJoined) {
        this.dateJoined = dateJoined;
    }

}
