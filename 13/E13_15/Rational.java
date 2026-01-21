import java.math.BigInteger;

public class Rational extends Number implements Comparable<Rational> {
  private BigInteger numerator = ZERO;
  private BigInteger denominator = ONE;
  private static final BigInteger ONE = new BigInteger("1");
  private static final BigInteger NEG_ONE = new BigInteger("-1");
  private static final BigInteger ZERO = new BigInteger("0");

  public Rational() {
    this(ZERO, ONE);
  }

  public Rational(BigInteger numerator, BigInteger denominator) {
    BigInteger gcd = gcd(numerator, denominator);
    this.numerator =
      ((denominator.compareTo(ZERO) == 1) ? ONE: NEG_ONE).multiply(numerator)
      .divide(gcd);
    this.denominator = denominator.abs().divide(gcd);
  }

  private static BigInteger gcd(BigInteger n, BigInteger d) {
    BigInteger n1 = n.abs();
    BigInteger n2 = d.abs();
    BigInteger gcd = ONE;

    for (BigInteger k = ONE;
        (k.compareTo(n1) == -1 || k.equals(n1)) &&
        (k.compareTo(n2) == -1 || k.equals(n2));
         k = k.add(ONE)) {
      if (n1.remainder(k).equals(ZERO) &&
          n2.remainder(k).equals(ZERO)) {
        gcd = k;
      }
    }

    return gcd;
  }

  public BigInteger getNumerator() {
    return numerator;
  }

  public BigInteger getDenominator() {
    return denominator;
  }

  public Rational add(Rational secondRational) {
    BigInteger n = (numerator.multiply(secondRational.getDenominator()))
      .add((denominator.multiply(secondRational.getNumerator())));
    BigInteger d = denominator.multiply(secondRational.getDenominator());
    return new Rational(n, d);
  }

  public Rational subtract(Rational secondRational) {
    BigInteger n =
      (numerator.multiply(secondRational.getDenominator())).subtract(
      (denominator.multiply(secondRational.getNumerator())));
    BigInteger d = denominator.multiply(secondRational.getDenominator());
    return new Rational(n, d);
  }

  public Rational multiply(Rational secondRational) {
    BigInteger n = numerator.multiply(secondRational.getNumerator());
    BigInteger d = denominator.multiply(secondRational.getDenominator());
    return new Rational(n, d);
  }

  public Rational divide(Rational secondRational) {
    BigInteger n = numerator.multiply(secondRational.getDenominator());
    BigInteger d = denominator.multiply(secondRational.getNumerator());
    return new Rational(n, d);
  }

  @Override
  public String toString() {
    if (denominator.equals(ONE)) {
      return numerator + "";
    } else {
      return numerator + "/" + denominator;
    }
  }

  @Override
  public boolean equals(Object other) {
    if ((this.subtract((Rational)(other))).getNumerator().equals(ZERO)) {
      return true;
    }
    return false;
  }

  @Override
  public int intValue() {
    return (int)doubleValue();
  }

  @Override
  public float floatValue() {
    return (float)doubleValue();
  }

  @Override
  public double doubleValue() {
    return numerator.doubleValue() / denominator.doubleValue();
  }

  @Override
  public long longValue() {
    return (long)doubleValue();
  }

  @Override
  public int compareTo(Rational o) {
    if (this.subtract(o).getNumerator().compareTo(ZERO) == 1) {
      return 1;
    } else if (this.subtract(o).getNumerator().compareTo(ZERO) == -1) {
      return -1;
    }
    return 0;
  }
}
