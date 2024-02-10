package com.cbfacademy.apiassessment.volunteers.volunteer;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


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
}