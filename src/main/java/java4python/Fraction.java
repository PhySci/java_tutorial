package java4python;

public class Fraction {
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
}
