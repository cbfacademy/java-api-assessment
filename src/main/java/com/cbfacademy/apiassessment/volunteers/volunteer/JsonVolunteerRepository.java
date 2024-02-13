package com.cbfacademy.apiassessment.volunteers.volunteer;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import jakarta.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.time.LocalDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Repository
public class JsonVolunteerRepository implements VolunteerRepository {
    // Path to the JSON file where volunteer data is stored.
    private final String filePath = "java-api-assessment/src/main/resources/volunteers.json";

    // Gson instance for serializing and deserializing JSON data.
    private Gson gson = new Gson();

    // List to hold Volunteer objects loaded from the JSON file.
    private List<Volunteer> volunteers = new ArrayList<>();

    // Logger instance for logging errors and information.
    private static final Logger logger = LoggerFactory.getLogger(JsonVolunteerRepository.class);


    // Constructor that initializes the repository by loading volunteers from the JSON file.
    public JsonVolunteerRepository() {
        loadVolunteers();
    }

    // Loads volunteers from the JSON file into the 'volunteers' list.
    private void loadVolunteers() {
        File file = new File(filePath);
        // Check if the file exists and is not empty
        if (file.exists() && file.length() != 0) {
            try (FileReader reader = new FileReader(filePath)) {
                Type listOfVolunteersType = new TypeToken<ArrayList<Volunteer>>() {}.getType();
                volunteers = gson.fromJson(reader, listOfVolunteersType);
                // Handle the case where the JSON file is empty or contains invalid data.
                if (volunteers == null) volunteers = new ArrayList<>();       
            } catch (IOException e) {
                logger.error("Failed to load volunteers from file: {}", filePath, e); 
                volunteers = new ArrayList<>();
            }    
        } else {
            // Initialize an empty list if the file doesn't exist or is empty.
            volunteers = new ArrayList<>();
            }   
        }

    // Saves the current state of 'volunteers' list back to the JSON file.
    private void saveVolunteers() {
        try (FileWriter writer = new FileWriter(filePath)){
            gson.toJson(volunteers, writer);  
        } catch (IOException e) {
            logger.error("Failed to save volunteers to file: {}", filePath, e);
        }
    }

    // Initializes volunteer data with a predefined set if the JSON file is empty.
    @PostConstruct
    private void initVolunteersData() {
        if (volunteers.isEmpty()) {
            // Predefined volunteers added to the list for initial setup.
            // Example volunteer data is hardcoded here for demonstration.
            volunteers.add(new Volunteer("Elizabeth", "John", LocalDate.of(1980,01,15), "07584986718", "lizzi.john@yahoo.com", "Administrator", "Organisation", true, LocalDate.of(2023,8,15)));
            volunteers.add(new Volunteer("Matthew", "Lazarus", LocalDate.of(1962,12,07), "07553698744", "matthewlazarus12@gmail.com", "Accountant", "Accounting", false, LocalDate.of(2012,04,25)));
            volunteers.add(new Volunteer("Rachael", "Mark", LocalDate.of(2001,11,14), "07956412843", "markrachael2001@live.co.uk", "Greeter", "Hospitality", true, LocalDate.of(2024,01,18)));
            volunteers.add(new Volunteer("Joshua", "Nun", LocalDate.of(1990,01,01), "07383555777", "j.nun@gmail.com", "Choir Member", "Singing", true, LocalDate.of(2020,01,01)));
            volunteers.add(new Volunteer("Sarah", "Bethel", LocalDate.of(1985,05,15), "07958444888", "bethelsarah@me.com", "Accountant", "Accounting", true, LocalDate.of(2019,05,20)));
            volunteers.add(new Volunteer("David", "Judah", LocalDate.of(1988,8,8), "07777777333", "judahdavid@gmail.com", "Bookkeeper", "Event Management", true, LocalDate.of(2004,12,18)));
            volunteers.add(new Volunteer("Micah", "Grace", LocalDate.of(1995,8,28), "07773335551", "micah.g@icloud.com", "Manager", "Public Speaking", true, LocalDate.of(2019,03,12)));
            volunteers.add(new Volunteer("John", "Mark", LocalDate.of(2004,07,07), "07958775533", "johnmarkh@icloud.com", "Greeter", "Teacher", false, LocalDate.of(2023,12,04)));
            volunteers.add(new Volunteer("Ruth", "Boaz", LocalDate.of(1957,02,03), "07778244236", "ruthboaz@yahoo.com", "Receptionist", "Record Keeping", true, LocalDate.of(2004,8,18)));
            populateInitialVolunteers();
            saveVolunteers();
        }
    }
    // Helper method to populate the list with initial volunteer data.
    private void populateInitialVolunteers() {
        // Hardcoded volunteer data for initial setup.
        volunteers.add(new Volunteer("Elizabeth", "John", LocalDate.of(1980, 1, 15), "07584986718", "lizzi.john@yahoo.com", "Administrator", "Organisation", true, LocalDate.of(2023, 8, 15)));
        // Additional volunteers omitted for brevity...
    }

    // Saves a new volunteer to the list or updates an existing one, then saves the list to the JSON file.
    @Override
    public Volunteer save(Volunteer volunteer) {
        Optional<Volunteer> existingVolunteer = findById(volunteer.getId());
        if (existingVolunteer.isPresent()) {
            int index = volunteers.indexOf(existingVolunteer.get());
            volunteers.set(index, volunteer);
        } else {
            volunteers.add(volunteer);
        }
        saveVolunteers();
        return volunteer;
    }

    // Finds a volunteer by their UUID.
    @Override
    public Optional<Volunteer> findById(UUID id) {
            return volunteers.stream()
                             .filter(volunteer -> volunteer.getId().equals(id))
                             .findFirst();
    }

    // Returns a list of all volunteers.
    @Override
    public List<Volunteer> findAll() {
        return volunteers;
    }

    // Removes a volunteer from the list and updates the JSON file.
    @Override
        public void delete(Volunteer volunteer) {
        volunteers.remove(volunteer);
        saveVolunteers();
    }

    // Finds volunteers by a specific skill.
    @Override
    public List<Volunteer> findBySkill(String skill) {
        return volunteers.stream()
                         .filter(volunteer -> volunteer.getSkills() != null && volunteer.getSkills().toLowerCase().contains(skill.toLowerCase()))
                         .collect(Collectors.toList());
    }

     // Finds volunteers based on their activity status.
    @Override
    public List<Volunteer> findByIsActive(boolean isActive) {
        return volunteers.stream()
                         .filter(volunteer -> volunteer.isActive() == isActive)
                         .collect(Collectors.toList());
    }

}