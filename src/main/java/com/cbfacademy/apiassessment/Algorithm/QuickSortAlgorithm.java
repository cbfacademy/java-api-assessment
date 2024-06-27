package com.cbfacademy.apiassessment.Algorithm;


import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.cbfacademy.apiassessment.Calculator.BudgetCalculator;

@Component
public class QuickSortAlgorithm {
   
    private final BudgetCalculator budgetCalculator;
    
    public QuickSortAlgorithm(BudgetCalculator budgetCalculator) {
    this.budgetCalculator = budgetCalculator;
    }

  public void sortBudgetData(UUID id) {
        List<BigDecimal> percentages = budgetCalculator.retrievePercentages(id);
        sortDescending(percentages, 0, percentages.size() - 1);
    }


    public void sortDescending(List<BigDecimal> percentages, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(percentages, low, high);
            sortDescending(percentages, low, partitionIndex - 1);
            sortDescending(percentages, partitionIndex + 1, high);
        }
    }

    public List<BigDecimal> retrieveSortedPercentages(UUID id) {
        List<BigDecimal> percentages = budgetCalculator.retrievePercentages(id);
        sortDescending(percentages, 0, percentages.size() - 1);
        return percentages;
    }

    private int partition(List<BigDecimal> percentages, int low, int high) {
        BigDecimal pivot = percentages.get(high);  // Chooses the last element as the pivot
        int i = (low - 1); // Index of smaller element
        
        for (int j = low; j < high; j++) { //iterates through the elements from low to high - 1
            if (percentages.get(j).compareTo(pivot) >= 0) {   // If current element is greater than or equal to the pivot
                i++;
                // BigDecimal temp = percentages.get(i);
                // percentages.set(i, percentages.get(j));
                // percentages.set(j, temp);
                Collections.swap(percentages, i, j);
            }
        }
        // BigDecimal temp = percentages.get(i + 1); //swap percentages[i + 1] and percentages[high] (pivot)
        // percentages.set(i + 1, percentages.get(high));
        // percentages.set(high, temp);
        Collections.swap(percentages, i + 1, high);
        return i + 1;
    }
 
}
