package com.epam.engx.cleancode.naming.task3;

public class HarshadNumberGenerator {

    final String NEW_LINE = "\n";
    final int DECIMAL_BASE = 10;

    public String getHarshadNumbersString(long limit) {
        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= limit; i++) {
            if (i % getSumOfDigits(i) == 0) {
                result.append(i).append(NEW_LINE);
            }
        }
        return result.toString();
    }

    private int getSumOfDigits(int number) {
        int sum = 0;
        while (number != 0) {
            sum += number % DECIMAL_BASE;
            number = number / DECIMAL_BASE;
        }
        return sum;
    }
}
