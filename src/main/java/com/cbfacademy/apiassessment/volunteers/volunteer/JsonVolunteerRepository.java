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
import java.sql.Date;


@Repository
public class JsonVolunteerRepository implements VolunteerRepository {
    private final String filePath = "java-api-assessment/src/main/resources/volunteers.json";
    private Gson gson = new Gson();
    private List<Volunteer> volunteers = new ArrayList<>();


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
            // In case the file is empty or the content is not valid
            if (volunteers == null) {
                volunteers = new ArrayList<>();
            }
        } catch (IOException e) {
            e.printStackTrace();
            // In case of an IOException, initialize an empty list
            volunteers = new ArrayList<>();
        }    
    } else {
        //If the file doesn't exist or is empty, start with an empty list
        volunteers = new ArrayList<>();
        }   
    }

    // Save the current state of the volunteers list to the JSON file
    private void saveVolunteers() {
        try (FileWriter writer = new FileWriter(filePath)){
            gson.toJson(volunteers, writer);  
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @PostConstruct
    private void initVolunteersData() {
        // Check if volunteers list is empty, indicating no data was loaded from JSON
        if (volunteers.isEmpty()) {
            // Populate the list with intial data
            volunteers.add(new Volunteer("Elizabeth", "John", Date.valueOf("1980-01-15"), "07584986718", "lizzi.john@yahoo.com", "Administrator", "Organisation", true, Date.valueOf("2023-08-15")));
            volunteers.add(new Volunteer("Matthew", "Lazarus", Date.valueOf("1962-12-07"), "07553698744", "matthewlazarus12@gmail.com", "Accountant", "Accounting", false, Date.valueOf("2012-04-25")));
            volunteers.add(new Volunteer("Rachael", "Mark", Date.valueOf("2001-11-14"), "07956412843", "markrachael2001@live.co.uk", "Greeter", "Hospitality", true, Date.valueOf("2024-01-18")));
            volunteers.add(new Volunteer("Joshua", "Nun", Date.valueOf("1990-01-01"), "07383555777", "j.nun@gmail.com", "Choir Member", "Singing", true, Date.valueOf("2020-01-01")));
            volunteers.add(new Volunteer("Sarah", "Bethel", Date.valueOf("1985-05-15"), "07958444888", "bethelsarah@me.com", "Accountant", "Accounting", true, Date.valueOf("2019-05-20")));
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

}