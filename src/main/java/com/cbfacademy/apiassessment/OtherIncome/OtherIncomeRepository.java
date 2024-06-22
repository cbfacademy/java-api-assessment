package com.cbfacademy.apiassessment.OtherIncome;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.ListCrudRepository;


import com.cbfacademy.apiassessment.User.User;

public interface OtherIncomeRepository extends ListCrudRepository<OtherIncome, UUID> {

List<OtherIncome> searchByUser(String name);
List<User> searchById(UUID id);
List<OtherIncome> getOtherIncomeById(UUID id);
List<OtherIncome> getAllOtherIncomeById(UUID id);
List<OtherIncome> getRentalIncomeById(UUID id);
List<OtherIncome> getInvestmentIncomeById(UUID id);
List<OtherIncome> getFrequency();

}
