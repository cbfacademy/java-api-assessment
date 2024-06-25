package com.cbfacademy.apiassessment.User;


import java.math.BigDecimal;
import java.util.ArrayList;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

import org.springframework.context.annotation.Lazy;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;

@Service
@Lazy
public class UserService {

public final UserRepository userRepository;


public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
}

public Optional<User> findById(UUID id) throws NoSuchElementException {
    return userRepository.findById(id);
           
}
 public BigDecimal getUserPercentage(UUID id) throws NoSuchElementException {
    return userRepository.findById(id)
    .map(User::getUserPercentage)
    .orElseThrow(() -> new NoSuchElementException("User not found with id: " + id));
}
    
User createUser(User user) throws IllegalArgumentException, OptimisticLockingFailureException {
        return userRepository.save(user);
        
    }

 User updateUser(UUID id, User updatedUser) throws NoSuchElementException, IllegalArgumentException{
        User user = userRepository.findById(id).orElseThrow(() -> new NoSuchElementException("User not found"));
      
        
        user.setName(updatedUser.getName());
        user.setEmail(updatedUser.getEmail());
        user.setUserPercentage(updatedUser.getUserPercentage());

        user.setIncome(updatedUser.getIncome() != null ? user.getIncome(): new ArrayList<>());
        user.setBenefitsAndTaxCredits(updatedUser.getBenefitsaAndTaxCredits()!= null ? user.getBenefitsaAndTaxCredits(): new ArrayList<>());
        user.setPension(updatedUser.getPensions()!= null ? user.getPensions(): new ArrayList<>());
        user.setOtherIncome(updatedUser.getOtherIncome()!= null ? user.getOtherIncome(): new ArrayList<>());
        user.setBills(updatedUser.getBills()!= null ? user.getBills(): new ArrayList<>());
        user.setLeisure(updatedUser.getLeisure()!= null ? user.getLeisure(): new ArrayList<>());
    
    return userRepository.save(updatedUser);
}

//delete left to do. Also fix find by id
void deleteUserBy(UUID id) throws NoSuchElementException {
    if(!userRepository.existsById(id)) {
        throw new NoSuchElementException("Id Not Found");
    }
        userRepository.deleteById(id);
}
}

