package com.cbfacademy.apiassessment.User;

import java.math.BigDecimal;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/user")
public class UserController {
UserService userService;

public UserController(UserService userService){
    this.userService = userService;
}

@GetMapping("/{id}")
public Optional<User> findById(@PathVariable UUID id)throws NoSuchElementException {
    return userService.getById(id);
}


@GetMapping("get-percentage/{id}")
public BigDecimal getUserPercentage(@PathVariable UUID id) {
    return userService.getUserPercentage(id);
}


@PostMapping
public ResponseEntity<User> createUser(@RequestBody User user){
    try {
        User createdUser = userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);    
    } catch (RuntimeException exception) {
        throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage(), exception);
    }
}

@PutMapping("/{id}")  
public User updatedUser(@PathVariable UUID id, @RequestBody User user) {
    try {
        user = userService.updateUser(id, user);
        return user;
    } catch (NoSuchElementException exception) {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User Not Found", exception);
    } catch (RuntimeException exception) {
        throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage(), exception);
    } 
}

@DeleteMapping("/{id}")
public ResponseEntity<?> deleteUserById(@PathVariable UUID id) {
    try{
        userService.deleteUserBy(id);
        return ResponseEntity.noContent().build();
    } catch (NoSuchElementException exception) {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User Not Found", exception);
    } catch (RuntimeException exception) {
        throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage(), exception);
    }

}
}
