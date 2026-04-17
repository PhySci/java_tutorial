package java4python;

public class Fraction extends Number implements Comparable<Fraction> {
    private Integer numerator;
    private Integer denominator;

    public Fraction(Integer numerator, Integer denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Fraction(Integer numerator) {
        this.numerator = numerator;
        this.denominator = 1;
    }

    public int intValue() {
        return this.numerator.intValue() / this.denominator.intValue();
    }

    public long longValue() {
        return this.numerator.longValue() / this.denominator.longValue();
    }

    public float floatValue() {
        return this.numerator.floatValue() / this.denominator.floatValue();
    }

    public double doubleValue() {
        return this.numerator.doubleValue() / this.denominator.doubleValue();
    }

    public Integer getNumerator() {
        return numerator;
    }

    public Integer getDenominator() {
        return denominator;
    }

    public void setNumerator(Integer numerator) {
        this.numerator = numerator;
    }

    public void setDenominator(Integer denominator) {
        this.denominator = denominator;
    }

    public Fraction add(Fraction otherFrac) {
        Integer newNum = otherFrac.getNumerator() *this.getDenominator() + this.getNumerator() * otherFrac.getDenominator();
        Integer newDen = this.getDenominator() * otherFrac.getDenominator();
        Integer common = gcd(newNum, newDen);
        return new Fraction(newNum/common, newDen/common);
    }

    public Fraction add(Integer other) {
        return this.add(new Fraction(other));
    }

    private static Integer gcd(Integer m, Integer n) {
        while (m % n != 0) {
            Integer oldm = m;
            Integer oldn = n;
            m = oldn;
            n = oldm % oldn;
        }
        return n;
    }

    public String toString() {
        return this.numerator.toString() + "/" + this.denominator.toString();
    }

    public Boolean equals(Fraction other) {
        Integer num1 = this.getNumerator() * other.getDenominator();
        Integer num2 = other.getNumerator() * this.getDenominator();
        return num1.equals(num2);
    }

    public int compareTo(Fraction other) {
        Integer num1 = this.getNumerator() * other.getDenominator();
        Integer num2 = other.getNumerator() * this.getDenominator();
        return num1 - num2;
    }

    public static void main(String[] args) {
        Fraction f1 = new Fraction(100, 200);
        Fraction f2 = new Fraction(1, 2);
        if (f1.equals(f2)) {
            System.out.println("Equal objects");
        } else {
            System.out.println("Different objects");
        }
    }
}
