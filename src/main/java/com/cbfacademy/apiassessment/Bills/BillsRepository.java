package com.cbfacademy.apiassessment.Bills;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.ListCrudRepository;


import com.cbfacademy.apiassessment.User.User;

public interface BillsRepository extends ListCrudRepository<Bills, UUID> {

List<Bills> searchByUser(String name);
List<User> searchById(UUID id);
List<Bills> getAllBillsById(UUID id);
List<Bills> getBillsById(UUID id);
List<Bills> getRentById(UUID id);
List<Bills> getMortgageById(UUID id);
List<Bills> getMortgageEndowmentById(UUID id);
List<Bills> getCouncilTaxById(UUID id);
List<Bills> getInsuranceById(UUID id);
List<Bills> getUtilitiesById(UUID id);
List<Bills> getGroceriesById(UUID id);
List<Bills> getFrequency();


}
