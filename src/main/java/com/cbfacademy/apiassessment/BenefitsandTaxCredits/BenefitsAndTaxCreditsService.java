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

public List<BenefitsAndTaxCredits> getAllBenefitsAndTaxCreditsById(UUID id)throws NoSuchElementException {
    return benefitsAndTaxCreditsRepository.getAllBenefitsAndTaxCreditsById(id);
}

public List<BenefitsAndTaxCredits> getBenefitsAndTaxCreditsById(UUID id) throws NoSuchElementException{
    return benefitsAndTaxCreditsRepository.getBenefitsAndTaxCreditsById(id);
}

public List<BenefitsAndTaxCredits> getJobSeekersAllowanceById(UUID id) throws NoSuchElementException{
    return benefitsAndTaxCreditsRepository.getJobSeekersAllowanceById(id);
}

public List<BenefitsAndTaxCredits> getWorkingTaxCreditById(UUID id) throws NoSuchElementException{
    return benefitsAndTaxCreditsRepository.getWorkingTaxCreditById(id);
}

public List<BenefitsAndTaxCredits> getChildTaxCreditById(UUID id) throws NoSuchElementException{
    return benefitsAndTaxCreditsRepository.getChildTaxCreditById(id);
}

public List<BenefitsAndTaxCredits> getChildBenefitById(UUID id) throws NoSuchElementException{
    return benefitsAndTaxCreditsRepository.getChildBenefitById(id);
}

public List<BenefitsAndTaxCredits> getEmploymentSupportAllowanceById(UUID id) throws NoSuchElementException{
    return benefitsAndTaxCreditsRepository.getEmploymentSupportAllowanceById(id);
}

public List<BenefitsAndTaxCredits> getUniversalCreditById(UUID id) throws NoSuchElementException{
    return benefitsAndTaxCreditsRepository.getUniversalCreditById(id);
}
public List<BenefitsAndTaxCredits> getDisabilityAllowanceById(UUID id) throws NoSuchElementException{
    return benefitsAndTaxCreditsRepository.getDisabilityAllowanceById(id);
}

public List<BenefitsAndTaxCredits> getAttendanceAllowanceById(UUID id) throws NoSuchElementException{
    return benefitsAndTaxCreditsRepository.getAttendanceAllowanceById(id);
}

public List<BenefitsAndTaxCredits> getCarersAllowanceById(UUID id) throws NoSuchElementException{
    return benefitsAndTaxCreditsRepository.getCarersAllowanceById(id);
}

public List<BenefitsAndTaxCredits> getHousingBenefitById(UUID id) throws NoSuchElementException{
    return benefitsAndTaxCreditsRepository.getHousingBenefitById(id);
}

public List<BenefitsAndTaxCredits> getMaternityAllowanceById(UUID id) throws NoSuchElementException{
    return benefitsAndTaxCreditsRepository.getMaternityAllowanceById(id);
}

public List<BenefitsAndTaxCredits> getFrequency() throws NoSuchElementException{
    return benefitsAndTaxCreditsRepository.getFrequency();
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

