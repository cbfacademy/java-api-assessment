package com.cbfacademy.apiassessment;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

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

public class BudgetCalculatorTest {

    @Mock
    private IncomeService incomeService;

    @Mock
    private BenefitsAndTaxCreditsService benefitsAndTaxCreditsService;

    @Mock
    private PensionsService pensionsService;

    @Mock
    private OtherIncomeService otherIncomeService;

    @Mock
    private BillsService billsService;

    @Mock
    private LeisureService leisureService;

 @InjectMocks
    private BudgetCalculator budgetCalculator;

    private UUID id;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        id = UUID.randomUUID();
        budgetCalculator = new BudgetCalculator(incomeService, benefitsAndTaxCreditsService, pensionsService, otherIncomeService, billsService, leisureService, id);
    }

    @Test
    void testCalculateTotalIncome() {
        List<Income> incomeList = incomeList(
            new Income(null, BigDecimal.valueOf(2000), BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, "monthly")
        );
        List<BenefitsAndTaxCredits> benefitsAndTaxCredits = benefitsList(
            new BenefitsAndTaxCredits(null, BigDecimal.valueOf(100), BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, "monthly")
        );
        List<Pensions> pensionsList = pensionsList(
            new Pensions(null, BigDecimal.valueOf(300), BigDecimal.ZERO, "monthly")
        );
        List<OtherIncome> otherIncomeList = otherIncomeList(
            new OtherIncome(null, BigDecimal.valueOf(150), BigDecimal.ZERO, "monthly")
        );

        when(incomeService.getAllIncomeById(id)).thenReturn(incomeList);
        when(benefitsAndTaxCreditsService.getAllBenefitsAndTaxCreditsById(id)).thenReturn(benefitsAndTaxCredits);
        when(pensionsService.getAllPensionsById(id)).thenReturn(pensionsList);
        when(otherIncomeService.getAllOtherIncomeById(id)).thenReturn(otherIncomes);

        BigDecimal totalIncome = budgetCalculator.calculateTotalIncome();
        assertEquals(BigDecimal.valueOf(2550).setScale(2, RoundingMode.HALF_UP), totalIncome);
    }

    @Test
    void testCalculateTotalExpenses() {
        List<Bills> billsList = billsList(
            new Bills(null, BigDecimal.valueOf(500), BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, "monthly")
        );
        List<Leisure> leisureList = Arrays.asList(
            new Leisure(null, BigDecimal.valueOf(200), BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, "monthly")
        );

        when(billsService.getAllBillsById(id)).thenReturn(billsList);
        when(leisureService.getAllLeisureById(id)).thenReturn(leisureList);

        BigDecimal totalExpenses = budgetCalculator.calculateTotalExpenses();
        assertEquals(BigDecimal.valueOf(700).setScale(2, RoundingMode.HALF_UP), totalExpenses);
    }

    @Test
    void testRetrievePercentages() {
        List<Income> income = incomeList(
            new Income(null, BigDecimal.valueOf(2000), BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, "monthly")
        );
        List<BenefitsAndTaxCredits> benefitsAndTaxCredits = benefitsList(
            new BenefitsAndTaxCredits(null, BigDecimal.valueOf(100), BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, "monthly")
        );
        List<Pensions> pensionsList = pensionsList(
            new Pensions(null, BigDecimal.valueOf(300), BigDecimal.ZERO, "monthly")
        );
        List<OtherIncome> otherIncome = otherIncomeList(
            new OtherIncome(null, BigDecimal.valueOf(150), BigDecimal.ZERO, "monthly")
        );

        when(incomeService.getAllIncomeById(id)).thenReturn(income);
        when(benefitsAndTaxCreditsService.getAllBenefitsAndTaxCreditsById(id)).thenReturn(benefitsAndTaxCredits);
        when(pensionsService.getAllPensionsById(id)).thenReturn(pensionsList);
        when(otherIncomeService.getAllOtherIncomeById(id)).thenReturn(otherIncome);
        when(billsService.getAllBillsById(id)).thenReturn(billsList);
        when(leisureService.getAllLeisureById(id)).thenReturn(leisuresList);

        List<BigDecimal> percentages = budgetCalculator.retrievePercentages();
        assertEquals(3, percentages.size());
        assertEquals(BigDecimal.valueOf(1850).setScale(2,RoundingMode.HALF_UP), percentages.get(0));
        assertEquals(BigDecimal.valueOf(1725).setScale(2, RoundingMode.HALF_UP), percentages.get(1));
        assertEquals(BigDecimal.valueOf(1600).setScale(2, RoundingMode.HALF_UP), percentages.get(2));
    }

}

    
