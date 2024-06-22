package com.cbfacademy.apiassessment.Pensions;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.ListCrudRepository;


import com.cbfacademy.apiassessment.User.User;

public interface PensionsRepository extends ListCrudRepository<Pensions, UUID> {

List<Pensions> searchByUser(String name);
List<User> searchById(UUID id);
List<Pensions> getPensionsById(UUID id);
List<Pensions> getAllPensionsById(UUID id);
List<Pensions> getStatePensionById(UUID id);
List<Pensions> getPrivatePensionById(UUID id);
List<Pensions> getFrequency();
}
