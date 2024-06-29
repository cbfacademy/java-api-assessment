package com.cbfacademy.apiassessment.BenefitsandTaxCredits;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/benefitsAndTaxCredits")
public class BenefitsAndTaxCreditsController {
BenefitsAndTaxCreditsService benefitsAndTaxCreditsService;

public BenefitsAndTaxCreditsController(BenefitsAndTaxCreditsService benefitsAndTaxCreditsService) {
    this.benefitsAndTaxCreditsService = benefitsAndTaxCreditsService;
}

    @GetMapping("/{id}")
    public List<BenefitsAndTaxCredits> findBenefitsAndTaxCreditsById(@PathVariable UUID id )throws NoSuchElementException {
        return benefitsAndTaxCreditsService.findBenefitsAndTaxCreditsById(id);
    }

    @GetMapping("jobseekers-allowance/{id}")
    public List<BenefitsAndTaxCredits> findJobSeekersAllowanceById(@PathVariable UUID id )throws NoSuchElementException {
        return benefitsAndTaxCreditsService.findJobSeekersAllowanceById(id);
    }

    @GetMapping("working-tax-credit/{id}")
    public List<BenefitsAndTaxCredits> findWorkingTaxCreditById(@PathVariable UUID id)throws NoSuchElementException {
        return benefitsAndTaxCreditsService.findWorkingTaxCreditById(id);
    }

    @GetMapping("child-tax-credit/{id}")
    public List<BenefitsAndTaxCredits> findChildTaxCreditById(@PathVariable UUID id )throws NoSuchElementException {
        return benefitsAndTaxCreditsService.findChildTaxCreditById(id);
    }
    

    @GetMapping("child-benefit/{id}")
    public List<BenefitsAndTaxCredits> findChildBenefitById(@PathVariable UUID id)throws NoSuchElementException {
        return benefitsAndTaxCreditsService.findChildBenefitById(id);
    }

    @GetMapping("emplyomenet-support-allowance/{id}")
    public List<BenefitsAndTaxCredits> findEmploymentSupportAllowanceById(@PathVariable UUID id)throws NoSuchElementException {
        return benefitsAndTaxCreditsService.findEmploymentSupportAllowanceById(id);
    }

    @GetMapping("universal-credit/{id}")
    public List<BenefitsAndTaxCredits> findUniversalCreditById(@PathVariable UUID id)throws NoSuchElementException {
        return benefitsAndTaxCreditsService.findUniversalCreditById(id);
    }

    @GetMapping("disability-allowance/{id}")
    public List<BenefitsAndTaxCredits> findDisabilityAllowanceById(@PathVariable UUID id)throws NoSuchElementException {
        return benefitsAndTaxCreditsService.findDisabilityAllowanceById(id);
    }

    @GetMapping("attendance-allowance/{id}")
    public List<BenefitsAndTaxCredits> findAttendanceAllowanceById(@PathVariable UUID id)throws NoSuchElementException {
        return benefitsAndTaxCreditsService.findAttendanceAllowanceById(id);
    }


    @GetMapping("carers-allowance/{id}")
    public List<BenefitsAndTaxCredits> findCarersAllowanceById(@PathVariable UUID id)throws NoSuchElementException {
        return benefitsAndTaxCreditsService.findCarersAllowanceById(id);
    }

    @GetMapping("housing-benefit/{id}")
    public List<BenefitsAndTaxCredits> findHousingBenefitById(@PathVariable UUID id)throws NoSuchElementException {
        return benefitsAndTaxCreditsService.findHousingBenefitById(id);
    }


    @GetMapping("maternity-allowance/{id}")
    public List<BenefitsAndTaxCredits> findMaternityAllowanceById(@PathVariable UUID id)throws NoSuchElementException {
        return benefitsAndTaxCreditsService.findMaternityAllowanceById(id);
    }
@GetMapping("frequency/{id}")
public List<BenefitsAndTaxCredits> findFrequency(@PathVariable UUID id, String frequency) throws NoSuchElementException{
        return benefitsAndTaxCreditsService.findFrequency(frequency);
}
               
 @PostMapping("/{id}")
    public ResponseEntity<BenefitsAndTaxCredits> createBenefitsAndTaxCredits(@RequestBody BenefitsAndTaxCredits benefitsAndTaxCredits) {
        try {
            BenefitsAndTaxCredits createdBenefitsAndTaxCredits = benefitsAndTaxCreditsService.createBenefitsAndTaxCredits(benefitsAndTaxCredits);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdBenefitsAndTaxCredits);
        } catch (RuntimeException exception) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage(), exception);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<BenefitsAndTaxCredits> updateBenefitsAndTaxCredits(@PathVariable UUID id, @RequestBody BenefitsAndTaxCredits benefitsAndTaxCredits) {
        try {
            BenefitsAndTaxCredits updatedBenefitsAndTaxCredits = benefitsAndTaxCreditsService.updateBenefitsAndTaxCredits(id, benefitsAndTaxCredits);
            return ResponseEntity.ok(updatedBenefitsAndTaxCredits);
        } catch (NoSuchElementException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Benefit not found", exception);
        } catch (RuntimeException exception) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage(), exception);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBenefitsAndTaxCredits(@PathVariable UUID id) {
        try {
            benefitsAndTaxCreditsService.deleteBenefitsAndTaxCreditsById(id);
            return ResponseEntity.noContent().build();
        } catch (NoSuchElementException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Benefit not found", exception);
        } catch (RuntimeException exception) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage(), exception);
        }
    }

}
