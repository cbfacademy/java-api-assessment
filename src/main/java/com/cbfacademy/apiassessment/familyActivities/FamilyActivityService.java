package com.cbfacademy.apiassessment.familyActivities;

import java.util.List;
import java.util.UUID;

public interface FamilyActivityService {
    
    /**
     * Retrieves a list of all family activities.
     * @return A list of all family activities.
     */
    List<FamilyActivity> getFamilyActivities();

    /**
     * Retrieves a list of all activities of the given type.
     * @param type The ActivityType of the activities to retrieve.
     * @return A list of all activities of the given type.
     */
    List<FamilyActivity> getFamilyActivities(ActivityType type);

    /**
     * Retrieves a list of all activities sorted by the budget amounts in the given order.
     * @param order The order in which we want the activities to be sorted. 
     * @return A list of all activities sorted by the budget amounts in the given order.
     */
    List<FamilyActivity> getFamilyActivities(SortOrder order);

    /**
     * Retrieves a list of activities of the given type sorted by budget in the given order.
     * @param type The ActivityType of the activities to retrieve.
     * @param order The order in which we want the activities to be sorted.
     * @return A list of activities of the given type sorted by budget in the given order.
     */
    List<FamilyActivity> getFamilyActivities(ActivityType type, SortOrder order);

    /**
     * Retrieves a family activity by its id.
     * @param id The id of the family activity to retrieve.
     * @return The family activity with the specified id, or null if it is not found.
     */
    FamilyActivity getFamilyActivity(UUID id);

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
