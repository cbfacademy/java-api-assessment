package com.cbfacademy.apiassessment.Leisure;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import com.cbfacademy.apiassessment.User.User;

@Repository
public interface LeisureRepository extends ListCrudRepository<Leisure, UUID> {

List<User> searchById(UUID id);
List<Leisure> findLeisureById(UUID id);
List<Leisure> findEntertainmentById(UUID id);
List<Leisure> findDiningOutById(UUID id);
List<Leisure> findTravelById(UUID id);
List<Leisure> findSportsMembershipById(UUID id);
List<Leisure> findByFrequency(String frequency);
}
