package com.cbfacademy.apiassessment.volunteers.volunteer;

import java.util.UUID;

import com.cbfacademy.apiassessment.volunteers.search.AdvancedSearchQuery;

import java.util.List;


public interface VolunteerService {

    /**
     * Creates a new volunteer in the system.
     * This method is responsible for persisting the volunteer's information.
     *
     * @param volunteer The volunteer object containing all necessary information for creation.
     * @return The created volunteer with any additional data that might have been set during persistence, such as an ID.
     */
    Volunteer createVolunteer(Volunteer volunteer);

    /**
     * Updates an existing volunteer's information.
     * The method locates the volunteer by their unique ID and updates their details.
     *
     * @param id The unique identifier of the volunteer to be updated.
     * @param volunteer The volunteer object containing updated information.
     * @return The updated volunteer object reflecting the changes made.
     */
    Volunteer updateVolunteer(UUID id, Volunteer volunteer);

    /**
     * Retrieves a list of all volunteers in the system.
     * This method is typically used for administrative purposes or to display a list of volunteers.
     *
     * @return A list of all volunteers.
     */
    List<Volunteer> getAllVolunteers();

    /**
     * Retrieves a volunteer by their unique identifier.
     * This method is essential for operations needing to access or modify a specific volunteer's details.
     *
     * @param id The unique identifier of the volunteer to retrieve.
     * @return The volunteer associated with the given ID, or null if no such volunteer exists.
     */
    Volunteer getVolunteerById(UUID id);

    /**
     * Deletes a volunteer from the system.
     * The volunteer to be deleted is identified by their unique ID.
     *
     * @param id The unique identifier of the volunteer to be deleted.
     */
    void deleteVolunteer(UUID id);

    /**
     * Searches for volunteers based on a set of criteria encapsulated in an AdvancedSearchQuery object.
     * This method allows for complex queries, such as filtering by skills, availability, or other attributes.
     *
     * @param query The AdvancedSearchQuery object containing the search criteria.
     * @return A list of volunteers that match the search criteria.
     */
    List<Volunteer> searchVolunteers(AdvancedSearchQuery query);

    /**
     * Assigns a specific task to a volunteer.
     *
     * @param volunteerId The UUID of the volunteer to whom the task is being assigned.
     * @param taskId The UUID of the task that is being assigned to the volunteer.
     * @return The updated volunteer with the task assignment.
     */
    Volunteer assignToTask(UUID volunteerId, UUID taskId);
    
}


