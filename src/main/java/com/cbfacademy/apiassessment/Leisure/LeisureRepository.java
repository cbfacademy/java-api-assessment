package com.cbfacademy.apiassessment.Leisure;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.ListCrudRepository;


import com.cbfacademy.apiassessment.User.User;

public interface LeisureRepository extends ListCrudRepository<Leisure, UUID> {

List<Leisure> searchByUser(String name);
List<User> searchById(UUID id);
List<Leisure> getLeisureById(UUID id);
List<Leisure> getAllLeisureById(UUID id);
List<Leisure> getEntertainmentById(UUID id);
List<Leisure> getDiningOutById(UUID id);
List<Leisure> getTravelById(UUID id);
List<Leisure> getSportsMembershipById(UUID id);
List<Leisure> getFrequency();
}
