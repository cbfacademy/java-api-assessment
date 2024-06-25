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

public List<Bills> findBillsById(UUID id) throws NoSuchElementException  {
    return billsRepository.findBillsById(id);
}

public List<Bills> findRentById(UUID id) {
    return billsRepository.findRentById(id);
}
// start
public List<Bills> findMortgageById(UUID id) {
    return billsRepository.findMortgageById(id);
}

public List<Bills> findMortgageEndowmentById(UUID id) {
    return billsRepository.findMortgageEndowmentById(id);
}

public List<Bills> findCouncilTaxById(UUID id) {
    return billsRepository.findCouncilTaxById(id);
}

public List<Bills> findInsuranceById(UUID id) {
    return billsRepository.findInsuranceById(id);
}

public List<Bills> findUtilitiesById(UUID id) {
    return billsRepository.findUtilitiesById(id);
}

public List<Bills> findGroceriesById(UUID id) {
    return billsRepository.findGroceriesById(id);
}

public List<Bills> findByFrequency(String frequency) {
    return billsRepository.findByFrequency(frequency);
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
    




