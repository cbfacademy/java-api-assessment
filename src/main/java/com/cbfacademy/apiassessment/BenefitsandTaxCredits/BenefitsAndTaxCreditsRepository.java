package com.cbfacademy.apiassessment.BenefitsandTaxCredits;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import com.cbfacademy.apiassessment.User.User;

@Repository
public interface BenefitsAndTaxCreditsRepository extends ListCrudRepository<BenefitsAndTaxCredits, UUID> {

List<User> searchById(UUID id);
List<BenefitsAndTaxCredits> findBenefitsAndTaxCreditsById(UUID id);
List<BenefitsAndTaxCredits> findJobSeekersAllowanceById(UUID id);
List<BenefitsAndTaxCredits> findWorkingTaxCreditById(UUID id);
List<BenefitsAndTaxCredits> findChildTaxCreditById(UUID id);
List<BenefitsAndTaxCredits> findChildBenefitById(UUID id);
List<BenefitsAndTaxCredits> findEmploymentSupportAllowanceById(UUID id);
List<BenefitsAndTaxCredits> findUniversalCreditById(UUID id);
List<BenefitsAndTaxCredits> findDisabilityAllowanceById(UUID id);
List<BenefitsAndTaxCredits> findAttendanceAllowanceById(UUID id);
List<BenefitsAndTaxCredits> findCarersAllowanceById(UUID id);
List<BenefitsAndTaxCredits> findHousingBenefitById(UUID id);
List<BenefitsAndTaxCredits> findMaternityAllowanceById(UUID id);
List<BenefitsAndTaxCredits> findByFrequency(String frequency);
}
