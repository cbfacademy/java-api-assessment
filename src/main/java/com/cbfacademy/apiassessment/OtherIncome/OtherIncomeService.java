package com.cbfacademy.apiassessment.OtherIncome;

import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;

import java.util.UUID;

import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;




@Service
public class OtherIncomeService {
public OtherIncomeRepository otherIncomeRepository;

public OtherIncomeService(OtherIncomeRepository otherIncomeRepository){
        this.otherIncomeRepository = otherIncomeRepository;
}

public List<OtherIncome> findOtherIncomeById(UUID id) {
    return otherIncomeRepository.findOtherIncomeById(id);
}

public List<OtherIncome> findRentalIncomeById(UUID id) {
    return otherIncomeRepository.findOtherIncomeById(id);
}

public List<OtherIncome> findInvestmentIncomeById(UUID id) {
    return otherIncomeRepository.findOtherIncomeById(id);
}

public List<OtherIncome> findByFrequency(String frequency) {
    return otherIncomeRepository.findByFrequency(frequency);
}

public OtherIncome createOtherIncome(OtherIncome otherIncome)
    throws IllegalArgumentException, OptimisticLockingFailureException{
        return otherIncomeRepository.save(otherIncome);
    }

OtherIncome updateOtherIncome(UUID id, OtherIncome updatedOtherIncome)
    throws IllegalArgumentException, OptimisticLockingFailureException{
        OtherIncome otherIncome = otherIncomeRepository.findById(id).orElseThrow();

        otherIncome.setuser(updatedOtherIncome.getUser());
        otherIncome.setRentalIncomeById(updatedOtherIncome.getRentalIncomeById()!= null ? updatedOtherIncome.getRentalIncomeById() : BigDecimal.ZERO);
        otherIncome.setInvestmentIncomeById(updatedOtherIncome.getInvestmentIncomeById()!= null ? updatedOtherIncome.getInvestmentIncomeById() : BigDecimal.ZERO);
        otherIncome.setFrequency(updatedOtherIncome.getFrequency());
    
    return otherIncomeRepository.save(updatedOtherIncome);
    }

    public void deleteOtherIncomeById(UUID id){
        if(!otherIncomeRepository.existsById(id)){
            throw new NoSuchElementException("Other Income Not Found");
        }
            otherIncomeRepository.deleteById(id);
    }
}

