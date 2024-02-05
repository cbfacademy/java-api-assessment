package com.cbfacademy.apiassessment.familyActivities;

import java.math.BigDecimal;
import java.util.UUID;

public class FamilyActivity {
    private final UUID id;
    private String activityName; 
    private String activityDescription; 
    private int numberOfAdults; 
    private int numberOfChildren;
    private BigDecimal activityCostPerAdult; 
    private BigDecimal activityCostPerChild; 
    private BigDecimal foodCostPerAdult;
    private BigDecimal foodCostPerChild;
    private ActivityType activityType;
    private BigDecimal budget;

public FamilyActivity(String activityName, String activityDescription, int numberOfAdults, int numberOfChildren,
        BigDecimal activityCostPerAdult, BigDecimal activityCostPerChild, BigDecimal foodCostPerAdult,
        BigDecimal foodCostPerChild, ActivityType activityType) {
    this.activityName = activityName;
    this.activityDescription = activityDescription;
    this.numberOfAdults = numberOfAdults;
    this.numberOfChildren = numberOfChildren;
    this.activityCostPerAdult = activityCostPerAdult != null ? activityCostPerAdult : BigDecimal.ZERO;
    this.activityCostPerChild = activityCostPerChild != null ? activityCostPerChild : BigDecimal.ZERO;
    this.foodCostPerAdult = foodCostPerAdult != null ? foodCostPerAdult : BigDecimal.ZERO;
    this.foodCostPerChild = foodCostPerChild != null ? foodCostPerChild : BigDecimal.ZERO;
    this.activityType = activityType;
    this.id = UUID.randomUUID();

    BigDecimal totalAdultCost = this.activityCostPerAdult.multiply(new BigDecimal(numberOfAdults)).add(this.foodCostPerAdult.multiply(new BigDecimal(numberOfAdults)));
    BigDecimal totalChildrenCost = this.activityCostPerChild.multiply(new BigDecimal(numberOfChildren)).add(this.foodCostPerChild.multiply(new BigDecimal(numberOfChildren)));

    this.budget = totalAdultCost.add(totalChildrenCost);
}

    public UUID getId() {
        return id;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String newActivityName) {
        this.activityName = newActivityName;
    }

    public String getActivityDescription() {
        return activityDescription;
    }

    public void setActivityDescription(String newActivityDescription) {
        this.activityDescription = newActivityDescription;
    }

    public int getNumberOfAdults() {
        return numberOfAdults;
    }

    public void setNumberOfAdults(int newNumberOfAdults) {
        this.numberOfAdults = newNumberOfAdults;
    }

    public int getNumberOfChildren() {
        return numberOfChildren;
    }

    public void setNumberOfChildren(int newNumberOfChildren) {
        this.numberOfChildren = newNumberOfChildren;
    }

    public BigDecimal getActivityCostPerAdult() {
        return activityCostPerAdult;
    }

    public void setActivityCostPerAdult(BigDecimal newActivityCostPerAdult) {
        this.activityCostPerAdult = newActivityCostPerAdult;
    }

    public BigDecimal getActivityCostPerChild() {
        return activityCostPerChild;
    }

    public void setActivityCostPerChild(BigDecimal newActivityCostPerChild) {
        this.activityCostPerChild = newActivityCostPerChild;
    }

    public BigDecimal getFoodCostPerAdult() {
        return foodCostPerAdult;
    }

    public void setFoodCostPerAdult(BigDecimal newFoodCostPerAdult) {
        this.foodCostPerAdult = newFoodCostPerAdult;
    }

    public BigDecimal getFoodCostPerChild() {
        return foodCostPerChild;
    }

    public void setFoodCostPerChild(BigDecimal newFoodCostPerChild) {
        this.foodCostPerChild = newFoodCostPerChild;
    }

    public ActivityType getActivityType() {
        return activityType;
    }

    public BigDecimal getBudget() {
        return budget;
    }

}
