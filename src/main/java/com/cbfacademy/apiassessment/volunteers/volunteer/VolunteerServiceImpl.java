package com.cbfacademy.apiassessment.volunteers.volunteer;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.cbfacademy.apiassessment.volunteers.exception.VolunteerNotFoundException;
import com.cbfacademy.apiassessment.volunteers.search.AdvancedSearchQuery;


// Marks this class a Spring-managed service component
@Service 
public class VolunteerServiceImpl implements VolunteerService {

    // Injects the repository dependency injection for data access operations
    private final VolunteerRepository volunteerRepository;

    // Constructor-based dependency injection for the repository 

    /**
     * Constructs a VolunteerServiceImpl with a specified VolunteerRepository.
     * 
     * @param volunteerRepository the repository used for volunteer data operations
     */
    
    public VolunteerServiceImpl(VolunteerRepository volunteerRepository) {
        this.volunteerRepository = volunteerRepository;
    }

    /**
     * Creates and saves a new volunteer to the repository after validation.
     * 
     * @param volunteer the volunteer to be created and saved
     * @return the saved volunteer with persisted data (e.g., generated ID)
     * @throws IllegalArgumentException if any mandatory field of the volunteer is empty
     */
    @Override
    public Volunteer createVolunteer (Volunteer volunteer) {
        validateVolunteer(volunteer); 
        return volunteerRepository.save(volunteer);
    }

    /**
     * Updates an existing volunteer identified by UUID with new volunteer data.
     * 
     * @param id the UUID of the volunteer to update
     * @param volunteer the new volunteer data to update
     * @return the updated volunteer
     * @throws VolunteerNotFoundException if no volunteer is found with the specified UUID
     * @throws IllegalArgumentException if any mandatory field of the volunteer is empty
     */
    @Override
    public Volunteer updateVolunteer (UUID id, Volunteer volunteer) {
        validateVolunteer(volunteer);
        return volunteerRepository.findById(id)
                .map(existingVolunteer -> volunteerRepository.save(volunteer))
                .orElseThrow(() -> new VolunteerNotFoundException(id));
    }

    /**
    * Validates the mandatory fields of a volunteer.

    * @param volunteer the volunteer to validate.
    * @throws IllegalArgumentException if any mandatory field is empty.
    */
    private void validateVolunteer(Volunteer volunteer) {
        if (volunteer.getFirstName() == null || volunteer.getFirstName().trim().isEmpty()) {
            throw new IllegalArgumentException("First name is required.");
        }
        if (volunteer.getLastName() == null || volunteer.getLastName().trim().isEmpty()) {
            throw new IllegalArgumentException("Last name is required.");
        }
        if (volunteer.getContactNumber() == null || volunteer.getContactNumber().trim().isEmpty()) {
            throw new IllegalArgumentException("Contact number is required.");
        }
        if (volunteer.getEmail() == null || volunteer.getEmail().trim().isEmpty()) {
            throw new IllegalArgumentException("Email is required.");
        }
    }


    /**
     * Retrieves all volunteers from the repository
     * 
     * @return a list of all volunteers
     */
    @Override
    public List<Volunteer> getAllVolunteers() {
        return volunteerRepository.findAll();
    }

    /**
     * Fetches a single volunteer by their UUID.
     * 
     * @param id the UUID of the volunteer to retrieve
     * @return the found volunteer
     * @throws VolunteerNotFoundException if no volunteer is found with the specified UUID
     */
    @Override
    public Volunteer getVolunteerById(UUID id) {
        return volunteerRepository.findById(id)
                .orElseThrow(() -> new VolunteerNotFoundException(id));
    }

    /**
     * Deletes a volunteer identified by their UUID.
     * 
     * @param id the UUID of the volunteer to delete
     * @throws VolunteerNotFoundException if no volunteer is found with the specified UUID
     */
    @Override
    public void deleteVolunteer(UUID id) {
        Volunteer volunteer = getVolunteerById(id); // Ensures volunteer exists before deletion
        volunteerRepository.delete(volunteer);
    }
    
    /**
     * Searches for volunteers based on an advanced query including active status and skills.
     * 
     * @param query the advanced search criteria
     * @return a list of volunteers matching the search criteria
     */
    @Override
    public List<Volunteer> searchVolunteers(AdvancedSearchQuery query) {
        List<Volunteer> allVolunteers = volunteerRepository.findAll();
        return allVolunteers.stream()
                .filter(volunteer -> volunteer.isActive() == query.isActive())
                .filter(volunteer -> matchesSkills(volunteer, query.getSkills()))
                .collect(Collectors.toList());

    }

    /**
     * Checks if a voulteer has any if the required skills.
     * 
     * @param volunteer the volunteer to check
     * @param requiredSkills the list of skills to match against the volunteer's skills
     * @return true if the volunteer has any of the required skills, otherwise false
    */
    private boolean matchesSkills(Volunteer volunteer, List<String> requiredSkills) {
        if (requiredSkills == null || requiredSkills.isEmpty()) {
            return true; 
        }
        return requiredSkills.stream().anyMatch(skill -> volunteer.getSkills().contains(skill));
    }

}
