package Week06;
public class RationalNumber {
     int numerator;
     int denominator; 
    
    public RationalNumber() {
        this(0, 1);
    }

    public RationalNumber(int numerator, int denominator) {
        if (denominator <= 0) {
            this.numerator = numerator;
            this.denominator = 1;
        } else {
            this.numerator = numerator;
            this.denominator = denominator;
        }
        reduce();
    }

    public void add(RationalNumber r) {
        this.numerator = this.numerator * r.denominator + r.numerator * this.denominator;
        this.denominator = this.denominator * r.denominator;
        reduce();
    }

    public void subtract(RationalNumber r) {
        this.numerator = this.numerator * r.denominator - r.numerator * this.denominator;
        this.denominator = this.denominator * r.denominator;
        reduce();
    }

    public void multiply(RationalNumber r) {
        this.numerator = this.numerator * r.numerator;
        this.denominator = this.denominator * r.denominator;
        reduce();
    }

    public void divide(RationalNumber r) {
        if (r.numerator == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        this.numerator = this.numerator * r.denominator;
        this.denominator = this.denominator * r.numerator;
        reduce();
    }

    public void invert() {
        int temp = this.numerator;
        this.numerator = this.denominator;
        this.denominator = temp;
        if (this.denominator == 0) {
            throw new ArithmeticException("Denominator cannot be zero after inversion");
        }
    }

    public double toDouble() {
        return (double) this.numerator / this.denominator;
    }

    public void reduce() {
        int gcd = gcd(Math.abs(numerator), denominator);
        numerator /= gcd;
        denominator /= gcd;
    }

    public String toString() {
        return numerator + "/" + denominator;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
