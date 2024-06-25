package com.cbfacademy.apiassessment.Income;


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
@Table(name = "income")
public class Income {
    
@Id
@GeneratedValue(strategy = GenerationType.UUID)
@Column(name = "income_id")
private UUID id;



@ManyToOne
@JoinColumn(name = "user_id", referencedColumnName = "id")

private User user;

private BigDecimal salaryAfterTaxesById; 
private BigDecimal selfEmploymentIncomeById;
private BigDecimal statutorySickPayById;
private BigDecimal statutoryMaternityPayById;
private String frequency;


//Constructors: default and parameterized
public Income(){
this(null, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, "monthly");
}

public Income(User user, BigDecimal salaryAfterTaxesById, BigDecimal selfEmploymentIncomeById, BigDecimal statutorySickPayById, BigDecimal statutoryMaternityPayById, String frequency) {
    this.user = user;
    this.salaryAfterTaxesById = salaryAfterTaxesById;
    this.selfEmploymentIncomeById = selfEmploymentIncomeById;
    this.statutorySickPayById = statutorySickPayById;
    this.statutoryMaternityPayById = statutoryMaternityPayById;
    this.frequency = frequency;
}

//Getters and setters
public UUID getId() {
    return id;
}

public User getUser(){
    return user;
}

public void setUser (User user) {
    this.user = user;
}

public BigDecimal getSalaryAfterTaxesById() {
    return salaryAfterTaxesById;
}

public void setSalaryAfterTaxesById (BigDecimal salaryAfterTaxesById) {
    this.salaryAfterTaxesById = salaryAfterTaxesById;
}

public BigDecimal getSelfEmploymentIncomeById() {
    return selfEmploymentIncomeById;
}

public void setSelfEmploymentIncomeById(BigDecimal selfEmploymentIncomeById) {
    this.selfEmploymentIncomeById = selfEmploymentIncomeById;
}

public BigDecimal getStatutorySickPayById() {
    return statutorySickPayById;
}

public void setStatutorySickPayById(BigDecimal statutorySickPayById) {
    this.statutorySickPayById = statutorySickPayById;
}

public BigDecimal getStatutoryMaternityPayById() {
    return statutoryMaternityPayById;
}

public void setStatutoryMaternityPayById(BigDecimal statutoryMaternityPayById) {
    this.statutoryMaternityPayById = statutoryMaternityPayById;
}

public String getFrequency() {
    return frequency;
}

public void setFrequency(String frequency) {
    this.frequency = frequency;
}

}





