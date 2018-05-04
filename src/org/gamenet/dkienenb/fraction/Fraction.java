package org.gamenet.dkienenb.fraction;

import java.util.Random;

public class Fraction extends Number {

	private static final long serialVersionUID = 9118804899352546514L;

	private final Number numerator;
	private final Number denominator;

	public Fraction(Number numerator, Number denominator) {
		this.numerator = numerator;
		this.denominator = denominator;
	}

	private static Number multiply(Number number, Number number2) {
		if (number instanceof Fraction && number2 instanceof Fraction) {
			return ((Fraction) number).multiplyWith((Fraction) number2);
		} else if (number instanceof Fraction) {
			return ((Fraction) number).multiplyWith(new Fraction(number2, 1));
		} else if (number2 instanceof Fraction) {
			return ((Fraction) number2).multiplyWith(new Fraction(number, 1));
		} else {
			return number.doubleValue() * number2.doubleValue();
		}
	}

	@Override
	public int intValue() {
		return value().intValue();
	}

	@Override
	public long longValue() {
		return value().longValue();
	}

	@Override
	public float floatValue() {
		return value().floatValue();
	}

	@Override
	public double doubleValue() {
		return value();
	}

	public Double value() {
		return numerator.doubleValue() / denominator.doubleValue();
	}


	public Fraction inverse() {
		return new Fraction(denominator, numerator);
	}

	public Fraction multiplyWith(Fraction other) {
		return new Fraction(multiply(numerator, other.numerator), multiply(denominator, other.denominator));
	}

	public Fraction divideBy(Fraction other) {
		return multiplyWith(other.inverse());
	}

	public Fraction addTo(Fraction other) {
		return null;
	}


	public boolean random(Random random) {
		return random.nextInt(denominator.intValue()) + 1 <= numerator.doubleValue();
	}

	public Number getNumerator() {
		return numerator;
	}

	public Number getDenominator() {
		return denominator;
	}

	@Override
	public String toString() {
		return "Fraction [numerator=" + numerator + ", denominator=" + denominator + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((denominator == null) ? 0 : denominator.intValue());
		result = prime * result + ((numerator == null) ? 0 : numerator.intValue());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fraction other = (Fraction) obj;
		if (denominator == null) {
			if (other.denominator != null)
				return false;
		} else if (!denominator.equals(other.denominator))
			return false;
		if (numerator == null) {
			if (other.numerator != null)
				return false;
		} else if (!numerator.equals(other.numerator))
			return false;
		return true;
	}

}
