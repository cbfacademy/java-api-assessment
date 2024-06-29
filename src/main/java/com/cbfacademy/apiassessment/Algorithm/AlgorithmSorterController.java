package com.cbfacademy.apiassessment.Algorithm;

import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

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
    public ResponseEntity<List<BigDecimal>> sortAllUsersPercentage() {
        try {
            List<BigDecimal> sortedPercentages = quickSortAlgorithm.sortAllUsersPercentage();
            return ResponseEntity.ok(sortedPercentages);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
}