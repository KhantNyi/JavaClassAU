package Week06;

import java.util.Scanner;

public class RationalNumberDriver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt for the first rational number
        System.out.println("Enter the first rational number (numerator and denominator):");
        int num1 = scanner.nextInt();
        int denom1 = scanner.nextInt();
        RationalNumber r1 = new RationalNumber(num1, denom1);
        System.out.println("First Rational Number: " + r1);

        // Prompt for the second rational number
        System.out.println("Enter the second rational number (numerator and denominator):");
        int num2 = scanner.nextInt();
        int denom2 = scanner.nextInt();
        RationalNumber r2 = new RationalNumber(num2, denom2);
        System.out.println("Second Rational Number: " + r2);

        // Perform and display operations
        RationalNumber result;

        // Addition
        result = new RationalNumber(r1.numerator, r1.denominator);
        result.add(r2);
        System.out.println("Addition: " + r1 + " + " + r2 + " = " + result);

        // Subtraction
        result = new RationalNumber(r1.numerator, r1.denominator);
        result.subtract(r2);
        System.out.println("Subtraction: " + r1 + " - " + r2 + " = " + result);

        // Multiplication
        result = new RationalNumber(r1.numerator, r1.denominator);
        result.multiply(r2);
        System.out.println("Multiplication: " + r1 + " * " + r2 + " = " + result);

        // Division
        result = new RationalNumber(r1.numerator, r1.denominator);
        result.divide(r2);
        System.out.println("Division: " + r1 + " / " + r2 + " = " + result);
        
        r1.invert();
        System.out.println("Inversion of the first rational number: " + r1);

        // Reduction of the second rational number (though it is always reduced upon creation)
        r2.reduce();
        System.out.println("Reduction of the second rational number: " + r2);

        // Close the scanner
        scanner.close();
    }
}
