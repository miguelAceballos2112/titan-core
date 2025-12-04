package com.titancore.Finance;

public class InterestCalculator {

    public static double calculateCompoundInterest(double initialCapital, double annualInterestRate, int years) {
        double rateDecimal = annualInterestRate / 100.0;
        double finalAmountFactor = Math.pow(1 + rateDecimal, years);
        double finalCapital = initialCapital * finalAmountFactor;
        return Math.round(finalCapital);
    }

}
