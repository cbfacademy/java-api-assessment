package com.cbfacademy.apiassessment.Bills;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import com.cbfacademy.apiassessment.User.User;

@Repository
public interface BillsRepository extends ListCrudRepository<Bills, UUID> {


List<User> searchById(UUID id);;
List<Bills> findBillsById(UUID id);
List<Bills> findRentById(UUID id);
List<Bills> findMortgageById(UUID id);
List<Bills> findMortgageEndowmentById(UUID id);
List<Bills> findCouncilTaxById(UUID id);
List<Bills> findInsuranceById(UUID id);
List<Bills> findUtilitiesById(UUID id);
List<Bills> findGroceriesById(UUID id);
List<Bills> findByFrequency(String frequency);


}
