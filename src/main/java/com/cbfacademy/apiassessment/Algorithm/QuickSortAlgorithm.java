package com.cbfacademy.apiassessment.Algorithm;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cbfacademy.apiassessment.User.UserService;

@Component
public class QuickSortAlgorithm {

    private final UserService userService;
    
    public QuickSortAlgorithm(UserService userService) {
        this.userService = userService;
    }

    public List<BigDecimal> sortAllUsersPercentage() {
        List<BigDecimal> percentages = userService.getAllUsersPercentages();
        sortDescending(percentages, 0, percentages.size() - 1);
        return percentages;
    }

    private void sortDescending(List<BigDecimal> percentages, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(percentages, low, high);
            sortDescending(percentages, low, partitionIndex - 1);
            sortDescending(percentages, partitionIndex + 1, high);
        }
    }

    private int partition(List<BigDecimal> percentages, int low, int high) {
        BigDecimal pivot = percentages.get(high);  // Chooses the last element as the pivot
        int i = (low - 1); // Index of smaller element
        
        for (int j = low; j < high; j++) { //iterates through the elements from low to high - 1
            if (percentages.get(j).compareTo(pivot) >= 0) {   // If current element is greater than or equal to the pivot
                i++;
                Collections.swap(percentages, i, j);
            }
        }
        Collections.swap(percentages, i + 1, high);
        return i + 1;
    }
}
