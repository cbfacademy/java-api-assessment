package com.cbfacademy.apiassessment.BenefitsandTaxCredits;

import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;


import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;

@Service
public class BenefitsAndTaxCreditsService {
public BenefitsAndTaxCreditsRepository benefitsAndTaxCreditsRepository;

public BenefitsAndTaxCreditsService(BenefitsAndTaxCreditsRepository benefitsAndTaxCreditsRepository){
    this.benefitsAndTaxCreditsRepository = benefitsAndTaxCreditsRepository;
}

public List<BenefitsAndTaxCredits> findBenefitsAndTaxCreditsById(UUID id) throws NoSuchElementException{
    return benefitsAndTaxCreditsRepository.findBenefitsAndTaxCreditsById(id);
}

public List<BenefitsAndTaxCredits> findJobSeekersAllowanceById(UUID id) throws NoSuchElementException{
    return benefitsAndTaxCreditsRepository.findCarersAllowanceById(id);
}

public List<BenefitsAndTaxCredits> findWorkingTaxCreditById(UUID id) throws NoSuchElementException{
    return benefitsAndTaxCreditsRepository.findWorkingTaxCreditById(id);
}

public List<BenefitsAndTaxCredits> findChildTaxCreditById(UUID id) throws NoSuchElementException{
    return benefitsAndTaxCreditsRepository.findChildTaxCreditById(id);
}

public List<BenefitsAndTaxCredits> findChildBenefitById(UUID id) throws NoSuchElementException{
    return benefitsAndTaxCreditsRepository.findChildBenefitById(id);
}

public List<BenefitsAndTaxCredits> findEmploymentSupportAllowanceById(UUID id) throws NoSuchElementException{
    return benefitsAndTaxCreditsRepository.findEmploymentSupportAllowanceById(id);
}

public List<BenefitsAndTaxCredits> findUniversalCreditById(UUID id) throws NoSuchElementException{
    return benefitsAndTaxCreditsRepository.findUniversalCreditById(id);
}
public List<BenefitsAndTaxCredits> findDisabilityAllowanceById(UUID id) throws NoSuchElementException{
    return benefitsAndTaxCreditsRepository.findDisabilityAllowanceById(id);
}

public List<BenefitsAndTaxCredits> findAttendanceAllowanceById(UUID id) throws NoSuchElementException{
    return benefitsAndTaxCreditsRepository.findAttendanceAllowanceById(id);
}

public List<BenefitsAndTaxCredits> findCarersAllowanceById(UUID id) throws NoSuchElementException{
    return benefitsAndTaxCreditsRepository.findCarersAllowanceById(id);
}

public List<BenefitsAndTaxCredits> findHousingBenefitById(UUID id) throws NoSuchElementException{
    return benefitsAndTaxCreditsRepository.findHousingBenefitById(id);
}

public List<BenefitsAndTaxCredits> findMaternityAllowanceById(UUID id) throws NoSuchElementException{
    return benefitsAndTaxCreditsRepository.findMaternityAllowanceById(id);
}

public List<BenefitsAndTaxCredits> findFrequency(String frequency) throws NoSuchElementException{
    return benefitsAndTaxCreditsRepository.findByFrequency(frequency);
}

public BenefitsAndTaxCredits createBenefitsAndTaxCredits(BenefitsAndTaxCredits benefitsAndTaxCredits)
throws IllegalArgumentException, OptimisticLockingFailureException{
    return benefitsAndTaxCreditsRepository.save(benefitsAndTaxCredits);
}

BenefitsAndTaxCredits updateBenefitsAndTaxCredits(UUID id, BenefitsAndTaxCredits updatedBenefitsAndTaxCredits)
throws NoSuchElementException, IllegalArgumentException{
    BenefitsAndTaxCredits benefitsAndTaxCredits = benefitsAndTaxCreditsRepository.findById(id).orElseThrow();
    
    benefitsAndTaxCredits.setuser(updatedBenefitsAndTaxCredits.getUser());
    benefitsAndTaxCredits.setJobSeekersAllowanceById(updatedBenefitsAndTaxCredits.getJobSeekersAllowanceById()!= null ? updatedBenefitsAndTaxCredits.getJobSeekersAllowanceById() : BigDecimal.ZERO);
    benefitsAndTaxCredits.setWorkingTaxCreditById(updatedBenefitsAndTaxCredits.getWorkingTaxCreditById()!= null ? updatedBenefitsAndTaxCredits.getWorkingTaxCreditById() : BigDecimal.ZERO);
    benefitsAndTaxCredits.setChildTaxCreditById(updatedBenefitsAndTaxCredits.getChildTaxCreditById()!= null ? updatedBenefitsAndTaxCredits.getChildTaxCreditById() : BigDecimal.ZERO);
    benefitsAndTaxCredits.setChildBenefitById(updatedBenefitsAndTaxCredits.getChildBenefitById()!= null ? updatedBenefitsAndTaxCredits.getChildBenefitById() : BigDecimal.ZERO);
    benefitsAndTaxCredits.setEmploymentSupportAllowanceById(updatedBenefitsAndTaxCredits.getEmploymentSupportAllowanceById()!= null ? updatedBenefitsAndTaxCredits.getEmploymentSupportAllowanceById() : BigDecimal.ZERO);
    benefitsAndTaxCredits.setUniversalCreditById(updatedBenefitsAndTaxCredits.getUniversalCreditById()!= null ? updatedBenefitsAndTaxCredits.getUniversalCreditById() : BigDecimal.ZERO);
    benefitsAndTaxCredits.setDisabilityAllowanceById(updatedBenefitsAndTaxCredits.getDisabilityAllowanceById()!= null ? updatedBenefitsAndTaxCredits.getDisabilityAllowanceById() : BigDecimal.ZERO);
    benefitsAndTaxCredits.setAttendanceAllowanceById(updatedBenefitsAndTaxCredits.getAttendanceAllowanceById()!= null ? updatedBenefitsAndTaxCredits.getAttendanceAllowanceById() : BigDecimal.ZERO);
    benefitsAndTaxCredits.setCarersAllowanceById(updatedBenefitsAndTaxCredits.getCarersAllowanceById()!= null ? updatedBenefitsAndTaxCredits.getCarersAllowanceById() : BigDecimal.ZERO);
    benefitsAndTaxCredits.setHousingBenefitbyId(updatedBenefitsAndTaxCredits.getHousingBenefitById()!= null ? updatedBenefitsAndTaxCredits.getHousingBenefitById() : BigDecimal.ZERO);
    benefitsAndTaxCredits.setMaternityAllowanceById(updatedBenefitsAndTaxCredits.getMaternityAllowanceById()!= null ? updatedBenefitsAndTaxCredits.getMaternityAllowanceById() : BigDecimal.ZERO);
    benefitsAndTaxCredits.setFrequency(updatedBenefitsAndTaxCredits.getFrequency());
    
    return benefitsAndTaxCreditsRepository.save(updatedBenefitsAndTaxCredits);
     
        // }).orElseThrow(() -> new NoSuchElementException("Benefit Not Found"));
    }
    
public void deleteBenefitsAndTaxCreditsById(UUID id){
    if(!benefitsAndTaxCreditsRepository.existsById(id)){
        throw new NoSuchElementException("Benefit Not Found");
    }
        benefitsAndTaxCreditsRepository.deleteById(id);
}
}

