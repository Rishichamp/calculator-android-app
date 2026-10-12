package com.example.calculator;

import static com.example.calculator.Calculator.ADD;
import static com.example.calculator.Calculator.DIVIDE;
import static com.example.calculator.Calculator.MULTIPLY;
import static com.example.calculator.Calculator.REMAINDER;
import static com.example.calculator.Calculator.SUBTRACT;
import static com.example.calculator.Calculator.calculate;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CalculatorTest {

    @Test
    public void basicOperations() {
        assertEquals("Answer=3.75", calculate("1.5", "2.25", ADD));
        assertEquals("Answer=-0.75", calculate("1.5", "2.25", SUBTRACT));
        assertEquals("Answer=3.38", calculate("1.5", "2.25", MULTIPLY));
        assertEquals("Answer=3.50", calculate("7", "2", DIVIDE));
        assertEquals("Answer=1.00", calculate("7", "2", REMAINDER));
    }

    @Test
    public void divisionOrRemainderByZeroIsAnError() {
        assertEquals("Error! Cannot divide by zero", calculate("7", "0", DIVIDE));
        assertEquals("Error! Cannot divide by zero", calculate("7", "0", REMAINDER));
    }

    @Test
    public void badInputIsAnErrorNotACrash() {
        assertEquals("Number fields can't be empty", calculate("", "2", ADD));
        assertEquals("Error! Please enter valid numbers", calculate(".", "2", ADD));
        assertEquals("Error! The result is too large", calculate("1e308", "10", MULTIPLY));
    }

    @Test
    public void tinyNegativeResultIsNotMinusZero() {
        assertEquals("Answer=0.00", calculate("0.001", "0.002", SUBTRACT));
    }
}
