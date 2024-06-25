package com.cbfacademy.apiassessment.OtherIncome;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.ListCrudRepository;


import com.cbfacademy.apiassessment.User.User;

public interface OtherIncomeRepository extends ListCrudRepository<OtherIncome, UUID> {
    
List<User> searchById(UUID id);
List<OtherIncome> findOtherIncomeById(UUID id);
List<OtherIncome> findRentalIncomeById(UUID id);
List<OtherIncome> findInvestmentIncomeById(UUID id);
List<OtherIncome> findByFrequency(String frequency);

}
