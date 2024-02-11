package com.cbfacademy.apiassessment.volunteers.exception;

import java.util.UUID;

public class VolunteerNotFoundException extends RuntimeException {

    public VolunteerNotFoundException(String message) {
        super(message);
    }
    
    // A constructor that takes an ID and formats a standard message
    public VolunteerNotFoundException(UUID id){
        super("Volunteer with ID " + id + " not found.");
    }
}
