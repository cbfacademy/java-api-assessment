package com.cbfacademy.apiassessment.familyActivities;

import java.math.BigDecimal;

public class BudgetCalculator {
    public static BigDecimal calculateBudget(int numberOfAdults, int numberOfChildren,
                                            BigDecimal activityCostPerAdult, BigDecimal activityCostPerChild,
                                            BigDecimal foodCostPerAdult, BigDecimal foodCostPerChild) {
        BigDecimal totalAdultCost = activityCostPerAdult.multiply(new BigDecimal(numberOfAdults))
                                    .add(foodCostPerAdult.multiply(new BigDecimal(numberOfAdults)));
        BigDecimal totalChildrenCost = activityCostPerChild.multiply(new BigDecimal(numberOfChildren))
                                        .add(foodCostPerChild.multiply(new BigDecimal(numberOfChildren)));
        return totalAdultCost.add(totalChildrenCost);
    }
}
