package com.cbfacademy.apiassessment;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import com.cbfacademy.apiassessment.BenefitsandTaxCredits.BenefitsAndTaxCredits;
import com.cbfacademy.apiassessment.BenefitsandTaxCredits.BenefitsAndTaxCreditsService;
import com.cbfacademy.apiassessment.Bills.Bills;
import com.cbfacademy.apiassessment.Bills.BillsService;
import com.cbfacademy.apiassessment.Calculator.BudgetCalculator;
import com.cbfacademy.apiassessment.Income.Income;
import com.cbfacademy.apiassessment.Income.IncomeService;
import com.cbfacademy.apiassessment.Leisure.Leisure;
import com.cbfacademy.apiassessment.Leisure.LeisureService;
import com.cbfacademy.apiassessment.OtherIncome.OtherIncome;
import com.cbfacademy.apiassessment.OtherIncome.OtherIncomeService;
import com.cbfacademy.apiassessment.Pensions.Pensions;
import com.cbfacademy.apiassessment.Pensions.PensionsService;


import java.math.BigDecimal;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;


import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class QuickSortAlgorithmTest{

   
   
    private IncomeService incomeService;
    private BenefitsAndTaxCreditsService benefitsAndTaxCreditsService;
    private PensionsService pensionsService;
    private OtherIncomeService otherIncomeService;
    private BillsService billsService;
    private LeisureService leisureService;
    private BudgetCalculator budgetCalculator;
 

 @BeforeEach
    void setUp() {
        incomeService = mock(IncomeService.class);
        benefitsAndTaxCreditsService = mock(BenefitsAndTaxCreditsService.class);
        pensionsService = mock(PensionsService.class);
        otherIncomeService = mock(OtherIncomeService.class);
        billsService = mock(BillsService.class);
        leisureService = mock(LeisureService.class);
        budgetCalculator = new BudgetCalculator(incomeService, benefitsAndTaxCreditsService, pensionsService, otherIncomeService, billsService, leisureService, null);
    }

    @Test
    void testSortBudgetData() {
        IncomeService incomeService = mock(IncomeService.class);
        BenefitsAndTaxCreditsService benefitsAndTaxCreditsService = mock(BenefitsAndTaxCreditsService.class);
        PensionsService pensionsService = mock(PensionsService.class);
        OtherIncomeService otherIncomeService = mock(OtherIncomeService.class);
        BillsService billsService = mock(BillsService.class);
        LeisureService leisureService = mock(LeisureService.class);
        UUID id = UUID.randomUUID();

        
        when(incomeService.findIncomeById(id)).thenReturn(createMockIncomeList());
        when(benefitsAndTaxCreditsService.findBenefitsAndTaxCreditsById(id)).thenReturn(createMockBenefitsAndTaxCreditsList());
        when(pensionsService.findPensionsById(id)).thenReturn(createMockPensionsList());
        when(otherIncomeService.findOtherIncomeById(id)).thenReturn(createMockOtherIncomeList());
        when(billsService.findBillsById(id)).thenReturn(createMockBillsList());
        when(leisureService.findLeisureById(id)).thenReturn(createMockLeisureList());
    

        List<BigDecimal> percentages = budgetCalculator.retrievePercentages(id);
    
        List<BigDecimal> expected = List.of(
                new BigDecimal("20.00"),
                new BigDecimal("15.00"),
                new BigDecimal("10.00")
        );
       
        percentages.sort((a, b) -> b.compareTo(a));
        assertIterableEquals(expected, percentages);
    }

     private List<Income> createMockIncomeList() {
        Income income = mock(Income.class);
        when(income.getSalaryAfterTaxesById()).thenReturn(new BigDecimal("100000.00"));
        when(income.getSelfEmploymentIncomeById()).thenReturn(new BigDecimal("400.00"));
        when(income.getStatutorySickPayById()).thenReturn(new BigDecimal("100.00"));
        when(income.getStatutoryMaternityPayById()).thenReturn(new BigDecimal("100.00"));
        when(income.getFrequency()).thenReturn("monthly");
        return Arrays.asList(income);
     }
       private List<BenefitsAndTaxCredits> createMockBenefitsAndTaxCreditsList() {
        BenefitsAndTaxCredits benefitsAndTaxCredits = mock(BenefitsAndTaxCredits.class);
        when(benefitsAndTaxCredits.getJobSeekersAllowanceById()).thenReturn(new BigDecimal("0.00"));
        when(benefitsAndTaxCredits.getWorkingTaxCreditById()).thenReturn(new BigDecimal("50.00"));
        when(benefitsAndTaxCredits.getChildTaxCreditById()).thenReturn(new BigDecimal("30.00"));
        when(benefitsAndTaxCredits.getChildBenefitById()).thenReturn(new BigDecimal("20.00"));
        when(benefitsAndTaxCredits.getEmploymentSupportAllowanceById()).thenReturn(new BigDecimal("40.00"));
        when(benefitsAndTaxCredits.getUniversalCreditById()).thenReturn(new BigDecimal("00.00"));
        when(benefitsAndTaxCredits.getDisabilityAllowanceById()).thenReturn(new BigDecimal("0.00"));
        when(benefitsAndTaxCredits.getAttendanceAllowanceById()).thenReturn(new BigDecimal("80.00"));
        when(benefitsAndTaxCredits.getCarersAllowanceById()).thenReturn(new BigDecimal("90.00"));
        when(benefitsAndTaxCredits.getHousingBenefitById()).thenReturn(new BigDecimal("110.00"));
        when(benefitsAndTaxCredits.getMaternityAllowanceById()).thenReturn(new BigDecimal("130.00"));
        when(benefitsAndTaxCredits.getFrequency()).thenReturn("monthly");
        return Arrays.asList(benefitsAndTaxCredits);
    }

    private List<Pensions> createMockPensionsList() {
        Pensions pensions = mock(Pensions.class);
        when(pensions.getStatePensionById()).thenReturn(new BigDecimal("200.00"));
        when(pensions.getPrivatePensionById()).thenReturn(new BigDecimal("100.00"));
        when(pensions.getFrequency()).thenReturn("monthly");
        return Arrays.asList(pensions);
    }

    private List<OtherIncome> createMockOtherIncomeList() {
        OtherIncome otherIncome = mock(OtherIncome.class);
        when(otherIncome.getRentalIncomeById()).thenReturn(new BigDecimal("300.00"));
        when(otherIncome.getInvestmentIncomeById()).thenReturn(new BigDecimal("200.00"));
        when(otherIncome.getFrequency()).thenReturn("monthly");
        return Arrays.asList(otherIncome);
    }


   private List<Bills> createMockBillsList() {
        Bills bills = mock(Bills.class);
        when(bills.getRentById()).thenReturn(new BigDecimal("1400.00"));
        when(bills.getMortgageById()).thenReturn(new BigDecimal("500.00"));
        when(bills.getMortgageEndowmentById()).thenReturn(new BigDecimal("600.00"));
        when(bills.getCouncilTaxById()).thenReturn(new BigDecimal("100.00"));
        when(bills.getInsuranceById()).thenReturn(new BigDecimal("200.00"));
        when(bills.getUtilitiesById()).thenReturn(new BigDecimal("800.00"));
        when(bills.getGroceriesById()).thenReturn(new BigDecimal("400.00"));
        when(bills.getFrequency()).thenReturn("monthly");
        return Arrays.asList(bills);
    }

       private List<Leisure> createMockLeisureList() {
        Leisure leisure = mock(Leisure.class);
        when(leisure.getEntertainmentById()).thenReturn(new BigDecimal("150.00"));
        when(leisure.getDiningOutById()).thenReturn(new BigDecimal("100.00"));
        when(leisure.getTravelById()).thenReturn(new BigDecimal("1500.00"));
        when(leisure.getSportsMembershipById()).thenReturn(new BigDecimal("70.00"));
        when(leisure.getFrequency()).thenReturn("monthly");
        return Arrays.asList(leisure);
    }
    
    }


