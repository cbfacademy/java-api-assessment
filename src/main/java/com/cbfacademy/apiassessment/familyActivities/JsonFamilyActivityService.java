package com.cbfacademy.apiassessment.familyActivities;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
@Service
public class JsonFamilyActivityService implements FamilyActivityService {

    FamilyActivityRepository familyActivityRepository;

    public JsonFamilyActivityService(FamilyActivityRepository familyActivityRepository) {
        this.familyActivityRepository = familyActivityRepository;
    }

    @Override
    public List<FamilyActivity> getFamilyActivities() {
        return familyActivityRepository.retrieveAll();
    }

    @Override
    public List<FamilyActivity> getFamilyActivities(ActivityType type) {
        return familyActivityRepository.retrieveAllByActivityType(type);
    }

    @Override
    public List<FamilyActivity> getFamilyActivities(SortOrder order) {
        //Retrieve all activities and hold them in a variable
        List<FamilyActivity> activities = familyActivityRepository.retrieveAll();
        //Sort the activities in the variable
        ActivitySorter.sort(activities, order);
        //Return the sorted list held in the variable.
        return activities;
    }

    @Override
    public List<FamilyActivity> getFamilyActivities(ActivityType type, SortOrder order) {
        //Retrieve all activities of the given type and hold them in a variable
        List<FamilyActivity> activities = familyActivityRepository.retrieveAllByActivityType(type);
        //Sort the activities in the variable
        ActivitySorter.sort(activities, order);
        //Return the sorted list held in the variable.
        return activities;
    }
    

    @Override
    public FamilyActivity getFamilyActivity(UUID id) {
        return familyActivityRepository.retrieve(id);
    }
    

    @Override
    public FamilyActivity createFamilyActivity(FamilyActivity activity) {
        try {
            return familyActivityRepository.create(activity);
        } catch (InvalidActivityDetailsException | IncompleteActivityDetailsException e) {
            throw new RuntimeException("Error creating family activity", e);
        }
    }

    @Override
    public FamilyActivity updateFamilyActivity(UUID id, FamilyActivity updatedActivity) {
        try {
            return familyActivityRepository.update(id, updatedActivity);
        } catch (InvalidActivityDetailsException | IncompleteActivityDetailsException e) {
            throw new RuntimeException("Error updating family activity", e);
        }
    }


    @Override
    public void deleteFamilyActivity(UUID id) {
        familyActivityRepository.delete(id);
    }

}
