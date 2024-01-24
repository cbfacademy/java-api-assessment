package com.cbfacademy.apiassessment.familyActivities;

import java.util.List;
import java.util.UUID;

public interface FamilyActivityService {
    
    /**
     * Retrieves a list of all family activities.
     * @return A list of all family activities.
     */
    List<FamilyActivity> getAllFamilyActivities();

    /**
     * Retrieves a family activity by its id.
     * @param id The id of the family activity to retrieve.
     * @return The family activity with the specified id, or null if it is not found.
     */
    FamilyActivity getFamilyActivity(UUID id);

    /**
     * Retrieves a list of all indoor family activities.
     * @return A list of all indoor family activities.
     */
    List<FamilyActivity> getAllIndoorActivities();

    /**
     * Retrieves a list of all outdoor activities.
     * @return A list of all outdoor activities.
     */
    List<FamilyActivity> getAllOutdoorActivities();

    /**
     * Creates a new family activity.
     * @param activity The family activity object to be created.
     * @return The created family activity.
     */
    FamilyActivity createFamilyActivity(FamilyActivity activity);

    /**
     * Updates an existing family activity
     * @param id The id of the family activity to update.
     * @param updatedActivity The updated family activity object.
     * @return The updated family activity.
     */
    FamilyActivity updateFamilyActivity(UUID id, FamilyActivity updatedActivity); 

    /**
     * Deletes a family activity by its id.
     * @param id The id of the family activity to delete.
     */
    void deleteFamilyActivity(UUID id);
    
}
