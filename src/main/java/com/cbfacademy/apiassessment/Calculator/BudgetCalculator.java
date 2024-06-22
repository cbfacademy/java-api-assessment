package com.cbfacademy.apiassessment.Calculator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.cbfacademy.apiassessment.Algorithm.QuickSortAlgorithm;
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


public class BudgetCalculator {
private final IncomeService incomeService;
private final BenefitsAndTaxCreditsService benefitsAndTaxCreditsService;
private final PensionsService pensionsService;
private final OtherIncomeService otherIncomeService;
private final BillsService billsService;
private final LeisureService leisureService;
private final UUID id;


public BudgetCalculator(IncomeService incomeService, BenefitsAndTaxCreditsService benefitsAndTaxCreditsService,
 PensionsService pensionsService, OtherIncomeService otherIncomeService, BillsService billsService,
LeisureService leisureService, UUID id) {
        this.id = UUID.randomUUID();
        this.incomeService = incomeService;
        this.benefitsAndTaxCreditsService = benefitsAndTaxCreditsService;
        this.pensionsService = pensionsService;
        this.otherIncomeService = otherIncomeService;
        this.billsService = billsService;
        this.leisureService = leisureService;
       
    }

    public List<BigDecimal> retrievePercentages() {
        List<BigDecimal> percentages = new ArrayList<>();

    BigDecimal totalIncome = calculateTotalIncome();
    BigDecimal totalExpenses = calculateTotalExpenses();
   
    BigDecimal tenPercentSavings = calculatePercentageOfSavings(totalIncome, totalExpenses, BigDecimal.valueOf(10));
    BigDecimal fifteenPercentSavings = calculatePercentageOfSavings(totalIncome, totalExpenses, BigDecimal.valueOf(15));
    BigDecimal recommendedTwentyPercentSavings = calculatePercentageOfSavings(totalIncome, totalExpenses, BigDecimal.valueOf(20));

    percentages.add(tenPercentSavings);
    percentages.add(fifteenPercentSavings);
    percentages.add(recommendedTwentyPercentSavings);

    QuickSortAlgorithm.sortDescending(percentages, 0, percentages.size() - 1);


        return percentages;
    }
        

    public BigDecimal calculateTotalIncome() {
        BigDecimal totalIncome = BigDecimal.ZERO;

        totalIncome = totalIncome.add(calculateIncome(incomeService.getAllIncomeById(id)));
        totalIncome = totalIncome.add(calculateBenefitsAndTaxCredits(benefitsAndTaxCreditsService.getAllBenefitsAndTaxCreditsById(id)));
        totalIncome = totalIncome.add(calculatePensions(pensionsService.getAllPensionsById(id)));
        totalIncome = totalIncome.add(calculateOtherIncome(otherIncomeService.getAllOtherIncomeById(id)));
        return totalIncome;
    }

    public BigDecimal calculateTotalExpenses() {
        BigDecimal totalExpenses = BigDecimal.ZERO;
        totalExpenses = totalExpenses.add(calculateBills(billsService.getAllBillsById(id)));
        totalExpenses = totalExpenses.add(calculateLeisure(leisureService.getAllLeisureById(id)));
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

    public BigDecimal calculateSavings(BigDecimal totalIncome, BigDecimal totalExpenses) {
        return totalIncome.subtract(totalExpenses);
    }

    public BigDecimal calculateSavingsPercentage(BigDecimal totalIncome, BigDecimal totalExpenses) {
        BigDecimal savings = calculateSavings(totalIncome, totalExpenses);
        if (totalIncome.compareTo(BigDecimal.ZERO) == 0) {
            return BigDecimal.ZERO;
        }
        return savings.divide(totalIncome, 2, RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(100));
    }

    public BigDecimal calculatePercentageOfSavings(BigDecimal totalIncome, BigDecimal totalExpenses, BigDecimal percentage) {
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
      
     





//  return TotalIncome(incomes, benefitsAndTaxCredits, pensions, otherIncomes);


        
    

    





















    // public BigDecimal calculateTotalBills(UUID id) {
    
    // public BigDecimal calculateSavings(BigDecimal totalIncome, BigDecimal totalBills, BigDecimal savingsPercentage) {
    //     BigDecimal totalExpenses = totalBills;
    //     BigDecimal remainingIncome = totalIncome.subtract(totalExpenses);
    //     return remainingIncome.multiply(savingsPercentage.divide(BigDecimal.valueOf(100)));
    // }

    // public String recommendSavings(BigDecimal totalIncome) {
    //     BigDecimal needs = totalIncome.multiply(BigDecimal.valueOf(0.50));
    //     BigDecimal wants = totalIncome.multiply(BigDecimal.valueOf(0.30));
    //     BigDecimal savings = totalIncome.multiply(BigDecimal.valueOf(0.20));
    //     return String.format("Based on a 50-30-20 budget, allocate:\n" +
    //             "50%% (%.2f) for needs,\n" +
    //             "30%% (%.2f) for wants,\n" +
    //             "20%% (%.2f) for savings.", needs, wants, savings);
    // }


//    List<Income> incomes, 
// List<BenefitsAndTaxCredits> benefitsAndTaxCredits, List<Pensions> pension, List<OtherIncome> otherIncome){
// BigDecimal totalIncome = BigDecimal.ZERO;

// if(incomes != null) {
//     totalIncome = totalIncome.add(incomes.stream()
//             .map(income -> income.getFrequency().equalsIgnoreCase("annually") ? income.getIncomeById().divide(BigDecimal.valueOf(12),RoundingMode.HALF_UP) : BigDecimal.valueOf(income.getAmount())
//             .reduce(BigDecimal.ZERO, BigDecimal::add)));
// }
// totalIncome = totalIncome.add(Income.stream()
//             .map(income -> income.getFrequency().equalsIgnoreCase("annually") ? BigDecimal.valueOf(income.getAmount()). divide(BigDecimal.valueOf(12),2, RoundingMode.HALF_UP) : BigDecimal.valueOf(income.getAmount()))
//             .reduce(BigDecimal.ZERO, BigDecimal::add));

// totalIncome = totalIncome.add(BenefitsAndTaxCredits.stream()
//              .map(benefitsAndTaxCredits -> benefitsAndTaxCredits.getFrequency().equalsIgnoreCase("annually") ? BigDecimal.valueOf(income.getAmount()) .divide(BigDecimal.valueOf(12), 2, RoundingMode.HALF_UP) : BigDecimal.valueOf(income.getAmount()))                   
//              .reduce(BigDecimal.ZERO, BigDecimal::add));

// totalIncome = totalIncome.add(Pensions.stream()
//             .map(pension -> pension.getFrequency().equalsIgnoreCase("annually")? BigDecimal.valueOf(pension.getAmount()).divide(BigDecimal.valueOf(12), 2, RoundingMode.HALF_UP) : BigDecimal.valueOf(income.getAmount())))
//             .reduce(BigDecimal.ZERO, BigDecimal::add);


// totalIncome = totalIncome.add(OtherIncome.stream()
//             .map(otherIncme -> otherIncome.getFrequency().equalsIgnoreCase("annually")? BigDecimal.valueOf(otherIncome.getAmount()).divide(BigDecimal.valueOf(12), 2, RoundingMode.HALF_UP) : BigDecimal.valueOf(otherIncome.getAmount()))
//             .reduce(BigDecimal.ZERO, BigDecimal::add));



// return totalIncome;
// }



//wrote down in notes what to do next for streams 
//I'll come back for this and the test once I finish the controllers and services