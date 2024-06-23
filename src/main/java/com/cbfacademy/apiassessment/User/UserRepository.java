package com.cbfacademy.apiassessment.User;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.ListCrudRepository;

public interface UserRepository extends ListCrudRepository<User, UUID> {

       List<User> searchByUser(String name);
       List<User> searchById(UUID id);
       List<User> searchByEmail(String name);
       List<User> findByUserPercentage(BigDecimal userPercentage);
     
}
