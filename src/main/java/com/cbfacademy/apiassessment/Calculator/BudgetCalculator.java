package com.cbfacademy.apiassessment.Calculator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;


import com.cbfacademy.apiassessment.BenefitsandTaxCredits.BenefitsAndTaxCredits;
import com.cbfacademy.apiassessment.BenefitsandTaxCredits.BenefitsAndTaxCreditsService;
import com.cbfacademy.apiassessment.Bills.Bills;
import com.cbfacademy.apiassessment.Bills.BillsService;
import com.cbfacademy.apiassessment.Income.Income;
import com.cbfacademy.apiassessment.Income.IncomeService;
import com.cbfacademy.apiassessment.Leisure.Leisure;
import com.cbfacademy.apiassessment.Leisure.LeisureService;
import com.cbfacademy.apiassessment.OtherIncome.OtherIncome;
import com.cbfacademy.apiassessment.OtherIncome.OtherIncomeService;
import com.cbfacademy.apiassessment.Pensions.Pensions;
import com.cbfacademy.apiassessment.Pensions.PensionsService;
import com.cbfacademy.apiassessment.User.User;
import com.cbfacademy.apiassessment.User.UserService;

@Component

public class BudgetCalculator {

private final IncomeService incomeService;
private final BenefitsAndTaxCreditsService benefitsAndTaxCreditsService;
private final PensionsService pensionsService;
private final OtherIncomeService otherIncomeService;
private final BillsService billsService;
private final LeisureService leisureService;
private final UserService userService;






public BudgetCalculator(IncomeService incomeService, BenefitsAndTaxCreditsService benefitsAndTaxCreditsService,
 PensionsService pensionsService, OtherIncomeService otherIncomeService, BillsService billsService,
LeisureService leisureService, @Lazy UserService userService) {
    this.incomeService = incomeService;
    this.benefitsAndTaxCreditsService = benefitsAndTaxCreditsService;
    this.pensionsService = pensionsService;
    this.otherIncomeService = otherIncomeService;
    this.billsService = billsService;
    this.leisureService = leisureService;
    this.userService = userService;
       
    }

   public Optional<User> getById(UUID userId) throws NoSuchElementException {
        return userService.getById(userId);
    }

    public BigDecimal calculatePercentageOfSavings(UUID id) {
        Optional<User> optionalUser = getById(id);
        if (optionalUser.isEmpty()) {
            throw new NoSuchElementException("User percentage not found");
        }
        User user = optionalUser.get();
        BigDecimal userPercentage = user.getUserPercentage();

        BigDecimal totalIncome = calculateTotalIncome(id);
        BigDecimal totalExpenses = calculateTotalExpenses(id);
        BigDecimal savings = calculateSavings(totalIncome, totalExpenses);

        return savings.multiply(userPercentage).divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP);
    }

    public List<BigDecimal> retrievePercentages(UUID id)  {
        List<User> users = userService.findAll();
        List<BigDecimal> percentages = new ArrayList<>();
        for (User user : users) {
            percentages.add(user.getUserPercentage());
        }
    
    return percentages;

    }

    protected BigDecimal calculateTotalIncome(UUID id) {
 
        BigDecimal totalIncome = BigDecimal.ZERO;

        totalIncome = totalIncome.add(calculateIncome(incomeService.findIncomeById(id)));
        totalIncome = totalIncome.add(calculateBenefitsAndTaxCredits(benefitsAndTaxCreditsService.findBenefitsAndTaxCreditsById(id)));
        totalIncome = totalIncome.add(calculatePensions(pensionsService.findPensionsById(id)));
        totalIncome = totalIncome.add(calculateOtherIncome(otherIncomeService.findOtherIncomeById(id)));
        
        return totalIncome;
    }

    protected BigDecimal calculateTotalExpenses(UUID id) {
        BigDecimal totalExpenses = BigDecimal.ZERO;
       
        totalExpenses = totalExpenses.add(calculateBills(billsService.findBillsById(id)));
        totalExpenses = totalExpenses.add(calculateLeisure(leisureService.findLeisureById(id)));
        
        return totalExpenses;
    }

    // methods to sum up amounts from lists

    private BigDecimal calculateIncome(List<Income> incomeList) {
        BigDecimal total = BigDecimal.ZERO;
        for (Income income : incomeList) {
            BigDecimal amount = income.getSalaryAfterTaxesById()
                    .add(income.getSelfEmploymentIncomeById())
                    .add(income.getStatutorySickPayById())
                    .add(income.getStatutoryMaternityPayById());

            // Adjusting amount based on frequency
            if (income.getFrequency().equalsIgnoreCase("annually")) {
                amount = amount.divide(BigDecimal.valueOf(12), 2, RoundingMode.HALF_UP);
            }else if (income.getFrequency().equalsIgnoreCase("monthly")) {
                amount = amount.setScale(2, RoundingMode.HALF_UP);
            }
            
            total = total.add(amount);
        }
        return total;
}

    private BigDecimal calculateBenefitsAndTaxCredits(List<BenefitsAndTaxCredits> benefitsList) {
        BigDecimal total = BigDecimal.ZERO;
        for (BenefitsAndTaxCredits benefitsAndTaxCredits : benefitsList) {
            BigDecimal amount = benefitsAndTaxCredits.getJobSeekersAllowanceById()
                    .add(benefitsAndTaxCredits.getWorkingTaxCreditById())
                    .add(benefitsAndTaxCredits.getChildTaxCreditById())
                    .add(benefitsAndTaxCredits.getChildBenefitById())
                    .add(benefitsAndTaxCredits.getEmploymentSupportAllowanceById())
                    .add(benefitsAndTaxCredits.getUniversalCreditById())
                    .add(benefitsAndTaxCredits.getDisabilityAllowanceById())
                    .add(benefitsAndTaxCredits.getAttendanceAllowanceById())
                    .add(benefitsAndTaxCredits.getCarersAllowanceById())
                    .add(benefitsAndTaxCredits.getHousingBenefitById())
                    .add(benefitsAndTaxCredits.getMaternityAllowanceById());
                   

            // Adjusting amount based on frequency
            if (benefitsAndTaxCredits.getFrequency().equalsIgnoreCase("annually")) {
                amount = amount.divide(BigDecimal.valueOf(12), 2, RoundingMode.HALF_UP);
            }else if (benefitsAndTaxCredits.getFrequency().equalsIgnoreCase("monthly")) {
                amount = amount.setScale(2, RoundingMode.HALF_UP);
            }
            
            total = total.add(amount);
        }
        return total;
    }

    private BigDecimal calculatePensions(List<Pensions> pensionsList) {
        BigDecimal total = BigDecimal.ZERO;
        for (Pensions pensions : pensionsList) {
            BigDecimal amount = pensions.getStatePensionById()
                    .add(pensions.getPrivatePensionById());

            // Adjusting amount based on frequency
            if (pensions.getFrequency().equalsIgnoreCase("annually")) {
                amount = amount.divide(BigDecimal.valueOf(12), 2, RoundingMode.HALF_UP);
            }else if (pensions.getFrequency().equalsIgnoreCase("monthly")) {
                amount = amount.setScale(2, RoundingMode.HALF_UP);
            }
            
            total = total.add(amount);
        }
        return total;
    }

    private BigDecimal calculateOtherIncome(List<OtherIncome> otherIncomeList) {
        BigDecimal total = BigDecimal.ZERO;
        for (OtherIncome otherIncome : otherIncomeList) {
            BigDecimal amount = otherIncome.getRentalIncomeById()
                    .add(otherIncome.getInvestmentIncomeById());

            // Adjusting amount based on frequency
            if (otherIncome.getFrequency().equalsIgnoreCase("annually")) {
                amount = amount.divide(BigDecimal.valueOf(12), 2, RoundingMode.HALF_UP);
            }else if (otherIncome.getFrequency().equalsIgnoreCase("monthly")) {
                amount = amount.setScale(2, RoundingMode.HALF_UP);
            }
            
            total = total.add(amount);
        }
        return total;
    }

    private BigDecimal calculateBills (List<Bills> billsList) {
        BigDecimal total = BigDecimal.ZERO;
        for (Bills bills : billsList) {
            BigDecimal amount = bills.getRentById()
                    .add(bills.getMortgageById())
                    .add(bills.getMortgageEndowmentById())
                    .add(bills.getCouncilTaxById())
                    .add(bills.getInsuranceById())
                    .add(bills.getUtilitiesById())
                    .add(bills.getGroceriesById());

            // Adjusting amount based on frequency
            if (bills.getFrequency().equalsIgnoreCase("annually")) {
                amount = amount.divide(BigDecimal.valueOf(12), 2, RoundingMode.HALF_UP);
            }else if (bills.getFrequency().equalsIgnoreCase("monthly")) {
                amount = amount.setScale(2, RoundingMode.HALF_UP);
            }
                total = total.add(amount);
        }
        return total;
    }
    

    private BigDecimal calculateLeisure(List<Leisure> leisureList) {
        BigDecimal total = BigDecimal.ZERO;
        for (Leisure leisures : leisureList) {
            BigDecimal amount = leisures.getEntertainmentById()
                    .add(leisures.getDiningOutById())
                    .add(leisures.getTravelById())
                    .add(leisures.getSportsMembershipById());

            // Adjusting amount based on frequency
            if (leisures.getFrequency().equalsIgnoreCase("annually")) {
                amount = amount.divide(BigDecimal.valueOf(12), 2, RoundingMode.HALF_UP);
            }else if (leisures.getFrequency().equalsIgnoreCase("monthly")) {
                amount = amount.setScale(2, RoundingMode.HALF_UP);
            }
            
            total = total.add(amount);
        }
        return total;
    }

    private BigDecimal calculateSavings(BigDecimal totalIncome, BigDecimal totalExpenses) {
        return totalIncome.subtract(totalExpenses);
    }

    protected BigDecimal calculatePercentageOfSavings(BigDecimal totalIncome, BigDecimal totalExpenses, BigDecimal percentage) {
        BigDecimal savings = calculateSavings(totalIncome, totalExpenses);
        if (totalIncome.compareTo(BigDecimal.ZERO) == 0) {
            return BigDecimal.ZERO;
        }
        return savings.multiply(percentage).divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP);
    }
 


    public String recommendSavings(BigDecimal totalIncome, BigDecimal totalExpenses) {
        BigDecimal savings = calculateSavings(totalIncome, totalExpenses);
        BigDecimal tenPercentSavings = calculatePercentageOfSavings(totalIncome, totalExpenses, BigDecimal.valueOf(10));
        BigDecimal fifteenPercentSavings = calculatePercentageOfSavings(totalIncome, totalExpenses, BigDecimal.valueOf(15));
        
        BigDecimal needs = totalIncome.multiply(BigDecimal.valueOf(0.50));
        BigDecimal wants = totalIncome.multiply(BigDecimal.valueOf(0.30));
        BigDecimal recommendedTwentyPercentSavings = totalIncome.multiply(BigDecimal.valueOf(0.20));
        return String.format("Based on a 50-30-20 budget, allocate:\n" +
                "50%% (%.2f) for needs,\n" +
                "30%% (%.2f) for wants,\n" +
                "20%% (%.2f) for savings." +
                "Alternatively, you can save:\n" +
                "10%% of your savings: %.2f\n" +
                "15%% of your savings: %.2f",
                 needs, wants, recommendedTwentyPercentSavings, savings, tenPercentSavings, fifteenPercentSavings);
    }

 
}
      
     






 // 1# BigDecimal totalIncome = calculateTotalIncome(id);
    // BigDecimal totalExpenses = calculateTotalExpenses(id);
   
    // BigDecimal tenPercentSavings = calculatePercentageOfSavings(totalIncome, totalExpenses, BigDecimal.valueOf(10));
    // BigDecimal fifteenPercentSavings = calculatePercentageOfSavings(totalIncome, totalExpenses, BigDecimal.valueOf(15));
    // BigDecimal recommendedTwentyPercentSavings = calculatePercentageOfSavings(totalIncome, totalExpenses, BigDecimal.valueOf(20));

    // percentages.add(tenPercentSavings);
    // percentages.add(fifteenPercentSavings);
    // percentages.add(recommendedTwentyPercentSavings);


    //  2# public BigDecimal calculateSavingsByUsersPercentage(UUID id,Optional<User> optionalUser, BigDecimal userPercentage) {
        
    //     BigDecimal totalIncome = calculateTotalIncome(id);
    //     BigDecimal totalExpenses = calculateTotalExpenses(id);
    //     BigDecimal savings = calculateSavings(totalIncome, totalExpenses);
   

    //     return savings.multiply(userPercentage).divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP);
    
    // }

    // methods to sum up amounts from lists