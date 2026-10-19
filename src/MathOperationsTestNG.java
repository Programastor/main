package org.example;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class MathOperationsTestNG {

    private org.example.MathOperations math;

    // Аналог @BeforeEach в JUnit 5. Выполняется перед каждым тестом.
    @BeforeMethod
    void setUp() {
        math = new org.example.MathOperations();
    }

    // --- Тесты для факториала ---
    @Test
    void testFactorialPositive() {
        // В TestNG assertEquals(actual, expected)
        assertEquals(org.example.MathOperations.factorial(5), 120);
        assertEquals(org.example.MathOperations.factorial(0), 1);
    }

    // В TestNG для проверки исключений используется параметр в аннотации
    @Test(expectedExceptions = IllegalArgumentException.class)
    void testFactorialNegative() {
        org.example.MathOperations.factorial(-1);
    }

    // --- Тесты для площади треугольника ---
    @Test
    void testTriangleArea() {
        // В TestNG погрешность для double указывается третьим параметром
        assertEquals(org.example.MathOperations.triangleArea(3, 4, 5), 6.0, 0.0001);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    void testTriangleAreaInvalid() {
        org.example.MathOperations.triangleArea(1, 1, 5);
    }

    // --- Тесты для арифметики ---
    // Используем DataProvider вместо @ParameterizedTest
    @DataProvider(name = "additionData")
    public Object[][] additionData() {
        return new Object[][] {
                {5, 3, 8},
                {10, -2, 8},
                {0, 0, 0}
        };
    }

    @Test(dataProvider = "additionData")
    void testAddition(int a, int b, int expected) {
        assertEquals(org.example.MathOperations.add(a, b), expected);
    }

    @Test(expectedExceptions = ArithmeticException.class)
    void testDivisionByZero() {
        org.example.MathOperations.divide(10, 0);
    }

    @Test
    void testSubtractionAndMultiplication() {
        // В TestNG assertEquals(actual, expected)
        assertEquals(org.example.MathOperations.subtract(5, 3), 2);
        assertEquals(org.example.MathOperations.multiply(5, 3), 15);
    }

    // --- Тесты для сравнения ---
    @Test
    void testCompare() {
        assertTrue(org.example.MathOperations.compare(5, 3) > 0);
        assertTrue(org.example.MathOperations.compare(3, 5) < 0);
        assertEquals(org.example.MathOperations.compare(5, 5), 0);
    }
}