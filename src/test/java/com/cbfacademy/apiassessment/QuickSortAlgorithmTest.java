package com.cbfacademy.apiassessment;

import org.junit.jupiter.api.Test;

import com.cbfacademy.apiassessment.Algorithm.QuickSortAlgorithm;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class QuickSortAlgorithmTest {

    @Test
    void testSortDescending() {
        List<BigDecimal> percentages = new ArrayList<>();
        percentages.add(new BigDecimal("20"));
        percentages.add(new BigDecimal("5"));
        percentages.add(new BigDecimal("15"));
        percentages.add(new BigDecimal("10"));
        percentages.add(new BigDecimal("18"));

        QuickSortAlgorithm.sortDescending(percentages, 0, percentages.size() - 1);

        List<BigDecimal> expected = List.of(
                new BigDecimal("20"),
                new BigDecimal("18"),
                new BigDecimal("15"),
                new BigDecimal("10"),
                new BigDecimal("5")
        );

        assertEquals(expected.size(), percentages.size());
    
        for(int i = 0; i < expected.size(); i++ ) {
            assertEquals(expected.get(i), percentages.get(i));
        }
    }

}
