package com.cbfacademy.apiassessment.Bills;

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
@RequestMapping("/bills")
public class BillsController {
    BillsService billsService;

    public BillsController(BillsService billsService) {
        this.billsService = billsService;
    }

@GetMapping("/{id}")
    public List<Bills> getBillsById(@PathVariable UUID id) throws NoSuchElementException{
        return billsService.findBillsById(id);            
}

@GetMapping("rent/{id}")
    public List<Bills> getRentById(@PathVariable UUID id) throws NoSuchElementException{
        return billsService.findRentById(id);            
}

@GetMapping("mortgage/{id}")
    public List<Bills> getMortgageById(@PathVariable UUID id) throws NoSuchElementException{
        return billsService.findMortgageById(id);            
}

@GetMapping("mortgage-endowment/{id}")
    public List<Bills> getMortgageEndowmentById(@PathVariable UUID id) throws NoSuchElementException{
        return billsService.findMortgageEndowmentById(id);            
}

@GetMapping("council-tax/{id}")
    public List<Bills> getCouncilTaxById(@PathVariable UUID id) throws NoSuchElementException{
        return billsService.findCouncilTaxById(id);            
}

@GetMapping("insurance/{id}")
    public List<Bills> getInsuranceById(@PathVariable UUID id) throws NoSuchElementException{
        return billsService.findInsuranceById(id);            
}

@GetMapping("utilities/{id}")
    public List<Bills> getUtilitiesById(@PathVariable UUID id) throws NoSuchElementException{
        return billsService.findUtilitiesById(id);            
}

@GetMapping("groceries/{id}")
    public List<Bills>  getGroceriesById(@PathVariable UUID id) throws NoSuchElementException{
        return billsService.findGroceriesById(id);            
}

@GetMapping("frequency/{id}")
public List<Bills> getFrequency(String frequency) throws NoSuchElementException{
        return billsService.findByFrequency(frequency);
}

@PostMapping("/{id}")
    public ResponseEntity<Bills> createBills(@PathVariable UUID id, @RequestBody Bills bills) {
        try {
            Bills createdBills = billsService.createBills(bills);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdBills);
        } catch (RuntimeException exception) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage(), exception);
        }
    }

 @PutMapping("/{id}")
    public ResponseEntity<Bills> updateBills(@PathVariable UUID id, @RequestBody Bills bills) {
        try {
            Bills updatedBills = billsService.updateBills(id, bills);
            return ResponseEntity.ok(updatedBills);
        } catch (NoSuchElementException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Bill not found", exception);
        } catch (RuntimeException exception) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage(), exception);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBills(@PathVariable UUID id) {
        try {
            billsService.deleteBillsById(id);
            return ResponseEntity.noContent().build();
        } catch (NoSuchElementException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Bill not found", exception);
        } catch (RuntimeException exception) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage(), exception);
        }
    }

}

