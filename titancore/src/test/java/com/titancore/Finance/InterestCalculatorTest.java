package com.titancore.Finance;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class InterestCalculatorTest {

    @Test

    public void calculateCompoundInterestTest() {
        // Arrange
        InterestCalculator myInterestCalculator = new InterestCalculator();
        double initialCapital = 1500;
        double annualInterestRate = 4.3;
        int years = 6;
        double expectedFinalCapital = 1931;

        // Act
        double finalCapital = myInterestCalculator.calculateCompoundInterest(initialCapital, annualInterestRate, years);

        // Assert
        assertEquals(finalCapital, expectedFinalCapital, 0);
    }

}
