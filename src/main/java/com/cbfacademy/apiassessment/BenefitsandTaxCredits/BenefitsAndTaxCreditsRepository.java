package com.cbfacademy.apiassessment.BenefitsandTaxCredits;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.ListCrudRepository;

import com.cbfacademy.apiassessment.User.User;


public interface BenefitsAndTaxCreditsRepository extends ListCrudRepository<BenefitsAndTaxCredits, UUID> {

List<BenefitsAndTaxCredits> searchByUser(String name);
List<User> searchById(UUID id);
List<BenefitsAndTaxCredits> getBenefitsAndTaxCreditsById(UUID id);
List<BenefitsAndTaxCredits> getAllBenefitsAndTaxCreditsById(UUID id);
List<BenefitsAndTaxCredits> getJobSeekersAllowanceById(UUID id);
List<BenefitsAndTaxCredits> getWorkingTaxCreditById(UUID id);
List<BenefitsAndTaxCredits> getChildTaxCreditById(UUID id);
List<BenefitsAndTaxCredits> getChildBenefitById(UUID id);
List<BenefitsAndTaxCredits> getEmploymentSupportAllowanceById(UUID id);
List<BenefitsAndTaxCredits> getUniversalCreditById(UUID id);
List<BenefitsAndTaxCredits> getDisabilityAllowanceById(UUID id);
List<BenefitsAndTaxCredits> getAttendanceAllowanceById(UUID id);
List<BenefitsAndTaxCredits> getCarersAllowanceById(UUID id);
List<BenefitsAndTaxCredits> getHousingBenefitById(UUID id);
List<BenefitsAndTaxCredits> getMaternityAllowanceById(UUID id);
List<BenefitsAndTaxCredits> getFrequency();
}
