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
public List<Bills> getAllBillsById(@PathVariable UUID id, @RequestBody Bills bills) throws NoSuchElementException{
        return billsService.getAllBillsById(id);
}

@GetMapping("/{id}")
    public List<Bills> getBillsById(@PathVariable UUID id, @RequestBody Bills bills) throws NoSuchElementException{
        return billsService.getBillsById(id);            
}

@GetMapping("rent/{id}")
    public List<Bills> getRentById(@PathVariable UUID id, @RequestBody Bills bills) throws NoSuchElementException{
        return billsService.getRentById(id);            
}

@GetMapping("mortgage/{id}")
    public List<Bills> getMortgageById(@PathVariable UUID id, @RequestBody Bills bills) throws NoSuchElementException{
        return billsService.getMortgageById(id);            
}

@GetMapping("mortgage-endowment/{id}")
    public List<Bills> getMortgageEndowmentById(@PathVariable UUID id, @RequestBody Bills bills) throws NoSuchElementException{
        return billsService.getMortgageEndowmentById(id);            
}

@GetMapping("council-tax/{id}")
    public List<Bills> getCouncilTaxById(@PathVariable UUID id, @RequestBody Bills bills) throws NoSuchElementException{
        return billsService.getCouncilTaxById(id);            
}

@GetMapping("insurance/{id}")
    public List<Bills> getInsuranceById(@PathVariable UUID id, @RequestBody Bills bills) throws NoSuchElementException{
        return billsService.getInsuranceById(id);            
}

@GetMapping("utilities/{id}")
    public List<Bills> getUtilitiesById(@PathVariable UUID id, @RequestBody Bills bills) throws NoSuchElementException{
        return billsService.getUtilitiesById(id);            
}

@GetMapping("groceries/{id}")
    public List<Bills>  getGroceriesById(@PathVariable UUID id, @RequestBody Bills bills) throws NoSuchElementException{
        return billsService.getGroceriesById(id);            
}

@GetMapping("frequency/{id}")
public List<Bills> getFrequency() throws NoSuchElementException{
        return billsService.getFrequency();
}

@PostMapping
    public ResponseEntity<Bills> createBills(@RequestBody Bills bills) {
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

