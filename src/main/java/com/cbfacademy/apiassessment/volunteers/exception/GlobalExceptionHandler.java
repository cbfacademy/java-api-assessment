package com.cbfacademy.apiassessment.volunteers.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Global exception handler for the application, providing centralized exception handling 
 * across all @RequestMapping methods through @ExceptionHandler methods.
 * 
 * This class captures exceptions thrown by any controller and returns a suitable 
 * ResponseEntity object to the client, encapsulating the error in a standardized format.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Handles exceptions when a volunteer is not found within the system.
     * 
     * This method catches the VolunteerNotFoundException and transforms it into
     * a ResponseEntity object containing an ApiError with the NOT_FOUND status
     * and a detailed error message extracted from the exception.
     * 
     * @param ex The caught VolunteerNotFoundException.
     * @return A ResponseEntity containing the ApiError and the HTTP status.
     */
    @ExceptionHandler(VolunteerNotFoundException.class)
    public ResponseEntity <Object> handleVolunteerNotFoundException(VolunteerNotFoundException ex) {
        // Create ApiError object with error details
        ApiError apiError = new ApiError(HttpStatus.NOT_FOUND, ex.getMessage());
        
        return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
    }

    
}
