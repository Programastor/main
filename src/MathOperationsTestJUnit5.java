package org.example;

import org.example.MathOperations;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class MathOperationsTestJUnit5 {

    private MathOperations math;

    // Этот метод выполняется ПЕРЕД каждым тестом (аналог конструктора для тестов)
    @BeforeEach
    void setUp() {
        math = new MathOperations();
    }

    // --- Тесты для факториала ---
    @Test
    void testFactorialPositive() {
        assertEquals(120, MathOperations.factorial(5)); // 5! = 120
        assertEquals(1, MathOperations.factorial(0));   // 0! = 1
    }

    @Test
    void testFactorialNegative() {
        // Проверяем, что при передаче -1 будет выброшено исключение
        assertThrows(IllegalArgumentException.class, () -> MathOperations.factorial(-1));
    }

    // --- Тесты для площади треугольника ---
    @Test
    void testTriangleArea() {
        // Прямоугольный треугольник 3-4-5, площадь = 6
        // Третий параметр (0.0001) — это погрешность для чисел с плавающей точкой (double)
        assertEquals(6.0, MathOperations.triangleArea(3, 4, 5), 0.0001);
    }

    @Test
    void testTriangleAreaInvalid() {
        // Треугольник со сторонами 1, 1, 5 не существует (1+1 < 5)
        assertThrows(IllegalArgumentException.class, () -> MathOperations.triangleArea(1, 1, 5));
    }

    // --- Тесты для арифметики ---
    // Используем параметризованный тест, чтобы не писать 100 одинаковых методов
    @ParameterizedTest
    @CsvSource({"5, 3, 8", "10, -2, 8", "0, 0, 0"})
    void testAddition(int a, int b, int expected) {
        assertEquals(expected, MathOperations.add(a, b));
    }

    @Test
    void testDivisionByZero() {
        assertThrows(ArithmeticException.class, () -> MathOperations.divide(10, 0));
    }

    @Test
    void testSubtractionAndMultiplication() {
        assertEquals(2, MathOperations.subtract(5, 3));
        assertEquals(15, MathOperations.multiply(5, 3));
    }

    // --- Тесты для сравнения ---
    @Test
    void testCompare() {
        assertTrue(MathOperations.compare(5, 3) > 0);  // 5 > 3
        assertTrue(MathOperations.compare(3, 5) < 0);  // 3 < 5
        assertEquals(0, MathOperations.compare(5, 5)); // 5 == 5
    }
}