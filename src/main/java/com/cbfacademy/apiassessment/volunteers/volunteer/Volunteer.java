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

}
