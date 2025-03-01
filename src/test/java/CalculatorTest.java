package com.speCalculator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class  CalculatorTest {
    private final Calculator calculator = new Calculator();

    // ✅ Test for Addition
    @Test
    public void testAddition() {
        assertEquals(8.0, calculator.add(5, 3));
        assertEquals(-2.0, calculator.add(-5, 3));
        assertEquals(0.0, calculator.add(0, 0));
    }

    // ✅ Test for Subtraction
    @Test
    public void testSubtraction() {
        assertEquals(2.0, calculator.subtract(5, 3));
        assertEquals(-8.0, calculator.subtract(-5, 3));
        assertEquals(0.0, calculator.subtract(5, 5));
    }

    // ✅ Test for Multiplication
    @Test
    public void testMultiplication() {
        assertEquals(15.0, calculator.multiply(5, 3));
        assertEquals(-15.0, calculator.multiply(-5, 3));
        assertEquals(0.0, calculator.multiply(5, 0));
    }

    // ✅ Test for Division
    @Test
    public void testDivision() {
        assertEquals(2.5, calculator.divide(5, 2));
        assertEquals(-2.0, calculator.divide(-6, 3));
    }

    // ❌ Test for Division by Zero (Should throw an exception)
    @Test
    public void testDivisionByZero() {
        Exception exception = assertThrows(ArithmeticException.class, () -> calculator.divide(5, 0));
        assertEquals("Cannot divide by zero", exception.getMessage());
    }

    // ✅ Test for Power
    @Test
    public void testPower() {
        assertEquals(8.0, calculator.power(2, 3));
        assertEquals(1.0, calculator.power(5, 0));
        assertEquals(0.25, calculator.power(2, -2));
    }

    // ✅ Test for Square Root
    @Test
    public void testSquareRoot() {
        assertEquals(4.0, calculator.sqrt(16));
        assertEquals(5.0, calculator.sqrt(25));
    }

    // ❌ Test for Square Root of Negative Number (Should throw an exception)
    @Test
    public void testSquareRootNegative() {
        Exception exception = assertThrows(ArithmeticException.class, () -> calculator.sqrt(-4));
        assertEquals("Cannot compute square root of a negative number", exception.getMessage());
    }

    // ✅ Test for Natural Log
    @Test
    public void testNaturalLog() {
        assertEquals(0.0, calculator.naturalLog(1));
        assertTrue(calculator.naturalLog(2.718) > 0.99); // ln(e) ≈ 1
    }

    // ❌ Test for Log of Zero or Negative (Should throw an exception)
    @Test
    public void testNaturalLogNegativeOrZero() {
        Exception exception = assertThrows(ArithmeticException.class, () -> calculator.naturalLog(0));
        assertEquals("Logarithm undefined for zero or negative numbers", exception.getMessage());

        exception = assertThrows(ArithmeticException.class, () -> calculator.naturalLog(-5));
        assertEquals("Logarithm undefined for zero or negative numbers", exception.getMessage());
    }

    // ✅ Test for Factorial
    @Test
    public void testFactorial() {
        assertEquals(120, calculator.factorial(5));
        assertEquals(1, calculator.factorial(0));
    }

    // ❌ Test for Factorial of Negative Number (Should throw an exception)
    @Test
    public void testFactorialNegative() {
        Exception exception = assertThrows(ArithmeticException.class, () -> calculator.factorial(-5));
        assertEquals("Factorial is undefined for negative numbers", exception.getMessage());
    }
}
