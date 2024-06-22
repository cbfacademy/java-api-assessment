package com.cbfacademy.apiassessment.Bills;

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
@Table(name = "bills")
public class Bills {
@Id
@GeneratedValue(strategy = GenerationType.UUID)
@Column(name = "bills_id")
private final UUID id;

@ManyToOne
@JoinColumn(name = "user_id", referencedColumnName = "id")
private User user;

private BigDecimal rentById;
private BigDecimal mortgageById; 
private BigDecimal mortgageEndowmentById;
private BigDecimal councilTaxById;
private BigDecimal insuranceById;
private BigDecimal utilitiesById;
private BigDecimal groceriesById;
private String frequency;


//Constructors: default and parameterized
public Bills() {
    this(null, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO,
         BigDecimal.ZERO, "monthly");
}

public Bills(User user, BigDecimal rentById, BigDecimal mortgageById, BigDecimal mortgageEndowmentById, BigDecimal councilTaxById,
        BigDecimal insuranceById, BigDecimal utilitiesById, BigDecimal groceriesById, String frequency) {
    this.id = UUID.randomUUID();
    this.user = user;
    this.rentById = rentById;
    this.mortgageById = mortgageById;
    this.mortgageEndowmentById = mortgageEndowmentById;
    this.councilTaxById = councilTaxById;
    this.insuranceById = insuranceById;
    this.utilitiesById = utilitiesById;
    this.groceriesById = groceriesById;
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
public BigDecimal getRentById() {
    return rentById;
}

public void setRentById(BigDecimal rentById) {
    this.rentById = rentById;
}

public BigDecimal getMortgageById() {
    return mortgageById;
}

public void setMortgageById(BigDecimal mortgageById) {
    this.mortgageById = mortgageById;
}

public BigDecimal getMortgageEndowmentById() {
    return mortgageEndowmentById;
}

public void setMortgageEndowmentById(BigDecimal mortgageEndowmentById) {
    this.mortgageEndowmentById = mortgageEndowmentById;
}

public BigDecimal getCouncilTaxById() {
    return councilTaxById;
}

public void setCouncilTaxById(BigDecimal councilTaxById) {
    this.councilTaxById = councilTaxById;
}

public BigDecimal getInsuranceById() {
    return insuranceById;
}

public void setInsuranceById(BigDecimal insuranceById) {
    this.insuranceById = insuranceById;
}

public BigDecimal getUtilitiesById() {
    return utilitiesById;
}

public void setUtilitiesById(BigDecimal utilitiesById) {
    this.utilitiesById = utilitiesById;
}

public BigDecimal getGroceriesById() {
    return groceriesById;
}

public void setGroceriesById(BigDecimal groceriesById) {
    this.groceriesById = groceriesById;
}

public String getFrequency() {
    return frequency;
}

public void setFrequency(String frequency) {
    this.frequency = frequency;
}

}
