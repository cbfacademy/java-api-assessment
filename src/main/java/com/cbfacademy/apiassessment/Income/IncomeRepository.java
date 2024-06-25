package com.cbfacademy.apiassessment.Income;


import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import com.cbfacademy.apiassessment.User.User;

@Repository
public interface IncomeRepository extends ListCrudRepository<Income, UUID>{

 
 List<User> searchById(UUID id);
 List<Income> findIncomeById(UUID id);
 List<Income> findSalaryAfterTaxesById(UUID id);
 List<Income> findSelfEmploymentIncomeById(UUID id);
 List<Income>findStatutorySickPayById(UUID id);
 List<Income> findStatutoryMaternityPayById(UUID id);
 List<Income> findByFrequency(String frequency);
}
