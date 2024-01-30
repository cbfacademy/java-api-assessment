package com.cbfacademy.apiassessment;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;

import com.cbfacademy.apiassessment.familyActivities.FamilyActivity;
import com.cbfacademy.apiassessment.familyActivities.FamilyActivityRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonFamilyActivityRepository implements FamilyActivityRepository{

    private final String filePath;
    private final ObjectMapper objectMapper;
    private final Map<UUID, FamilyActivity> database;

    public JsonFamilyActivityRepository(@Value("${json.file.path}") String filePath) {
        this.filePath = filePath;
        this.objectMapper = new ObjectMapper();
        this.database = loadDataFromJson();

    }

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
    public FamilyActivity retrieve(UUID id) {
        return database.get(id);
    }

    @Override
    public FamilyActivity create(FamilyActivity activity) {
        database.put(activity.getId(), activity);
        saveDataToJson();
        return activity;
    }

    @Override
    public void delete(UUID id) {
        database.remove(id);
        saveDataToJson();
    }

    @Override
    public FamilyActivity update(UUID id, FamilyActivity activity) {
        if (database.containsKey(id)) {
            database.put(id, activity);
            saveDataToJson();
            return activity;
        } else {
            return null; //Change this to exception once you have created it.
        }
    }
    
}
