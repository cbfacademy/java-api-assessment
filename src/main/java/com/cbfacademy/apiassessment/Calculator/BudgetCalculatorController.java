package com.cbfacademy.apiassessment.Calculator;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




import java.math.BigDecimal;
import java.util.NoSuchElementException;

import java.util.UUID;

@RestController
@RequestMapping("/api/budgetplanner")
public class BudgetCalculatorController {

    private BudgetCalculator budgetCalculator;
   
    

    public BudgetCalculatorController(BudgetCalculator budgetCalculator ) {
        this.budgetCalculator = budgetCalculator;
       
    }

@GetMapping("/user/{id}/savings")
public ResponseEntity<BigDecimal> calculateSavingsByUsersPercentage(@PathVariable UUID id) {
    try {
        BigDecimal savings = budgetCalculator.calculatePercentageOfSavings(id);
        return ResponseEntity.ok(savings);
    } catch (NoSuchElementException e) {
        return ResponseEntity.notFound().build();
    }
}
    
@PostMapping("/calculate-savings")
    public ResponseEntity<String> calculateSavings(@PathVariable UUID id, @RequestBody CalculateSavingsRequest request) {
        BigDecimal totalIncome = budgetCalculator.calculateTotalIncome(id);
        BigDecimal totalExpenses = budgetCalculator.calculateTotalExpenses(id);
        BigDecimal userPercentage = request.getUserPercentage();

        BigDecimal calculatedSavings = budgetCalculator.calculatePercentageOfSavings(totalIncome, totalExpenses, userPercentage);
        
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


// @GetMapping("user-percentage/{id}")
// public BigDecimal calculateSavingsByUsersPercentage(@PathVariable UUID id) throws NoSuchElementException {
//     Optional<User> optionalUser = userService.getById(id);
//     BigDecimal userPercentage = optionalUser.map(User::getUserPercentage)
//                                             .orElseThrow(() -> new NoSuchElementException("User not found or percentage not available"));
//     return budgetCalculator.calculateSavingsByUsersPercentage(id, optionalUser, userPercentage);
// }


// import com.cbfacademy.apiassessment.User.UserService;
 // private final UserService userService;
// this.userService = userService;