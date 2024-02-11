package com.cbfacademy.apiassessment.volunteers.volunteer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


// Marks this class a Spring-managed service component
@Service 
public class VolunteerServiceImpl implements VolunteerService {

    // Injects the repository dependency injection for data access operations
    private final VolunteerRepository volunteerRepository;

    // Constructor-based dependency injection for the repository 
    @Autowired
    public VolunteerServiceImpl(VolunteerRepository volunteerRepository) {
        this.volunteerRepository = volunteerRepository;
    }

    
}
