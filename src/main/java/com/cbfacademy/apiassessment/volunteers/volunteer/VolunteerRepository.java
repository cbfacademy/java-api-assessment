package com.cbfacademy.apiassessment.volunteers.volunteer;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface VolunteerRepository {
    Volunteer save(Volunteer volunteer); // Create or update a volunteer

    Optional<Volunteer> findById(UUID id); // Find a volunteer by ID

    List<Volunteer> findAll(); // Get all volunteers

    void delete(Volunteer volunteer); // Delete a volunteer

}
