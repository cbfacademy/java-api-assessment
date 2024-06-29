package com.cbfacademy.apiassessment;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cbfacademy.apiassessment.Algorithm.QuickSortAlgorithm;
import com.cbfacademy.apiassessment.User.UserService;

@SpringBootTest
public class QuickSortAlgorithmTest {

    @MockBean
    private UserService userService;

    private QuickSortAlgorithm quickSortAlgorithm;

    @BeforeEach
    void setUp() {
        // Initialize QuickSortAlgorithm with mock UserService
        quickSortAlgorithm = new QuickSortAlgorithm(userService);
    }

    @Test
    void testSortAllUsersPercentage() {
        // Mock data for userService.getAllUsersPercentages()
        List<BigDecimal> inputPercentages = Arrays.asList(
            new BigDecimal("20"),
            new BigDecimal("15"),
            new BigDecimal("10")
        );

        // Mock behavior of userService.getAllUsersPercentages()
        when(userService.getAllUsersPercentages()).thenReturn(inputPercentages);

        // Call the sorting method
        List<BigDecimal> sortedPercentages = quickSortAlgorithm.sortAllUsersPercentage();

        // Expected sorted order
        List<BigDecimal> expected = Arrays.asList(
            new BigDecimal("20"),
            new BigDecimal("15"),
            new BigDecimal("10")
        );

        // Assert that the sorted list matches the expected order
        assertIterableEquals(expected, sortedPercentages);
    }
}
