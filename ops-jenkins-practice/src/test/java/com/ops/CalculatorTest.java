package com.ops;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {
    private final Calculator calculator = new Calculator();

    @Test void additionWorks() { assertEquals(7, calculator.add(3, 4)); }
    @Test void subtractionWorks() { assertEquals(2, calculator.subtract(5, 3)); }
    @Test void multiplicationWorks() { assertEquals(12, calculator.multiply(3, 4)); }

    @Test void additionWithNegativeNumbersWorks() {Calculator calculator = new Calculator();assertEquals(-3, calculator.add(-5, 2));}
}
