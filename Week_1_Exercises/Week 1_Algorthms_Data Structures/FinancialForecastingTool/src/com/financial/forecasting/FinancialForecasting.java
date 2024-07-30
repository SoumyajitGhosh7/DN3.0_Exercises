package com.financial.forecasting;

import java.util.Scanner;

public class FinancialForecasting {

    // Recursive method to calculate future value
    public static double futureValue(double presentValue, double growthRate, int years) {
        if (years == 0) {
            return presentValue;
        }
        return futureValue(presentValue * (1 + growthRate/100), growthRate, years - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter present value: ");
        double presentValue = scanner.nextDouble();

        System.out.print("Enter annual growth rate(%) : ");
        double growthRate = scanner.nextDouble();

        System.out.print("Enter number of years into the future: ");
        int years = scanner.nextInt();

        double predictedFutureValue = futureValue(presentValue, growthRate, years);
        System.out.println("The predicted future value is: " + predictedFutureValue);

        scanner.close();
    }
}
