package com.speCalculator;

import java.util.Scanner;

public class Calculator {

    // Addition
    public double add(double a, double b) {
        return a + b;
    }

    // Subtraction
    public double subtract(double a, double b) {
        return a - b;
    }

    // Multiplication
    public double multiply(double a, double b) {
        return a * b;
    }

    // Division
    public double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return a / b;
    }

    // Power Function (a^b)
    public double power(double base, double exponent) {
        return Math.pow(base, exponent);
    }

    // Square Root
    public double sqrt(double num) {
        if (num < 0) {
            throw new ArithmeticException("Cannot compute square root of a negative number");
        }
        return Math.sqrt(num);
    }

    // Natural Logarithm (ln)
    public double naturalLog(double num) {
        if (num <= 0) {
            throw new ArithmeticException("Logarithm undefined for zero or negative numbers");
        }
        return Math.log(num);
    }

    // Factorial
    public long factorial(int num) {
        if (num < 0) {
            throw new ArithmeticException("Factorial is undefined for negative numbers");
        }
        long fact = 1;
        for (int i = 1; i <= num; i++) {
            fact *= i;
        }
        return fact;
    }

    // Main Method for User Input
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calc = new Calculator();

        while (true) {
            System.out.println("\nScientific Calculator - Choose an Operation:");
            System.out.println("1. Addition (+)");
            System.out.println("2. Subtraction (-)");
            System.out.println("3. Multiplication (*)");
            System.out.println("4. Division (/)");
            System.out.println("5. Power (x^y)");
            System.out.println("6. Square Root (√x)");
            System.out.println("7. Natural Logarithm (ln x)");
            System.out.println("8. Factorial (x!)");
            System.out.println("9. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            if (choice == 9) {
                System.out.println("Exiting Calculator...");
                break;
            }

            double num1, num2;
            switch (choice) {
                case 1: // Addition
                    System.out.print("Enter first number: ");
                    num1 = scanner.nextDouble();
                    System.out.print("Enter second number: ");
                    num2 = scanner.nextDouble();
                    System.out.println("Result: " + calc.add(num1, num2));
                    break;
                case 2: // Subtraction
                    System.out.print("Enter first number: ");
                    num1 = scanner.nextDouble();
                    System.out.print("Enter second number: ");
                    num2 = scanner.nextDouble();
                    System.out.println("Result: " + calc.subtract(num1, num2));
                    break;
                case 3: // Multiplication
                    System.out.print("Enter first number: ");
                    num1 = scanner.nextDouble();
                    System.out.print("Enter second number: ");
                    num2 = scanner.nextDouble();
                    System.out.println("Result: " + calc.multiply(num1, num2));
                    break;
                case 4: // Division
                    System.out.print("Enter first number: ");
                    num1 = scanner.nextDouble();
                    System.out.print("Enter second number: ");
                    num2 = scanner.nextDouble();
                    try {
                        System.out.println("Result: " + calc.divide(num1, num2));
                    } catch (ArithmeticException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 5: // Power
                    System.out.print("Enter base: ");
                    num1 = scanner.nextDouble();
                    System.out.print("Enter exponent: ");
                    num2 = scanner.nextDouble();
                    System.out.println("Result: " + calc.power(num1, num2));
                    break;
                case 6: // Square Root
                    System.out.print("Enter number: ");
                    num1 = scanner.nextDouble();
                    try {
                        System.out.println("Result: " + calc.sqrt(num1));
                    } catch (ArithmeticException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 7: // Natural Log
                    System.out.print("Enter number: ");
                    num1 = scanner.nextDouble();
                    try {
                        System.out.println("Result: " + calc.naturalLog(num1));
                    } catch (ArithmeticException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 8: // Factorial
                    System.out.print("Enter an integer: ");
                    int num = scanner.nextInt();
                    try {
                        System.out.println("Result: " + calc.factorial(num));
                    } catch (ArithmeticException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
        scanner.close();
    }
}