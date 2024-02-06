package com.cbfacademy.apiassessment.familyActivities;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;

@Repository
public class JsonFamilyActivityRepository implements FamilyActivityRepository{

    // File path for JSON data
    private final String filePath;

    // ObjectMapper for JSON serialization/deserialization
    private final ObjectMapper objectMapper;

    // In-memory database to store family activities
    private final Map<UUID, FamilyActivity> database;

    /**
     * Constructs a JsonFamilyActivityRepository with the specified file path.
     * @param filePath the path to the JSON file containing family activity data
     */
    public JsonFamilyActivityRepository(@Value("${json.file.path}") String filePath) {
        this.filePath = filePath;
        this.objectMapper = new ObjectMapper();
        this.database = loadDataFromJson();
    }

    /**
     * Loads family activity data from JSON file into memory.
     * @return a map of family activities loaded from JSON file
     */
    public Map<UUID, FamilyActivity> loadDataFromJson() {
        try {
            File file = new File(filePath);
            if (file.exists()) {
                FamilyActivity[] activities = objectMapper.readValue(file, FamilyActivity[].class);
                // Create a HashMap to store the loaded data
                Map<UUID, FamilyActivity> activityMap = new HashMap<>();
                // Populate the HashMap with data from the array
                for (FamilyActivity activity : activities) {
                    activityMap.put(activity.getId(), activity);
                }
                return activityMap;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Return an empty HashMap if there's an error or the file doesn't exist
        return new HashMap<>();
    }

    /**
     * Saves the in-memory database to JSON file.
     */
    private void saveDataToJson() {
        try {
            objectMapper.writeValue(new File(filePath), database);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<FamilyActivity> retrieveAll() {
        return List.copyOf(database.values());
    }

    @Override
    public FamilyActivity retrieve(UUID id) throws ActivityNotFoundException {
        if (!database.containsKey(id)) {
            throw new ActivityNotFoundException("Activity with ID " + id + " not found");
        }
        return database.get(id);
    }

    @Override
    public FamilyActivity create(FamilyActivity activity) {
        validateActivityDetails(activity);
        database.put(activity.getId(), activity);
        saveDataToJson();
        return activity;
    }

    @Override
    public void delete(UUID id) throws ActivityNotFoundException { 
        if (!database.containsKey(id)) {
            throw new ActivityNotFoundException("This activity does not exist!");
        }
        database.remove(id);
        saveDataToJson();
    }

    @Override
    public FamilyActivity update(UUID id, FamilyActivity activity) throws ActivityNotFoundException {
        if (database.containsKey(id)) {
            validateActivityDetails(activity);
            database.put(id, activity);
            saveDataToJson();
            return activity;
        } else {
            throw new ActivityNotFoundException("The activity you are trying to update does not exist!");
        }
    }

    @Override
    public List<FamilyActivity> retrieveAllByActivityType(ActivityType type) {
        return database.values().stream()
        .filter(activity -> activity.getActivityType() == type)
        .collect(Collectors.toList());
    }

    //This method checks if there are any negative values for details and if it does it throws the InvalidActivityDetails exception.
    private void validateActivityDetails(FamilyActivity activity) throws InvalidActivityDetailsException, IncompleteActivityDetailsException {
        if (activity.getNumberOfAdults() < 0 || activity.getNumberOfChildren() < 0 ||
            activity.getActivityCostPerAdult().compareTo(BigDecimal.ZERO) < 0 ||
            activity.getActivityCostPerChild().compareTo(BigDecimal.ZERO) < 0 ||
            activity.getFoodCostPerAdult().compareTo(BigDecimal.ZERO) < 0 ||
            activity.getFoodCostPerChild().compareTo(BigDecimal.ZERO) < 0) {
            throw new InvalidActivityDetailsException("Invalid activity details. Negative values not allowed.");
        } 

        if (activity.getActivityName() == null || activity.getActivityDescription() == null ||
            activity.getActivityType() == null) {
            throw new IncompleteActivityDetailsException("Incomplete activity details: activity name, description, and type are required");
        }
    }
    
}
