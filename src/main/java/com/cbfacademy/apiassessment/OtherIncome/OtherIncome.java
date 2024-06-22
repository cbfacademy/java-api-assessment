package com.cbfacademy.apiassessment.OtherIncome;

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
@Table(name = "otherincome")
public class OtherIncome {
@Id
@GeneratedValue(strategy = GenerationType.UUID)
@Column(name = "otherincome_id")
private final UUID id;

@ManyToOne
@JoinColumn(name = "user_id", referencedColumnName = "id")
private User user;

private BigDecimal rentalIncomeById;
private BigDecimal investmentIncomeById;
private String frequency;

//Constructors: default and parameterized
public OtherIncome() {
this(null, BigDecimal.ZERO, BigDecimal.ZERO, "monthly");
}


public OtherIncome(User user, BigDecimal rentalIncomeById, BigDecimal investmentIncomeById, String frequency) {
    this.id = UUID.randomUUID();
    this.user = user;
    this.rentalIncomeById = rentalIncomeById;
    this.investmentIncomeById = investmentIncomeById;
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

public BigDecimal getRentalIncomeById() {
    return rentalIncomeById;
}


public void setRentalIncomeById(BigDecimal rentalIncomeById) {
    this.rentalIncomeById = rentalIncomeById;
}


public BigDecimal getInvestmentIncomeById() {
    return investmentIncomeById;
}


public void setInvestmentIncomeById(BigDecimal investmentIncomeById) {
    this.investmentIncomeById = investmentIncomeById;
}


public String getFrequency() {
    return frequency;
}


public void setFrequency(String frequency) {
    this.frequency = frequency;
}
}
