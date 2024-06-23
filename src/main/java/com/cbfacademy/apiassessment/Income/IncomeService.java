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

public List<Income> getAllIncomeById(UUID id) throws NoSuchElementException {
    return incomeRepository.getAllIncomeById(id);
}

public List<Income> getIncomeById(UUID id) throws NoSuchElementException {
    return incomeRepository.getIncomeById(id);
}

public List<Income> getSalaryAfterTaxesById(UUID id)throws NoSuchElementException {
    return incomeRepository.getSalaryAfterTaxesById(id);
}

public List<Income> getSelfEmploymentIncomeById(UUID id)throws NoSuchElementException {
    return incomeRepository.getSelfEmploymentIncomeById(id);
}

public List<Income>getStatutorySickPayById(UUID id)throws NoSuchElementException {
    return incomeRepository.getStatutorySickPayById(id);
}

public List<Income> getStatutoryMaternityPayById(UUID id)throws NoSuchElementException {
    return incomeRepository.getStatutoryMaternityPayById(id);
}


public List<Income> getFrequency() {
    return incomeRepository.getFrequency();
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

    
    


