package org.example;

public class MathOperations {

    // 1. Вычисление факториала
    public static long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Факториал отрицательного числа не определен");
        }
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    // 2. Площадь треугольника по формуле Герона
    public static double triangleArea(double a, double b, double c) {
        // Проверка: стороны должны быть положительными и образовывать треугольник
        if (a <= 0 || b <= 0 || c <= 0 || (a + b <= c) || (a + c <= b) || (b + c <= a)) {
            throw new IllegalArgumentException("Неверные стороны треугольника");
        }
        double p = (a + b + c) / 2; // Полупериметр
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    // 3. Арифметические действия
    public static int add(int a, int b) {
        return a + b;
    }

    public static int subtract(int a, int b) {
        return a - b;
    }

    public static int multiply(int a, int b) {
        return a * b;
    }

    public static int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Деление на ноль");
        }
        return a / b;
    }

    // 4. Сравнение двух чисел
    // Возвращает 1, если a > b; -1, если a < b; 0, если равны
    public static int compare(int a, int b) {
        return Integer.compare(a, b);
    }
}