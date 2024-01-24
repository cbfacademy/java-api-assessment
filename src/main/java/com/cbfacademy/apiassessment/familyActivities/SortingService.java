package com.cbfacademy.apiassessment.familyActivities;

import java.util.List;

public interface SortingService {
    
    List<FamilyActivity> sortActivitiesByBudget(List<FamilyActivity> activity);
}
