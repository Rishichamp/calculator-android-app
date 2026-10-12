package com.example.calculator;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Decimal arithmetic behind the calculator screen.
 * Kept free of Android types so it can be unit-tested, and it never throws:
 * every bad input comes back as a message to show the user.
 */
final class Calculator {

    // Positions in the R.array.operators spinner.
    static final int ADD = 0;
    static final int SUBTRACT = 1;
    static final int MULTIPLY = 2;
    static final int DIVIDE = 3;
    static final int REMAINDER = 4;

    private Calculator() {
    }

    static String calculate(String first, String second, int operation) {
        if (first.trim().isEmpty() || second.trim().isEmpty()) {
            return "Number fields can't be empty";
        }
        double a;
        double b;
        try {
            a = Double.parseDouble(first.trim());
            b = Double.parseDouble(second.trim());
        } catch (NumberFormatException e) {
            // e.g. a lone "." which the decimal keyboard allows
            return "Error! Please enter valid numbers";
        }
        double r;
        switch (operation) {
            case ADD:
                r = a + b;
                break;
            case SUBTRACT:
                r = a - b;
                break;
            case MULTIPLY:
                r = a * b;
                break;
            case DIVIDE:
                if (b == 0) {
                    return "Error! Cannot divide by zero";
                }
                r = a / b;
                break;
            case REMAINDER:
                if (b == 0) {
                    return "Error! Cannot divide by zero";
                }
                r = a % b;
                break;
            default:
                return "Error! Unknown operation";
        }
        if (Double.isNaN(r) || Double.isInfinite(r)) {
            return "Error! The result is too large";
        }
        // BigDecimal avoids "-0.00" and scientific notation for large results.
        return "Answer=" + BigDecimal.valueOf(r).setScale(2, RoundingMode.HALF_UP).toPlainString();
    }
}
