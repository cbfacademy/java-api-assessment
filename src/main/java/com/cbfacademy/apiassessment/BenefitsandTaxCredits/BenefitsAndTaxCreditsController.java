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
@RequestMapping("/benefitsAnTaxCredits")
public class BenefitsAndTaxCreditsController {
BenefitsAndTaxCreditsService benefitsAndTaxCreditsService;

public BenefitsAndTaxCreditsController(BenefitsAndTaxCreditsService benefitsAndTaxCreditsService) {
    this.benefitsAndTaxCreditsService = benefitsAndTaxCreditsService;
}

@GetMapping("/{id}")
public List<BenefitsAndTaxCredits> getAllBenefitsAndTaxCreditsById(@PathVariable UUID id, @RequestBody BenefitsAndTaxCredits benefitsAndTaxCredits ) throws NoSuchElementException{
        return benefitsAndTaxCreditsService.getAllBenefitsAndTaxCreditsById(id);
}

@GetMapping("/{id}")
    public List<BenefitsAndTaxCredits> getBenefitsAndTaxCreditsById(@PathVariable UUID id, @RequestBody BenefitsAndTaxCredits benefitsAndTaxCredits )throws NoSuchElementException {
        return benefitsAndTaxCreditsService.getBenefitsAndTaxCreditsById(id);
    }
//starts her
    @GetMapping("jobseekers-allowance/{id}")
    public List<BenefitsAndTaxCredits> getJobSeekersAllowanceById(@PathVariable UUID id, @RequestBody BenefitsAndTaxCredits benefitsAndTaxCredits )throws NoSuchElementException {
        return benefitsAndTaxCreditsService.getJobSeekersAllowanceById(id);
    }

    @GetMapping("working-tax-credit/{id}")
    public List<BenefitsAndTaxCredits> getWorkingTaxCreditById(@PathVariable UUID id, @RequestBody BenefitsAndTaxCredits benefitsAndTaxCredits )throws NoSuchElementException {
        return benefitsAndTaxCreditsService.getWorkingTaxCreditById(id);
    }

    @GetMapping("child-tax-credit/{id}")
    public List<BenefitsAndTaxCredits> getChildTaxCreditById(@PathVariable UUID id, @RequestBody BenefitsAndTaxCredits benefitsAndTaxCredits )throws NoSuchElementException {
        return benefitsAndTaxCreditsService.getChildTaxCreditById(id);
    }
    

    @GetMapping("child-benefit/{id}")
    public List<BenefitsAndTaxCredits> getChildBenefitById(@PathVariable UUID id, @RequestBody BenefitsAndTaxCredits benefitsAndTaxCredits )throws NoSuchElementException {
        return benefitsAndTaxCreditsService.getChildBenefitById(id);
    }

    @GetMapping("emplyomenet-support-allowance/{id}")
    public List<BenefitsAndTaxCredits> getEmploymentSupportAllowanceById(@PathVariable UUID id, @RequestBody BenefitsAndTaxCredits benefitsAndTaxCredits )throws NoSuchElementException {
        return benefitsAndTaxCreditsService.getEmploymentSupportAllowanceById(id);
    }

    @GetMapping("universal-credit/{id}")
    public List<BenefitsAndTaxCredits> getUniversalCreditById(@PathVariable UUID id, @RequestBody BenefitsAndTaxCredits benefitsAndTaxCredits )throws NoSuchElementException {
        return benefitsAndTaxCreditsService.getUniversalCreditById(id);
    }

    @GetMapping("disability-allowance/{id}")
    public List<BenefitsAndTaxCredits> getDisabilityAllowanceById(@PathVariable UUID id, @RequestBody BenefitsAndTaxCredits benefitsAndTaxCredits )throws NoSuchElementException {
        return benefitsAndTaxCreditsService.getDisabilityAllowanceById(id);
    }

    @GetMapping("attendance-allowance/{id}")
    public List<BenefitsAndTaxCredits> getAttendanceAllowanceById(@PathVariable UUID id, @RequestBody BenefitsAndTaxCredits benefitsAndTaxCredits )throws NoSuchElementException {
        return benefitsAndTaxCreditsService.getAttendanceAllowanceById(id);
    }


    @GetMapping("carers-allowance/{id}")
    public List<BenefitsAndTaxCredits> getCarersAllowanceById(@PathVariable UUID id, @RequestBody BenefitsAndTaxCredits benefitsAndTaxCredits )throws NoSuchElementException {
        return benefitsAndTaxCreditsService.getCarersAllowanceById(id);
    }

    @GetMapping("housing-benefit/{id}")
    public List<BenefitsAndTaxCredits> getHousingBenefitById(@PathVariable UUID id, @RequestBody BenefitsAndTaxCredits benefitsAndTaxCredits )throws NoSuchElementException {
        return benefitsAndTaxCreditsService.getHousingBenefitById(id);
    }


    @GetMapping("maternity-allowance/{id}")
    public List<BenefitsAndTaxCredits> getMaternityAllowanceById(@PathVariable UUID id, @RequestBody BenefitsAndTaxCredits benefitsAndTaxCredits )throws NoSuchElementException {
        return benefitsAndTaxCreditsService.getMaternityAllowanceById(id);
    }
@GetMapping("frequency/{id}")
public List<BenefitsAndTaxCredits> getFrequency(@PathVariable UUID id, @RequestBody BenefitsAndTaxCredits benefitsAndTaxCredits) throws NoSuchElementException{
        return benefitsAndTaxCreditsService.getFrequency();
}
               
 @PostMapping
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
