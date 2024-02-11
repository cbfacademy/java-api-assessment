package com.cbfacademy.apiassessment.volunteers.volunteer;

import java.util.List;
import java.util.UUID;

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

    // Handles the creation of a new volunteer, encapsulating any pre-persistence logic
    @Override
    public Volunteer createVolunteer (Volunteer volunteer) {
        // Business logic added here to validate volunteer data before saving the volunteer
        validateVolunteer(volunteer); 
        // Business logic processed, save the volunteer
        return volunteerRepository.save(volunteer); // Saves the volunteer entity 
    }

    @Override
    public Volunteer updateVolunteer (UUID id, Volunteer volunteer) {
        validateVolunteer(volunteer); // Validate volunteer data
        // Ensure the volunteer exists before updating
        return volunteerRepository.findById(id)
                .map(existingVolunteer -> volunteerRepository.save(volunteer))
                .orElseThrow(() -> RuntimeException("Volunteer not found"));
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

    // Retrieves a list of all volunteers from the repository
    @Override
    public List<Volunteer> getAllVolunteers() {
        return volunteerRepository.findAll();
    }

    // Fetches a single volunteer by their UUID
    @Override
    public Volunteer getVolunteerById(UUID id) {
        // Throws an exception if the volunteer is not found
        return volunteerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Volunteer not found"));

    // Deletes a volunteer identified by their UUID
    @Override
    public void deleteVolunteer(UUID id) {
        Volunteer volunteer = getVolunteerById(id); // Ensures volunteer exists before deletion
        volunteerRepository.delete(volunteer);
    }
                

}
