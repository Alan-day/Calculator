package org.example;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @org.junit.jupiter.api.Test
    void addition() {
        Calculator calculator = new Calculator();
        assertEquals( 2.8, calculator.add(1.4F, 1.4F), 0.001); // casting to float, delta for floating point comparisons
        assertNotEquals(2, calculator.add(1.4F, 1.4F));


    }

    @org.junit.jupiter.api.Test
    void subtract() {
    }
}