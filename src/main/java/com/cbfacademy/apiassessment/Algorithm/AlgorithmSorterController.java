package com.cbfacademy.apiassessment.Algorithm;

import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/budgetplanner")

public class AlgorithmSorterController {
    private final QuickSortAlgorithm quickSortAlgorithm;

    public AlgorithmSorterController(QuickSortAlgorithm quickSortAlgorithm) {
        this.quickSortAlgorithm = quickSortAlgorithm;
    }

    @GetMapping("/sort/sortAllUsers")
    public ResponseEntity<List<BigDecimal>> sortBudgetData(@PathVariable UUID userId) {
        try {
            quickSortAlgorithm.sortBudgetData(userId);
            List<BigDecimal> sortedPercentages = quickSortAlgorithm.retrieveSortedPercentages(userId);
            return ResponseEntity.ok(sortedPercentages);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
}