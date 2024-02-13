package com.cbfacademy.apiassessment.volunteers.volunteer;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface VolunteerRepository {
    
    /**
     * Saves a given volunteer entity. If the entity is new, it will be created in the data store;
     * otherwise, the existing entity is updated.
     * 
     * @param volunteer the volunteer entity to save or update
     * @return the saved or updated volunteer entity
     */
    Volunteer save(Volunteer volunteer);

    /**
     * Finds a volunteer by their unique identifier.
     * 
     * @param id the unique identifier of the volunteer to find
     * @return an {@link Optional} containing the found volunteer if present, otherwise an empty {@link Optional}
     */
    Optional<Volunteer> findById(UUID id); // Find a volunteer by ID

    /**
     * Retrieves all volunteers from the data store.
     * 
     * @return a list of all volunteers, which may be empty if no volunteers exist
     */
    List<Volunteer> findAll(); // Get all volunteers

    /**
     * Deletes a given volunteer from the data store. If the volunteer does not exist, the operation may not perform any action.
     * 
     * @param volunteer the volunteer entity to delete
     */
    void delete(Volunteer volunteer); // Delete a volunteer

    /**
     * Finds volunteers by their skills. This method retrieves all volunteers that have a specific skill.
     *
     * @param skill the skill to search for in volunteers
     * @return a list of volunteers who possess the specified skill, which may be empty if no such volunteers exist
     */
    List<Volunteer> findBySkill(String skill);

    /**
     * Finds volunteers by their activity status. This method retrieves all volunteers that are either active or inactive.
     *
     * @param isActive the activity status to search for in volunteers (true for active, false for inactive)
     * @return a list of volunteers matching the specified activity status, which may be empty if no such volunteers exist
     */
     List<Volunteer> findByIsActive(boolean isActive);

}
