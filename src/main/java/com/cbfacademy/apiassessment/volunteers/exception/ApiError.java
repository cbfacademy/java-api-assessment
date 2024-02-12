package com.cbfacademy.apiassessment.volunteers.exception;

import java.util.List;

import org.springframework.http.HttpStatus;

/**
 * Represents a standardized structure for sending error details in API responses.
 * This class encapsulates information about an error, including the HTTP status code,
 * a human-readable message.
 */
public class ApiError {

    // HTTP status code associated with the error
    private HttpStatus status;

    // General error message about the nature of the error
    private String message;

    // Detailed error messages, typically used for validation errors
    private List<String> errors;


    /**
     * Constructs an ApiError with specified HTTP status and a general error message.
     *
     * @param status  The HTTP status code associated with the error.
     * @param message The general error message.
     */
    public ApiError(HttpStatus status, String message) {
        super();
        this.status = status;
        this.message = message;
    }

    /**
     * Constructs an ApiError with specified HTTP status, a general error message,
     * and a list of detailed error messages.
     *
     * @param status  The HTTP status code associated with the error.
     * @param message The general error message.
     * @param errors  A list of detailed error messages, often used for validation errors.
     */
    public ApiError(HttpStatus status, String message, List<String> errors) {
        super();
        this.status = status;
        this.message = message;
        this.errors = errors;
    }

    // Getters and Setters

    /**
     * Returns the HTTP status code of the error.
     *
     * @return The HTTP status code associated with this error.
     */
    public HttpStatus getStatus() {
        return status;
    }

    /**
     * Sets the HTTP status code for this error.
     *
     * @param status The HTTP status code to set.
     */
    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    /**
     * Returns the general error message.
     *
     * @return The general error message associated with this error.
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the general error message for this error.
     *
     * @param message The general error message to set.
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Returns the list of detailed error messages.
     *
     * @return A list of detailed error messages, or null if not set.
     */
    public List<String> getErrors() {
        return errors;
    }

    /**
     * Sets the list of detailed error messages for this error.
     *
     * @param errors A list of detailed error messages.
     */
    public void setErrors(List<String> errors) {
        this.errors = errors;
    }




    
}
