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
    private final String filePath = "java-api-assessment/src/main/resources/volunteers.json";
    private Gson gson = new Gson();
    private List<Volunteer> volunteers = new ArrayList<>();
    private static final Logger logger = LoggerFactory.getLogger(JsonVolunteerRepository.class);


    public JsonVolunteerRepository() {
        loadVolunteers();
    }

private void loadVolunteers() {
    File file = new File(filePath);
    // Check if the file exists and is not empty
    if (file.exists() && file.length() != 0) {
        try (FileReader reader = new FileReader(filePath)) {
            Type listOfVolunteersType = new TypeToken<ArrayList<Volunteer>>() {}.getType();
            volunteers = gson.fromJson(reader, listOfVolunteersType);
            if (volunteers == null) volunteers = new ArrayList<>();
                
        } catch (IOException e) {
            logger.error("Failed to load volunteers from file: {}", filePath, e); 
            volunteers = new ArrayList<>();
        }    
    } else {
        volunteers = new ArrayList<>();
        }   
    }

    // Save the current state of the volunteers list to the JSON file
    private void saveVolunteers() {
        try (FileWriter writer = new FileWriter(filePath)){
            gson.toJson(volunteers, writer);  
        } catch (IOException e) {
            logger.error("Failed to save volunteers to file: {}", filePath, e);
        }
    }

    @PostConstruct
    private void initVolunteersData() {
        // Check if volunteers list is empty, indicating no data was loaded from JSON
        if (volunteers.isEmpty()) {
            // Populate the list with intial data
            volunteers.add(new Volunteer("Elizabeth", "John", LocalDate.of(1980,01,15), "07584986718", "lizzi.john@yahoo.com", "Administrator", "Organisation", true, LocalDate.of(2023,8,15)));
            volunteers.add(new Volunteer("Matthew", "Lazarus", LocalDate.of(1962,12,07), "07553698744", "matthewlazarus12@gmail.com", "Accountant", "Accounting", false, LocalDate.of(2012,04,25)));
            volunteers.add(new Volunteer("Rachael", "Mark", LocalDate.of(2001,11,14), "07956412843", "markrachael2001@live.co.uk", "Greeter", "Hospitality", true, LocalDate.of(2024,01,18)));
            volunteers.add(new Volunteer("Joshua", "Nun", LocalDate.of(1990,01,01), "07383555777", "j.nun@gmail.com", "Choir Member", "Singing", true, LocalDate.of(2020,01,01)));
            volunteers.add(new Volunteer("Sarah", "Bethel", LocalDate.of(1985,05,15), "07958444888", "bethelsarah@me.com", "Accountant", "Accounting", true, LocalDate.of(2019,05,20)));
            volunteers.add(new Volunteer("David", "Judah", LocalDate.of(1988,8,8), "07777777333", "judahdavid@gmail.com", "Bookkeeper", "Event Management", true, LocalDate.of(2004,12,18)));
            volunteers.add(new Volunteer("Micah", "Grace", LocalDate.of(1995,8,28), "07773335551", "micah.g@icloud.com", "Manager", "Public Speaking", true, LocalDate.of(2019,03,12)));
            volunteers.add(new Volunteer("John", "Mark", LocalDate.of(2004,07,07), "07958775533", "johnmarkh@icloud.com", "Greeter", "Teacher", false, LocalDate.of(2023,12,04)));
            volunteers.add(new Volunteer("Ruth", "Boaz", LocalDate.of(1957,02,03), "07778244236", "ruthboaz@yahoo.com", "Receptionist", "Record Keeping", true, LocalDate.of(2004,8,18)));
            // Save the newly added volunteers to the JSON file
            saveVolunteers();
        }
    }


    @Override
    public Volunteer save(Volunteer volunteer) {
        // If the volunteer is new, add it to the list, otherwise update it
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

    @Override
    public Optional<Volunteer> findById(UUID id) {
            return volunteers.stream()
                             .filter(volunteer -> volunteer.getId().equals(id))
                             .findFirst();
    }

    @Override
    public List<Volunteer> findAll() {
        return volunteers;
    }

    @Override
        public void delete(Volunteer volunteer) {
        volunteers.remove(volunteer);
        saveVolunteers();
    }

    @Override
    public List<Volunteer> findBySkill(String skill) {
        return volunteers.stream()
                         .filter(volunteer -> volunteer.getSkills() != null && volunteer.getSkills().toLowerCase().contains(skill.toLowerCase()))
                         .collect(Collectors.toList());
    }

    @Override
    public List<Volunteer> findByIsActive(boolean isActive) {
        return volunteers.stream()
                         .filter(volunteer -> volunteer.isActive() == isActive)
                         .collect(Collectors.toList());
    }

}