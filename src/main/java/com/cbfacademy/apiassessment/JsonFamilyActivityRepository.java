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
import com.fasterxml.jackson.core.type.TypeReference;
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

    private Map<UUID, FamilyActivity> loadDataFromJson() {
        try {
            File file = new File(filePath);
            if (file.exists()) {
                objectMapper.readValue(file, FamilyActivity[].class);
            }
        } catch(IOException e){
            e.printStackTrace();
        }
        return new HashMap<>();
    }

    private void saveDataToJson() {
        
    }

    @Override
    public List<FamilyActivity> retrieveAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'retrieveAll'");
    }

    @Override
    public FamilyActivity retrieve(UUID id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'retrieve'");
    }

    @Override
    public FamilyActivity create(FamilyActivity activity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public void delete(UUID id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public FamilyActivity update(UUID id, FamilyActivity activity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }
    
}
