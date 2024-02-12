package com.cbfacademy.apiassessment.volunteers.search;

import java.util.UUID;

/**
 * Represents a request to assign a volunteer to a specific task.
 * This class is used to encapsulate the data needed for task assignment operations,
 * including identifying the task to which a volunteer should be assigned.
 *
 * Usage example: POST /api/volunteers/{volunteerId}/assign with this request body
 * to assign a volunteer to a specified task.
 */
public class TaskAssignmentRequest {
    
    /**
     * The unique identifier of the task to which the volunteer is being assigned.
     * This UUID should correspond to an existing task in the system.
     */
    private UUID taskId; 


    // Default constructor for JSON deserialization 
    public TaskAssignmentRequest() {}


    // Getters and Setters

    /**
     * Retrieves the unique identifier of the task.
     * 
     * @return The UUID of the task to which the volunteer is being assigned.
     */
    public UUID getTaskId() {
        return taskId;
    }

    /**
     * Sets the unique identifier of the task for this assignment request.
     * 
     * @param taskId The UUID of the task to which the volunteer should be assigned.
     */
    public void setTaskId(UUID taskId) {
        this.taskId = taskId;
    }
    
}
