package com.cbfacademy.apiassessment.Calculator;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/budget")
public class BudgetCalculatorController {

    private BudgetCalculator budgetCalculator;


@PostMapping("/calculate-savings")
    public ResponseEntity<String> calculateSavings(@RequestBody CalculateSavingsRequest request) {
        BigDecimal totalIncome = budgetCalculator.calculateTotalIncome();
        BigDecimal totalExpenses = budgetCalculator.calculateTotalExpenses();
        BigDecimal userPercentage = request.getUserPercentage();

        BigDecimal calculatedSavings = budgetCalculator.calculateSavingsByUserPercentage(totalIncome, totalExpenses, userPercentage);
        
        String response = "Based on your input percentage of " + userPercentage + "%, your calculated savings are: " + calculatedSavings;

        return ResponseEntity.ok(response);
    }
    static class CalculateSavingsRequest {
        private BigDecimal userPercentage;

        public BigDecimal getUserPercentage() {
            return userPercentage;
        }

        public void setUserPercentage(BigDecimal userPercentage) {
            this.userPercentage = userPercentage;
        }
}
}

