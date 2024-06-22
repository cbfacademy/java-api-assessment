package com.cbfacademy.apiassessment.Bills;

import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;

import java.util.UUID;

import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;




@Service
public class BillsService {
public BillsRepository billsRepository;

public BillsService(BillsRepository billsRepository) {
    this.billsRepository = billsRepository;
}

public List<Bills> getAllBillsById(UUID id) {
    return billsRepository.findAll();
}

public List<Bills> getBillsById(UUID id) throws NoSuchElementException  {
    return billsRepository.getBillsById(id);
}

public List<Bills> getRentById(UUID id) {
    return billsRepository.getRentById(id);
}
// start
public List<Bills> getMortgageById(UUID id) {
    return billsRepository.getMortgageById(id);
}

public List<Bills> getMortgageEndowmentById(UUID id) {
    return billsRepository.getMortgageEndowmentById(id);
}

public List<Bills> getCouncilTaxById(UUID id) {
    return billsRepository.getCouncilTaxById(id);
}

public List<Bills> getInsuranceById(UUID id) {
    return billsRepository.getInsuranceById(id);
}

public List<Bills> getUtilitiesById(UUID id) {
    return billsRepository.getUtilitiesById(id);
}

public List<Bills> getGroceriesById(UUID id) {
    return billsRepository.getGroceriesById(id);
}

public List<Bills> getFrequency() {
    return billsRepository.getFrequency();
}



public Bills createBills(Bills bills)
throws IllegalArgumentException, OptimisticLockingFailureException{
    return billsRepository.save(bills);
}

Bills updateBills(UUID id, Bills updatedBills) 
    throws NoSuchElementException, IllegalArgumentException{
    Bills bills = billsRepository.findById(id).orElseThrow();

    bills.setuser(updatedBills.getUser());
    bills.setRentById(updatedBills.getRentById()!= null ? updatedBills.getRentById() : BigDecimal.ZERO);
    bills.setMortgageById(updatedBills.getMortgageById()!= null ? updatedBills.getMortgageById() : BigDecimal.ZERO);
    bills.setMortgageEndowmentById(updatedBills.getMortgageEndowmentById()!= null ? updatedBills.getMortgageEndowmentById() : BigDecimal.ZERO);
    bills.setCouncilTaxById(updatedBills.getCouncilTaxById()!= null ? updatedBills.getCouncilTaxById() : BigDecimal.ZERO);
    bills.setInsuranceById(updatedBills.getInsuranceById()!= null ? updatedBills.getInsuranceById() : BigDecimal.ZERO);
    bills.setUtilitiesById(updatedBills.getUtilitiesById()!= null ? updatedBills.getUtilitiesById() : BigDecimal.ZERO);
    bills.setGroceriesById(updatedBills.getGroceriesById()!= null ? updatedBills.getGroceriesById() : BigDecimal.ZERO);
    bills.setFrequency(updatedBills.getFrequency());

    return billsRepository.save(updatedBills);
       
    }
    public void deleteBillsById(UUID id){
        if(!billsRepository.existsById(id)){
            throw new NoSuchElementException("Bill Not Found");
        }
            billsRepository.deleteById(id);
    }
    }
    




