package com.cbfacademy.apiassessment.volunteers.search;

import java.util.List;

public class AdvancedSearchQuery {
    private List<String> skills;
    private boolean isActive;
    
    // Constructors
    public AdvancedSearchQuery(List<String> skills, boolean isActive) {
        this.skills = skills;
        this.isActive = isActive;
    }
   
    // Getters and Setters
    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
     


}