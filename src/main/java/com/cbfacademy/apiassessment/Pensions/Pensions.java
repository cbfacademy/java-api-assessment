package com.cbfacademy.apiassessment.Pensions;

import java.math.BigDecimal;
import java.util.UUID;

import com.cbfacademy.apiassessment.User.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "pensions")
public class Pensions {
@Id
@GeneratedValue(strategy = GenerationType.UUID)
@Column(name = "pensions_id")
private UUID id;

@ManyToOne
@JoinColumn(name = "user_id", referencedColumnName = "id")
private User user;

private BigDecimal statePensionById;
private BigDecimal privatePensionById;
private String frequency;

//Constructors: default and parameterized
public Pensions() {
    this(null, BigDecimal.ZERO, BigDecimal.ZERO, "monthly");
}


public Pensions(User user, BigDecimal statePensionById, BigDecimal privatePensionById, String frequency) {
    this.user = user;
    this.statePensionById = statePensionById;
    this.privatePensionById = privatePensionById;
    this.frequency = frequency;
}

//Getters and setters
public UUID getId() {
    return id;
}

public User getUser(){
    return user;
}

public void setuser (User user) {
    this.user = user;
}
public BigDecimal getStatePensionById() {
    return statePensionById;
}


public void setStatePensionById(BigDecimal statePensionById) {
    this.statePensionById = statePensionById;
}


public BigDecimal getPrivatePensionById() {
    return privatePensionById;
}


public void setPrivatePensionById(BigDecimal privatePensionById) {
    this.privatePensionById = privatePensionById;
}


public String getFrequency() {
    return frequency;
}


public void setFrequency(String frequency) {
    this.frequency = frequency;
}
}
