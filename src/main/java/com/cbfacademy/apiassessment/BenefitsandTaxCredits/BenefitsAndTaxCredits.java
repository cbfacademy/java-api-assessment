package com.cbfacademy.apiassessment.BenefitsandTaxCredits;

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
@Table(name= "benefitsAndTaxCredits")
public class BenefitsAndTaxCredits {
@Id
@GeneratedValue(strategy = GenerationType.UUID)
@Column(name = "benefitsAndTaxCredits")
private final UUID id;

@ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
    

    private BigDecimal jobSeekersAllowanceById;
    private BigDecimal workingTaxCreditById;
    private BigDecimal childTaxCreditById;
    private BigDecimal childBenefitById;
    private BigDecimal employmentSupportAllowanceById;
    private BigDecimal universalCreditById;
    private BigDecimal disabilityAllowanceById;
    private BigDecimal attendanceAllowanceById;
    private BigDecimal carersAllowanceById;
    private BigDecimal housingBenefitById;
    private BigDecimal maternityAllowanceById;
    private String frequency; 
    
   

//Constructors: default and parameterized
public BenefitsAndTaxCredits() {
this(null, BigDecimal.ZERO, BigDecimal.ZERO,BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, 
    BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, "monthly");
   
    }

 

public BenefitsAndTaxCredits(User user, BigDecimal jobSeekersAllowanceById, BigDecimal workingTaxCreditById, BigDecimal childTaxCreditById, BigDecimal childBenefitById,
BigDecimal employmentSupportAllowanceById, BigDecimal universalCreditById, BigDecimal disabilityAllowanceById, BigDecimal attendanceAllowanceById,
BigDecimal carersAllowanceById, BigDecimal housingBenefitById, BigDecimal maternityAllowanceById, String frequency) {
this.id = UUID.randomUUID();
this.user = user;
this.jobSeekersAllowanceById = jobSeekersAllowanceById;
this.workingTaxCreditById = workingTaxCreditById;
this.childTaxCreditById = childTaxCreditById;
this.childBenefitById = childBenefitById;
this.employmentSupportAllowanceById = employmentSupportAllowanceById;
this.universalCreditById = universalCreditById;
this.disabilityAllowanceById = disabilityAllowanceById;
this.attendanceAllowanceById = attendanceAllowanceById;
this.carersAllowanceById = carersAllowanceById;
this.housingBenefitById = housingBenefitById;
this.maternityAllowanceById= maternityAllowanceById;
this.frequency = frequency;

}
//id issue: I am using UUID so ? I changed it. It wanted to do this: id=null

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
public BigDecimal getJobSeekersAllowanceById() {
    return jobSeekersAllowanceById;
}

public void setJobSeekersAllowanceById(BigDecimal jobSeekersAllowanceById) {
    this.jobSeekersAllowanceById = jobSeekersAllowanceById;
}

public BigDecimal getWorkingTaxCreditById() {
    return workingTaxCreditById;
}

public void setWorkingTaxCreditById(BigDecimal workingTaxCreditById) {
    this.workingTaxCreditById = workingTaxCreditById;
}

public BigDecimal getChildTaxCreditById() {
    return childTaxCreditById;
}

public void setChildTaxCreditById(BigDecimal childTaxCreditById) {
    this.childTaxCreditById = childTaxCreditById;
}

public BigDecimal getChildBenefitById() {
    return childBenefitById;
}

public void setChildBenefitById(BigDecimal childBenefitById) {
    this.childBenefitById = childBenefitById;
}

public BigDecimal getEmploymentSupportAllowanceById() {
    return employmentSupportAllowanceById;
}

public void setEmploymentSupportAllowanceById(BigDecimal employmentSupportAllowanceById) {
    this.employmentSupportAllowanceById = employmentSupportAllowanceById;
}

public BigDecimal getUniversalCreditById() {
    return universalCreditById;
}

public void setUniversalCreditById(BigDecimal universalCreditById) {
    this.universalCreditById = universalCreditById;
}

public BigDecimal getDisabilityAllowanceById() {
    return disabilityAllowanceById;
}

public void setDisabilityAllowanceById(BigDecimal disabilityAllowanceById) {
    this.disabilityAllowanceById = disabilityAllowanceById;
}

public BigDecimal getAttendanceAllowanceById() {
    return attendanceAllowanceById;
}

public void setAttendanceAllowanceById(BigDecimal attendanceAllowanceById) {
    this.attendanceAllowanceById = attendanceAllowanceById;
}

public BigDecimal getCarersAllowanceById() {
    return carersAllowanceById;
}

public void setCarersAllowanceById(BigDecimal carersAllowanceById) {
    this.carersAllowanceById = carersAllowanceById;
}

public BigDecimal getHousingBenefitById() {
     return housingBenefitById;
}
public void setHousingBenefitbyId(BigDecimal housingBenefitById) {
    this.housingBenefitById = housingBenefitById;
}
public BigDecimal getMaternityAllowanceById() {
    return maternityAllowanceById;
}
public void setMaternityAllowanceById(BigDecimal maternityAllowanceById) {
    this.maternityAllowanceById = maternityAllowanceById;
}
public String getFrequency() {
    return frequency;
}

public void setFrequency(String frequency) {
    this.frequency = frequency;
}
}
