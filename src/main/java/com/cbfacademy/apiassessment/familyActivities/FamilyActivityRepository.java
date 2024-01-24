package com.cbfacademy.apiassessment.familyActivities;

import java.util.List;
import java.util.UUID;

public interface FamilyActivityRepository{
    
    //Retrieves all family activities.
    List<FamilyActivity> retrieveAll();

    /**
     * Retrieves a family activity by its unique identifier.
     * @param id the identifier of the family activity.
     * @return the found family activity, or null if it does not exist.
     */
    FamilyActivity retrieve(UUID id);

    /**
     * Creates a new family activity
     * @param activity the {@code <FamilyActivity>} to create.
     * @return the created family activity.
     */
    FamilyActivity create(FamilyActivity activity);

    /**
     * Deletes a family activity based on its unique identifier.
     * @param id the id of activity to delete.
     */
    void delete(UUID id);

    /**
     * Updates an existing family activity in the repository.
     * @param id the activity to update.
     * @param activity the activity to update.
     * @return the updated family activity.
     */
    FamilyActivity update(UUID id,FamilyActivity activity);
}
