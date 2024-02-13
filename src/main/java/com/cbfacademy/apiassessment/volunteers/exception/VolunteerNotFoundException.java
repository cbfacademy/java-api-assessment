package com.cbfacademy.apiassessment.volunteers.exception;

import java.util.UUID;

/**
 * Exception thrown when a requested volunteer is not found in the system.
 */
public class VolunteerNotFoundException extends RuntimeException {

    /**
     * Constructs a new VolunteerNotFoundException with the specified detail message.
     * 
     * @param message the detail message.
     */
    public VolunteerNotFoundException(String message) {
        super(message);
    }
    
    /**
     * Constructs a VolunteerNotFoundException with a standard message that includes the provided UUID.
     * 
     * @param id the UUID of the volunteer that could not be found.
     */
    public VolunteerNotFoundException(UUID id){
        super("Volunteer with ID " + id + " not found.");
    }
}
