package com.cbfacademy.apiassessment.Income;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;






@RestController
@RequestMapping("/income")
public class IncomeController {
IncomeService incomeService;

public IncomeController(IncomeService incomeService) {
    this.incomeService = incomeService;
}

@GetMapping("/{id}")
public List<Income> getAllIncomeById(@PathVariable UUID id, @RequestBody Income income) throws NoSuchElementException{
        return incomeService.getAllIncomeById(id);
}

 @GetMapping("/{id}")
    public List<Income> getIncomeById(@PathVariable UUID id, @RequestBody Income income )throws NoSuchElementException {
        return incomeService.getIncomeById(id);
    }

@GetMapping("/{id}")
public List<Income> getSalaryAfterTaxesById(@PathVariable UUID id, @RequestBody Income income) throws NoSuchElementException{
        return incomeService.getSalaryAfterTaxesById(id);
}

@GetMapping("/{id}")
public List<Income> getSelfEmploymentIncomeById(@PathVariable UUID id, @RequestBody Income income) throws NoSuchElementException{
        return incomeService.getSelfEmploymentIncomeById(id);
}

@GetMapping("/{id}")
public List<Income> getStatutorySickPayById(@PathVariable UUID id, @RequestBody Income income) throws NoSuchElementException{
        return incomeService.getStatutorySickPayById(id);
}

@GetMapping("/{id}")
public List<Income> getStatutoryMaternityPayById(@PathVariable UUID id, @RequestBody Income income) throws NoSuchElementException{
        return incomeService.getStatutoryMaternityPayById(id);
}

@GetMapping
public List<Income> getFrequency() throws NoSuchElementException{
        return incomeService.getFrequency();
}


 @PostMapping
    public ResponseEntity<Income> createIncome (@RequestBody Income income) {
        try {
            Income createdIncome = incomeService.createIncome(income);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdIncome);
        } catch (RuntimeException exception) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage(), exception);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Income> updateIncome(@PathVariable UUID id, @RequestBody Income income) {
        try {
            Income updatedIncome = incomeService.updateIncome(id, income);
            return ResponseEntity.ok(updatedIncome);
        } catch (NoSuchElementException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Income not found", exception);
        } catch (RuntimeException exception) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage(), exception);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteIncome(@PathVariable UUID id) {
        try {
            incomeService.deleteIncomeById(id);
            return ResponseEntity.noContent().build();
        } catch (NoSuchElementException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Income not found", exception);
        } catch (RuntimeException exception) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage(), exception);
        }
    }

}
