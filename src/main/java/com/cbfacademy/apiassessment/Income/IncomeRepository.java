package com.cbfacademy.apiassessment.Income;


import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.ListCrudRepository;


import com.cbfacademy.apiassessment.User.User;

public interface IncomeRepository extends ListCrudRepository<Income, UUID>{

 List<Income> searchByUser(String name);
 List<User> searchById(UUID id);
 List<Income> getIncomeById(UUID id);
 List<Income> getSalaryAfterTaxesById(UUID id);
 List<Income> getSelfEmploymentIncomeById(UUID id);
 List<Income>getStatutorySickPayById(UUID id);
 List<Income> getStatutoryMaternityPayById(UUID id);
 List<Income> getAllIncomeById(UUID id);
 List<Income> getFrequency();
}
