package com.cbfacademy.apiassessment.Income;

import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;



@Service
public class IncomeService {
public IncomeRepository incomeRepository;

public IncomeService(IncomeRepository incomeRepository) {
    this.incomeRepository = incomeRepository;
}

public List<Income> findIncomeById(UUID id) throws NoSuchElementException {
    return incomeRepository.findIncomeById(id);
}

public List<Income> findSalaryAfterTaxesById(UUID id)throws NoSuchElementException {
    return incomeRepository.findSalaryAfterTaxesById(id);
}

public List<Income> findSelfEmploymentIncomeById(UUID id)throws NoSuchElementException {
    return incomeRepository.findSelfEmploymentIncomeById(id);
}

public List<Income>findStatutorySickPayById(UUID id)throws NoSuchElementException {
    return incomeRepository.findStatutorySickPayById(id);
}

public List<Income> findStatutoryMaternityPayById(UUID id)throws NoSuchElementException {
    return incomeRepository.findStatutoryMaternityPayById(id);
}


public List<Income> findByFrequency(String frequency) {
    return incomeRepository.findByFrequency(frequency);
}

public Income createIncome(Income income)
throws IllegalArgumentException, OptimisticLockingFailureException{
    return incomeRepository.save(income);
}

Income updateIncome(UUID id, Income updatedIncome) throws NoSuchElementException, IllegalArgumentException{
   
    updatedIncome.setUser(updatedIncome.getUser());
    updatedIncome.setSalaryAfterTaxesById(updatedIncome.getSalaryAfterTaxesById()!= null ? updatedIncome.getSalaryAfterTaxesById() : BigDecimal.ZERO);
    updatedIncome.setSelfEmploymentIncomeById(updatedIncome.getSelfEmploymentIncomeById()!= null ? updatedIncome.getSelfEmploymentIncomeById() : BigDecimal.ZERO);
    updatedIncome.setStatutorySickPayById(updatedIncome.getStatutorySickPayById()!= null ? updatedIncome.getStatutorySickPayById() : BigDecimal.ZERO);
    updatedIncome.setStatutoryMaternityPayById(updatedIncome.getStatutoryMaternityPayById()!= null ? updatedIncome.getStatutoryMaternityPayById() : BigDecimal.ZERO);
    updatedIncome.setFrequency(updatedIncome.getFrequency());

    return incomeRepository.save(updatedIncome);
       
    
       }

        public void deleteIncomeById(UUID id){
            if(!incomeRepository.existsById(id)){
                throw new NoSuchElementException("Income Not Found");
            }
                incomeRepository.deleteById(id);
        }

}

    
    


