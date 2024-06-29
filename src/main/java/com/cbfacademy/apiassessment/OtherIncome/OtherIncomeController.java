package com.cbfacademy.apiassessment.OtherIncome;

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
@RequestMapping("/otherincome")
public class OtherIncomeController {
OtherIncomeService otherIncomeService;

public OtherIncomeController(OtherIncomeService otherIncomeService) {
    this.otherIncomeService = otherIncomeService;
}

@GetMapping("/other-income/{id}")
    public List<OtherIncome> getOtherIncomeById(@PathVariable UUID id) throws NoSuchElementException {
        return otherIncomeService.findOtherIncomeById(id);            
}

@GetMapping("/rental-income/{id}")
    public List<OtherIncome> getRentalIncomeById(@PathVariable UUID id) throws NoSuchElementException {
        return otherIncomeService.findRentalIncomeById(id);            
}

@GetMapping("investment-income/{id}")
    public List<OtherIncome> getInvestmentIncomeById(@PathVariable UUID id) throws NoSuchElementException {
        return otherIncomeService.findInvestmentIncomeById(id);            
}

@GetMapping("frequency/{id}")
public List<OtherIncome> getFrequency(@PathVariable UUID id, String frequency) throws NoSuchElementException{
        return otherIncomeService.findByFrequency(frequency);
}

 @PostMapping("/{id}")
    public ResponseEntity<OtherIncome> createOtherIncome (@RequestBody OtherIncome otherIncome) {
        try {
            OtherIncome createdotherIncome = otherIncomeService.createOtherIncome(otherIncome);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdotherIncome);
        } catch (RuntimeException exception) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage(), exception);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<OtherIncome> updateOtherIncome(@PathVariable UUID id, @RequestBody OtherIncome otherIncome) {
        try {
            OtherIncome updatedOtherIncome = otherIncomeService.updateOtherIncome(id, otherIncome);
            return ResponseEntity.ok(updatedOtherIncome);
        } catch (NoSuchElementException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Other Income not found", exception);
        } catch (RuntimeException exception) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage(), exception);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOtherIncome(@PathVariable UUID id) {
        try {
            otherIncomeService.deleteOtherIncomeById(id);
            return ResponseEntity.noContent().build();
        } catch (NoSuchElementException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Other Income not found", exception);
        } catch (RuntimeException exception) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage(), exception);
        }
    }
}
