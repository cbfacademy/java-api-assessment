package com.cbfacademy.apiassessment.Calculator;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.cbfacademy.apiassessment.Bills.Bills;
import com.cbfacademy.apiassessment.Leisure.Leisure;
import com.cbfacademy.apiassessment.OtherIncome.OtherIncome;
import com.cbfacademy.apiassessment.Pensions.Pensions;

@Component
public class BudgetRequest {

    private User user;
    private List<Income> income;
    private List<BenefitsAndTaxCredits> benefitsAndTaxCredits;
    private List<OtherIncome> otherIncome;
    private List<Pensions> pensions;
    private List<Bills> bills;
    private List<Leisure> leisure;
   
   
   
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public List<Income> getIncomeById() {
        return income;
    }
    public void setIncomeById(List<Income> income) {
        this.income = income;
    }
    public List<BenefitsAndTaxCredits> getBenefitsAndTaxCreditsById() {
        return benefitsAndTaxCredits;
    }
    public void setBenefitsAndTaxCreditsById(List<BenefitsAndTaxCredits> benefitsAndTaxCredits) {
        this.benefitsAndTaxCredits = benefitsAndTaxCredits;
    }
    public List<OtherIncome> getOtherIncomeById() {
        return otherIncome;
    }
    public void setOtherIncome(List<OtherIncome> otherIncome) {
        this.otherIncome = otherIncome;
    }
    public List<Pensions> getPensionsById() {
        return pensions;
    }
    public void setPensionsById(List<Pensions> pensions) {
        this.pensions = pensions;
    }
    public List<Bills> getBillsById() {
        return bills;
    }
    public void setBillsById(List<Bills> bills) {
        this.bills = bills;
    }
    public List<Leisure> getLeisureById() {
        return leisure;
    }
    public void setLeisureById(List<Leisure> leisure) {
        this.leisure = leisure;
    }

    
 public static class User {
   private final UUID id;
   private String name;
   private String email;
   private Instant dateTime;
   private BigDecimal userPercentage;

 
 public User() {
    this.id = UUID.randomUUID();
}

public UUID getId() {
    return id;
}
public String getName() {
    return name;
}
public void setName(String name) {
    this.name = name;
}
public String getEmail() {
    return email;
}
public void setEmail(String email) {
    this.email = email;
}
public Instant getDateTime() {
    return dateTime;
}
public void setDateTime(Instant dateTime) {
    this.dateTime = dateTime;
}
public BigDecimal getUserPercentage() {
    return userPercentage;
}
public void setUserPercentage(BigDecimal userPercentage) {
    this.userPercentage = userPercentage;
}

}


public static class Income {
    private BigDecimal salaryAfterTaxesById;
    private BigDecimal selfEmploymentIncomeById;
    private BigDecimal statutorySickPayById;
    private BigDecimal statutoryMaternityPayById;
    private String frequency;
    
    public BigDecimal getSalaryAfterTaxesById() {
        return salaryAfterTaxesById;
    }
    public void setSalaryAfterTaxesById(BigDecimal salaryAfterTaxesById) {
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

public static class BenefitsAndTaxCredits {
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

    public void setHousingBenefitById(BigDecimal housingBenefitById) {
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

public static class OtherIncome{
private BigDecimal rentalIncomeById;
private BigDecimal investmentIncomeById;
private String frequency;

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

public static class Pensions{
    private BigDecimal statePensionById;
    private BigDecimal privatePensionById;
    private String frequency;
    
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

public static class Bills{
private BigDecimal rentById;
private BigDecimal mortgageById; 
private BigDecimal mortgageEndowmentById;
private BigDecimal councilTaxById;
private BigDecimal insuranceById;
private BigDecimal utilitiesById;
private BigDecimal groceriesById;
private String frequency;

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

public static class Leisure{
private BigDecimal entertainmentById; 
private BigDecimal diningOutById;
private BigDecimal travelById;
private BigDecimal sportsMembershipById;
private String frequency;

public BigDecimal getEntertainmentById() {
    return entertainmentById;
}
public void setEntertainmentById(BigDecimal entertainmentById) {
    this.entertainmentById = entertainmentById;
}
public BigDecimal getDiningOutById() {
    return diningOutById;
}
public void setDiningOutById(BigDecimal diningOutById) {
    this.diningOutById = diningOutById;
}
public BigDecimal getTravelById() {
    return travelById;
}
public void setTravelById(BigDecimal travelById) {
    this.travelById = travelById;
}
public BigDecimal getSportsMembershipById() {
    return sportsMembershipById;
}
public void setSportsMembershipById(BigDecimal sportsMembershipById) {
    this.sportsMembershipById = sportsMembershipById;
}
public String getFrequency() {
    return frequency;
}
public void setFrequency(String frequency) {
    this.frequency = frequency;
}
}
}
}









