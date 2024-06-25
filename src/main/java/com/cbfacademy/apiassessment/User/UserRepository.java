package com.cbfacademy.apiassessment.User;

import java.math.BigDecimal;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



@Repository
public interface UserRepository extends ListCrudRepository<User, UUID> {

       // List<User> findAllById(UUID id);
        Optional<User> findById (UUID id);
       //  Optional<User> findUserPercentage(UUID id);
        @Query("SELECT u.userPercentage FROM User u WHERE u.id = :id")
        Optional<BigDecimal> findUserPercentageById(@Param("id") UUID id);
     
}
