package com.cbfacademy.apiassessment;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.cbfacademy.apiassessment.familyActivities.ActivityType;
import com.cbfacademy.apiassessment.familyActivities.FamilyActivity;

@DisplayName(value = "The Family Activity should be able to ")
public class FamilyActivityBudgetTest {
    private FamilyActivity familyActivity;

    @BeforeEach
    public void setup() {
        familyActivity = new FamilyActivity("Test Activity", "Test Description", 2, 3,
                new BigDecimal("10"), new BigDecimal("5"), new BigDecimal("8"), new BigDecimal("4"), ActivityType.OUTDOOR);
    }

    @DisplayName(value = "calculate the budget correctly when all the parameters needed to calculate the budget are given values")
    @Test
    public void testBudgetCalculation() {
        // Calculate expected total cost
        BigDecimal expectedTotalCost = new BigDecimal("10").multiply(BigDecimal.valueOf(2)) // Activity cost per adult * number of adults
                .add(new BigDecimal("5").multiply(BigDecimal.valueOf(3))) // Activity cost per child * number of children
                .add(new BigDecimal("8").multiply(BigDecimal.valueOf(2))) // Food cost per adult * number of adults
                .add(new BigDecimal("4").multiply(BigDecimal.valueOf(3))); // Food cost per child * number of children

        // Assert that the calculated budget matches the expected total cost
        assertEquals(expectedTotalCost, familyActivity.getBudget());
    }

    @DisplayName("calculate the budget correctly when there are no children")
    @Test
    public void testBudgetCalculation_NoChildren() {
        familyActivity.setNumberOfChildren(0);

        // Calculate expected total cost when there are no children
        BigDecimal expectedTotalCost = new BigDecimal("10").multiply(BigDecimal.valueOf(2)) // Activity cost per adult * number of adults
                .add(new BigDecimal("8").multiply(BigDecimal.valueOf(2))); // Food cost per adult * number of adults

        // Assert that the calculated budget matches the expected total cost
        assertEquals(expectedTotalCost, familyActivity.getBudget());
    }

    @DisplayName("calculate the budget correctly when there are no adults")
    @Test
    public void testBudgetCalculation_NoAdults() {
        familyActivity.setNumberOfAdults(0);

        // Calculate expected total cost when there are no adults
        BigDecimal expectedTotalCost = new BigDecimal("5").multiply(BigDecimal.valueOf(3)); // Activity cost per child * number of children

        // Assert that the calculated budget matches the expected total cost
        assertEquals(expectedTotalCost, familyActivity.getBudget());
    }

    @DisplayName("calculate the budget correctly when there is no activity cost for adults")
    @Test
    public void testBudgetCalculation_NoActivityCostForAdults() {
        familyActivity.setActivityCostPerAdult(BigDecimal.ZERO);

        // Calculate expected total cost when there is no activity cost for adults
        BigDecimal expectedTotalCost = new BigDecimal("5").multiply(BigDecimal.valueOf(3)) // Activity cost per child * number of children
                .add(new BigDecimal("8").multiply(BigDecimal.valueOf(2))); // Food cost per adult * number of adults

        // Assert that the calculated budget matches the expected total cost
        assertEquals(expectedTotalCost, familyActivity.getBudget());
    }

    @DisplayName("calculate the budget correctly when there is no activity cost for children")
    @Test
    public void testBudgetCalculation_NoActivityCostForChildren() {
        familyActivity.setActivityCostPerChild(BigDecimal.ZERO);

        // Calculate expected total cost when there is no activity cost for children
        BigDecimal expectedTotalCost = new BigDecimal("10").multiply(BigDecimal.valueOf(2)) // Activity cost per adult * number of adults
                .add(new BigDecimal("8").multiply(BigDecimal.valueOf(2))); // Food cost per adult * number of adults

        // Assert that the calculated budget matches the expected total cost
        assertEquals(expectedTotalCost, familyActivity.getBudget());
    }
}
