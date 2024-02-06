package com.cbfacademy.apiassessment;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import com.cbfacademy.apiassessment.familyActivities.BudgetCalculator;


@DisplayName(value = "The Family Activity should be able to ")
public class BudgetCalculatorTest {

    @DisplayName("calculate the budget correctly when all the parameters needed to calculate the budget are given values")
    @Test
    public void testBudgetCalculation() {
        BigDecimal expectedTotalCost = BudgetCalculator.calculateBudget(5, 5, new BigDecimal(10), new BigDecimal(5), new BigDecimal(10), new BigDecimal(5));

        assertEquals(new BigDecimal(150), expectedTotalCost);
    }

    @DisplayName("calculate the budget correctly when there is no activity cost for adults")
    @Test
    public void testBudgetCalculationWithNoActivityCostForAdults() {
        BigDecimal expectedTotalCost = BudgetCalculator.calculateBudget(5, 5, new BigDecimal(0), new BigDecimal(5), new BigDecimal(10), new BigDecimal(5));

        assertEquals(new BigDecimal(100), expectedTotalCost);
    }

    @DisplayName("calculate the budget correctly when there is no activity cost for adults and children")
    @Test
    public void testBudgetCalculationNoActivityCost() {
        BigDecimal expectedTotalCost = BudgetCalculator.calculateBudget(5, 5, new BigDecimal(0), new BigDecimal(0), new BigDecimal(10), new BigDecimal(5));

        assertEquals(new BigDecimal(75), expectedTotalCost);
    } 

    @DisplayName("calculate the budget correctly when there is no activity cost for children")
    @Test
    public void testBudgetCalculationNoActivityCostForChildren() {
        BigDecimal expectedTotalCost = BudgetCalculator.calculateBudget(5, 5, new BigDecimal(10), new BigDecimal(0), new BigDecimal(10), new BigDecimal(5));

        assertEquals(new BigDecimal(125), expectedTotalCost);
    }

    @DisplayName("calculate the budget correctly when some parameters are zero")
    @Test
    public void testBudgetCalculationWithZeroValues() {
        BigDecimal expectedTotalCost = BudgetCalculator.calculateBudget(5, 5, BigDecimal.ZERO, new BigDecimal(5), new BigDecimal(10), new BigDecimal(5));

        assertEquals(new BigDecimal(100), expectedTotalCost);
    }
}
