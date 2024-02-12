package com.cbfacademy.apiassessment.volunteers.search;

import java.util.UUID;

public class TaskAssignmentRequest {
    private UUID taskId; 

    // Constructor 
    public TaskAssignmentRequest() {}

    // Getters and Setters
    public UUID getTaskId() {
        return taskId;
    }

    public void setTaskId(UUID taskId) {
        this.taskId = taskId;
    }
    
}
