package com.cbfacademy.apiassessment.User;


import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;


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

public Optional<User> getById(UUID id) throws NoSuchElementException {
    return userRepository.getById(id);
           
}

public List<User> findAll() {
    return userRepository.findAll();
}

 public BigDecimal getUserPercentage(UUID id) throws NoSuchElementException {
    return userRepository.findById(id)
    .map(User::getUserPercentage)
    .orElseThrow(() -> new NoSuchElementException("User not found with id: " + id));
}

public List<BigDecimal> getAllUsersPercentages() {
         return userRepository.findAll().stream()
                .map(User::getUserPercentage)
                .collect(Collectors.toList());
    }
    
User createUser(User user) throws IllegalArgumentException, OptimisticLockingFailureException {
        return userRepository.save(user);
        
    }

User updateUser(UUID id, User updatedUser) throws NoSuchElementException, IllegalArgumentException{
        User user = userRepository.findById(id).orElseThrow(() -> new NoSuchElementException("User not found"));
      
        
        user.setName(updatedUser.getName());
        user.setEmail(updatedUser.getEmail());
        user.setUserPercentage(updatedUser.getUserPercentage());
    
    return userRepository.save(updatedUser);
}

void deleteUserBy(UUID id) throws NoSuchElementException {
    if(!userRepository.existsById(id)) {
        throw new NoSuchElementException("Id Not Found");
    }
        userRepository.deleteById(id);
}

public void deleteAllUsers() {
    userRepository.deleteAll();
}

}

